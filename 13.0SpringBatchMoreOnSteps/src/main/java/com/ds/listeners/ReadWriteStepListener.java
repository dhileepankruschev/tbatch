package com.ds.listeners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;

public class ReadWriteStepListener implements StepExecutionListener {

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		String stepName = stepExecution.getStepName();
		System.out.println("After "+stepName+" execution");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stepExecution.getExitStatus();
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		String stepName = stepExecution.getStepName();
		System.out.println("Before "+stepName+" execution");
		
		ExecutionContext jobExecutionContext = stepExecution.getJobExecution().getExecutionContext();

		System.out.println("\n\n**************************");
		System.out.println("Message from step1: "+jobExecutionContext.getString("message"));
		System.out.println("**************************\n\n");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
