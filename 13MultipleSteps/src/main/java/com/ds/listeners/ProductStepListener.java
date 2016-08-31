package com.ds.listeners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class ProductStepListener implements StepExecutionListener {

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("After step execution");
		// find jobOperator here
		ExitStatus status = stepExecution.getExitStatus();
		return status;
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		System.out.println("Befoare step execution");
	}

}
