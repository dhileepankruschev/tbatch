package com.ds;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Greet {

	public void greetCustomer() {

		System.out.println("Welcome !! This is the LifeCyce demo");
	}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {

		System.out.println("Bean is going through afterPropertiesSet : using annotations");
	}

	@PreDestroy
	public void destroy() throws Exception {

		System.out.println("Bean is destroying now : using annotations");
	}

}