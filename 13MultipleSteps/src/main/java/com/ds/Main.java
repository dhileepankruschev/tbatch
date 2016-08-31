package com.ds;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.support.ListItemWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String[] config = { "job/job-config.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(config);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("importProducts");
		JobParameters jobParameters = new JobParametersBuilder().addString("price", "100").toJobParameters();		

		try {
			JobExecution execution = jobLauncher.run(job, jobParameters);
			System.out.println("Exit Status : " + execution.getStatus());
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
	         e.printStackTrace();
	      }


		List<? extends Product> results = ((ListItemWriter<Product>) context.getBean("writer")).getWrittenItems();
	      for (Product product : results) {
	         System.out.println("Found <" + product + "> in the result.");
	      }
		
		((ConfigurableApplicationContext) context).close();
		System.out.println("Done");

	}

}