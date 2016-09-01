package com.ds.listeners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;

public class DecompressStepListener implements StepExecutionListener {

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

		ExecutionContext jobExecutionContext = stepExecution.getJobExecution().getExecutionContext();
		jobExecutionContext.putString("message", "some message from step1");

		ExitStatus exitStatus = new ExitStatus("INTERRUPTED", "Intentionally setting the exit status to interrupte");
		stepExecution.setExitStatus(exitStatus);

		return stepExecution.getExitStatus();
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		String stepName = stepExecution.getStepName();
		System.out.println("Before "+stepName+" execution");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
