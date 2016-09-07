package com.ds.sheduler;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

public class SpringSchedulingLauncher {
	private Job job;
	private JobLauncher jobLauncher;

	public void launchSheduler() throws Exception {
		JobParameters jobParams = createJobParameters();
		jobLauncher.run(job, jobParams);
	}

	private JobParameters createJobParameters() {
		JobParametersBuilder builder = new JobParametersBuilder();
		builder.addDate("date", new Date());

		return builder.toJobParameters();
	}
	
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public JobLauncher getJobLauncher() {
		return jobLauncher;
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}


}