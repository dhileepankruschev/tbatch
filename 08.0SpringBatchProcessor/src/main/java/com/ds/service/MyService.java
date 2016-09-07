package com.ds.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.entity.Employee;
import com.google.gson.Gson;

@Service
public class MyService {

	public List<Employee> getEmployees() {
		File file = new File("input/employee.json");

		return fetchDataFromJson(file.getAbsolutePath());
	}

	private List<Employee> fetchDataFromJson(String filePath) {
		Employee[] employees = null;
		try {
			StringBuffer jb = new StringBuffer();
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			employees = new Gson().fromJson(reader, Employee[].class);

		} catch (FileNotFoundException e) {
			System.out.println("File not found with path " + filePath);
		}
		return Arrays.asList(employees);
	}

}
