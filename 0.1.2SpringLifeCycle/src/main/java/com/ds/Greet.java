package com.ds;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Greet implements InitializingBean, DisposableBean{

	public void greetCustomer() {

		System.out.println("Welcome !! This is the LifeCyce demo");
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("Bean is going through afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {

		System.out.println("Bean is destroying now");
	}



}