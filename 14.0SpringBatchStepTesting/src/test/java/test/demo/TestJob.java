package test.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.demo.AppConfig;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(loader=(Class<? extends ContextLoader>) AppConfig.class)
//@ContextConfiguration(loader=AppConfig.class)

@ContextConfiguration(classes=AppConfig.class, loader=AnnotationConfigContextLoader.class)
public class TestJob {

	@Autowired
	JobLauncher launcher;
	@Autowired
	Job job;
	
	@Test
	public void test() {
		try {
			JobExecution execution = launcher.run(job, new JobParameters());
			System.out.println(execution.getStatus());
		} catch (JobExecutionAlreadyRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobRestartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
