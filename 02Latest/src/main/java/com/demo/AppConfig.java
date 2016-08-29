package com.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.demo.mapper.UserFieldSetMapper;

@Configuration
@EnableBatchProcessing
public class AppConfig {
	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
//    @Bean
//    public Step step2(){
//    	return stepBuilderFactory.get("step1").<User,User>chunk(10).reader(reader()).writer(writer()).build();
//    }
//    
//    @Bean
//    public ItemWriter<User> writer2(){
//    	return new Impl(); //Extends ItemWriter
//    }
    @Bean 
    public FlatFileItemReader<User> reader(){
    	FlatFileItemReader<User> reader = new FlatFileItemReader<User>();
    	reader.setResource(new ClassPathResource("test.csv"));
    	
    	
    	DefaultLineMapper<User> lineMapper = new DefaultLineMapper<User>();
    	
    	DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
    	tokenizer.setNames(new String[] {"id","name","age"});
    	lineMapper.setLineTokenizer(tokenizer);
    	
    	FieldSetMapper<User> fieldSetMapper = new UserFieldSetMapper();
    	
    	lineMapper.setFieldSetMapper(fieldSetMapper);
    	
    	reader.setLineMapper(lineMapper);
    	return reader;
    }
    

//    @Bean
//    public FlatFileItemReader<User> reader() {
//        FlatFileItemReader<User> reader = new FlatFileItemReader<User>();
//        reader.setResource(new ClassPathResource("test.csv"));
//        reader.setLineMapper(new DefaultLineMapper<User>() {{
//            setLineTokenizer(new DelimitedLineTokenizer() {{
//                setNames(new String[] { "id", "name", "age" });
//            }});
//            setFieldSetMapper(new BeanWrapperFieldSetMapper<User>() {{
//                setTargetType(User.class);
//            }});
//        }});
//        return reader;
//    }
    
    @Bean
    public ItemWriter<User> writer() {
        return new LogUserWriter();
    }
//    @Bean
//    public ItemReader<User> reader() {
//        return new MyReader();
//    }
    
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<User, User> chunk(10)
                .reader(reader())
//                .processor(processor())
                .writer(writer())
                .build();
    }
     

    @Bean
    @Scope("prototype")
    public User hello() {
        return new User();
    }
    
    @Bean
    public Job job() {
        return jobBuilderFactory.get("helloWorldJob").start(step1()).build();
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }

    @Bean
    public JobRepository jobRepository() throws Exception {
        //return new MapJobRepositoryFactoryBean(transactionManager()).getJobRepository();
        return new MapJobRepositoryFactoryBean(transactionManager()).getObject();
    }

    @Bean
    public JobLauncher jobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository());
        return jobLauncher;
    }

    
    
}
