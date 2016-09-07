package com.ds.processor;

import org.springframework.batch.item.ItemProcessor;

import com.ds.entity.Contact;
import com.ds.entity.Employee;

public class CustomFilterItemProcessor implements ItemProcessor<Employee, Contact> {

	public Contact process(Employee emp) throws Exception {
		
//		return emp.getContact();
		return needsToBeFiltered(emp) ? emp.getContact() : null;
	}
	
	
	private boolean needsToBeFiltered(Employee emp) {
		if(emp.getSalary()<=20000){
			System.out.println("Processing..." + emp);
			return true;
		}
		return false;
	}

}