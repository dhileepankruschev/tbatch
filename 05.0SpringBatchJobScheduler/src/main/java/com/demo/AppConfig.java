package com.demo;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.demo.bank.MyBank;
import com.demo.record.Record;
import com.demo.util.Printer;

@Configuration
@ComponentScan
@EnableScheduling
public class AppConfig {

	@Scheduled(fixedRate = 5000)
	public void runIfscTransactions() {
		List<Record> records = MyBank.fetchPendingTransactions();
		for (Record record : records) {
			Printer.syso("Checking if sufficient amount is available to start the transaction...");
			MyBank.startTransaction(record);
		}
	}

	/*
	 * @Scheduled(fixedDelay = 5000) public void fixedDelayTask() {
	 * System.out.println(new Date() + " This runs in a fixed delay"); }
	 * 
	 * @Scheduled(fixedRate = 6000) public void fixedRateTask() {
	 * System.out.println(new Date() + " This runs in a fixed rate"); }
	 * 
	 * @Scheduled(fixedRate = 7000, initialDelay = 2000) public void
	 * fixedRateWithInitialDelayTask(){ System.out.println(new Date() +
	 * " This runs in a fixed delay with a initial delay"); }
	 * 
	 * @Scheduled(cron = "10 * * * * *") public void cronTask(){
	 * System.out.println(new Date() + " This runs in a cron schedule"); }
	 */
}