package com.ds.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.PlatformTransactionManager;

import com.ds.Product;
import com.ds.datasource.initializer.DataSourceInitializer;
import com.ds.processor.CustomItemProcessor;
import com.ds.readers.R1_CharacterBasedFileReader;
import com.ds.writers.ProductWriter;
import com.ds.writers.W01_JdbcWriter;
import com.ds.writers.W02_FlatFileWriter;

@Configuration
@EnableBatchProcessing
public class AppConfig {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;


	@Bean
	public ItemReader<Product> reader(){
		return R1_CharacterBasedFileReader.getReader();		
	}

    @Bean
    public ItemWriter<Product> writer() {
        return new ProductWriter();
//        return W01_JdbcWriter.getWriter(datasource());
//        return W02_FlatFileWriter.getWriter();
    }
    
/*    @Bean
    public JdbcBatchItemWriter getJdbcWriter(){
    	JdbcBatchItemWriter jdbcWriter = new JdbcBatchItemWriter();
    	jdbcWriter.setDataSource(new DataSourceInitializer().getDataSource());
    	jdbcWriter.setSql("insert into RAW_REPORT(DATE,IMPRESSIONS,CLICKS,EARNING) values (:date, :impressions, :clicks, :earning)");
    	return jdbcWriter;
    }
*/
	@Bean
	public ItemProcessor<Product, Product> getProcessor() {
		return new CustomItemProcessor();
	}

    @Bean
    @Scope("prototype")
    public Product getProduct() {
        return new Product();
    }
    
    
	@Bean
	public Step readWriteStep() {
		return stepBuilderFactory.get("readWriteStep").<Product, Product> chunk(10)
				.reader(reader())
				.processor(getProcessor())
				.writer(writer())
				.build();
	}
	
    @Bean
    @Scope("prototype")
    public DataSource datasource() {
        return new DataSourceInitializer().getDataSource();
    }

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job").start(readWriteStep()).build();
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }
/*
    @Bean
    public JobRepository jobRepository() throws Exception {
        return new MapJobRepositoryFactoryBean(transactionManager()).getObject();
    }
*/

    @Bean
    public JobRepository jobRepository() throws Exception {
    	JobRepositoryFactoryBean jobRepository = new JobRepositoryFactoryBean();
    	jobRepository.setTransactionManager(transactionManager());
    	jobRepository.setDatabaseType("mysql");
    	jobRepository.setDataSource(datasource());
//    	jobRepository.setDataSource(dataSource());
        return jobRepository.getObject();
    }

    @Bean
    public JobLauncher jobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository());
        return jobLauncher;
    }
}
