package com.demo.batch;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.BatchStatus;

import com.demo.batch.util.MainHelper;

import java.util.Properties;

public class MainJobOperator2 {

    private static final JobOperator operator = BatchRuntime.getJobOperator();

    public static void main(String... args) throws InterruptedException {

        long executionId = operator.start("importUserJob", new Properties());

        while(!isItDoneYet(executionId)) {
            Thread.sleep(1000);
        }

        MainHelper.reportResults(operator, executionId);
    }

    private static boolean isItDoneYet(long executionId) {
    	com.demo.batch.components.listener.DatabaseIntializer d = null;
        BatchStatus batchStatus = operator.getJobExecution(executionId).getBatchStatus();
        return batchStatus.compareTo(BatchStatus.STOPPED) > 0;
    }
}
