package com.ds.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.PlatformTransactionManager;

import com.ds.entity.Contact;
import com.ds.entity.Employee;
import com.ds.processor.CustomFilterItemProcessor;
import com.ds.reader.EmployeeReader;
import com.ds.writer.ContactWriter;


@Configuration
@EnableBatchProcessing
public class AppConfig {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;


	@Bean
	public ItemReader<Employee> reader(){
		return EmployeeReader.getReader();
	}

    @Bean
    public ItemWriter<Contact> writer() {
        return new ContactWriter();
    }

	@Bean
	public ItemProcessor<Employee, Contact> getProcessor() {
		return new CustomFilterItemProcessor();
	}

    @Bean
    @Scope("prototype")
    public Employee getEmployee() {
        return new Employee();
    }
    
    
	@Bean
	public Step readWriteStep() {
		return stepBuilderFactory.get("readWriteStep").<Employee, Contact> chunk(10)
				.reader(reader())
				.processor(getProcessor())
				.writer(writer())
				.build();
	}
	
    @Bean
    public Job job() {
        return jobBuilderFactory.get("job").start(readWriteStep()).build();
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }

    @Bean
    public JobRepository jobRepository() throws Exception {
        return new MapJobRepositoryFactoryBean(transactionManager()).getObject();
    }

    @Bean
    public JobLauncher jobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository());
        return jobLauncher;
    }

}
