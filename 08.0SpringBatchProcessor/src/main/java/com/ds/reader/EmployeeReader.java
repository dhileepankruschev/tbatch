package com.ds.reader;

import org.springframework.batch.item.adapter.ItemReaderAdapter;

import com.ds.entity.Employee;
import com.ds.service.MyService;
import com.ds.service.MyServiceAdapter;

public class EmployeeReader {
	public static ItemReaderAdapter<Employee> getReader(){
		ItemReaderAdapter<Employee> adapter = new ItemReaderAdapter<Employee>();
		MyServiceAdapter employeeServiceAdapter = new MyServiceAdapter(new MyService());
		adapter.setTargetMethod("nextEmployee");
		adapter.setTargetObject(employeeServiceAdapter);
		return adapter;
	}

}
