package com.ds.service;

import java.util.List;

import com.ds.entity.Employee;


public class MyServiceAdapter {
	private MyService myService;
	private List<Employee> employees;
	
	private int count = 0;

	public MyServiceAdapter(MyService myService){
		this.myService = myService;
		this.employees = this.myService.getEmployees();
	}


	public Employee nextEmployee() {
		if (count<employees.size()) {
			return employees.get(count++);
		} else {
			return null;
		}
	}

}