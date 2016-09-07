package com.ds.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ds.customer.bo.CustomerBo;

public class Main {
	public static void main(String[] args) throws Exception {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("SpringConfig.xml");

		CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
		//customer.addCustomer();
		
		//customer.addCustomerReturnValue();
		
		//customer.addCustomerThrowException();
		
		customer.addCustomerAround("domS");

	}
}