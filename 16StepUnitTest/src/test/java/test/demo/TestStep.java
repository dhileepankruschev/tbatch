package test.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.demo.AppConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class, loader=AnnotationConfigContextLoader.class)
public class TestStep {

	@Autowired
	JobRepository jobRepository;
	@Autowired
	JobLauncher jobLauncher;
	@Autowired
	Job job;
	JobLauncherTestUtils jobLauncherTestUtils = new JobLauncherTestUtils();
	
	
	@Test
	public void testStep() {
		jobLauncherTestUtils.setJobLauncher(jobLauncher);
		jobLauncherTestUtils.setJob(job);
		jobLauncherTestUtils.setJobRepository(jobRepository);
//		Map<String, JobParameter> params = new HashMap();
		//determine job params here:
//		params.put(....);
		
//		JobParameters jobParams = new JobParameters(params);
		JobParameters jobParams = new JobParameters();
		ExecutionContext context = new ExecutionContext();
		//put something to job context, if you need.
//		context.put(...);
		JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1",jobParams,context);

		Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}

	@Test
	public void testStepWithJobParameters() {
		jobLauncherTestUtils.setJobLauncher(jobLauncher);
		jobLauncherTestUtils.setJob(job);
		jobLauncherTestUtils.setJobRepository(jobRepository);
		Map<String, JobParameter> params = new HashMap();
		//determine job params here:
		params.put("someValue", new JobParameter("Parameterised JobParameter"));
		
		JobParameters jobParams = new JobParameters(params);
		ExecutionContext context = new ExecutionContext();
		
		//put something to job context, if you need.
		context.put("someValueToContext", "Hello Execution Context");
		JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1",jobParams,context);

		Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}

}
