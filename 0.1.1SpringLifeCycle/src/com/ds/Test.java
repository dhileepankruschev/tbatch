package com.ds;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		
		/* Destroy all the beans in the context when main method exits */
		((AbstractApplicationContext)context).registerShutdownHook();
		
		Greet obj = (Greet) context.getBean("greetBean");
		obj.greetCustomer();

	}
}