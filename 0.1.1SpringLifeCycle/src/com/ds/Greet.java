package com.ds;

public class Greet {

	public void greetCustomer() {

		System.out.println("welcome !! this is the LifeCycle demo");
	}
	
	public void afterInit() {
		System.out.println("Bean is going through init.");
	}

	public void beforeDestroy() {
		System.out.println("Bean will destroy now.");
	}

}