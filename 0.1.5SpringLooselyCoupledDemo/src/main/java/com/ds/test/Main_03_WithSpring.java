package com.ds.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ds.format.FormatHelperSpring;

public class Main_03_WithSpring {
	
	/*
	 * elegant, highly flexible and facilitates maintainability
	 * 
	 * especially in large Java project
	 * 
	 */

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"SpringConfig.xml"});

		FormatHelperSpring format = (FormatHelperSpring)context.getBean("formatHelperSpring");
		format.generateFormat();
	}
}
