package com.demo;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class LogUserWriter implements ItemWriter<User> {

	public void write(List<? extends User> users) throws Exception {
		System.out.println(users);

	}

}
