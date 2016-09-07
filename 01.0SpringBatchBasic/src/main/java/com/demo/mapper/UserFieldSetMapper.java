package com.demo.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.demo.User;


public class UserFieldSetMapper implements FieldSetMapper<User> {
	
	public User mapFieldSet(FieldSet fieldSet) throws BindException {
		
		User user  = new User();
		user.setId(fieldSet.readInt(0));
		user.setName(fieldSet.readString(1));
		user.setAge(fieldSet.readInt(2));		
		return user;
		
	}

}