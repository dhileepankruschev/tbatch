package com.ds.sheduler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("job/01-job-sheduler-config.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("job/02-annot-job-sheduler-config.xml");

	}
}
