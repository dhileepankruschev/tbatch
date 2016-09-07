package com.ds.sheduler;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;

public class SpringAnnotatedSchedulingLauncher {
	private Job job;
	private JobLauncher jobLauncher;

//	@Scheduled(fixedRate=2000)
//	@Scheduled(fixedDelay=2000)
//	@Scheduled(initialDelay=1000, fixedRate=5000)//initialDelay is wait before first execution of method
//	@Scheduled(cron="*/5 * * * * MON-FRI")
	@Scheduled(cron="0/5 1/1 * 1/1 * ?")
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