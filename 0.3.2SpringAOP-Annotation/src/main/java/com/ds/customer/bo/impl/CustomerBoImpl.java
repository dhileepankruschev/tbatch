package com.ds.customer.bo.impl;

import com.ds.customer.bo.CustomerBo;

public class CustomerBoImpl implements CustomerBo {

	public void addCustomer(){
		System.out.println("adding customer");
	}
	
	public String addCustomerReturnValue(){
		System.out.println("returning addCustomer return value");
		return "customer_01";
	}
	
	public void addCustomerThrowException() throws Exception {
		System.out.println("Throwing exception ");
		throw new Exception("Error");
	}
	
	public void addCustomerAround(String name){
		System.out.println("In addCustomerAround method, args : " + name);
	}
}