package com.ds.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.ds.entity.Contact;

public class ContactWriter implements ItemWriter<Contact> {

	public void write(List<? extends Contact> contacts) throws Exception {
		for(Contact contact: contacts){
			System.out.println("Sending appraisal mail to "+contact.getEmail());
		}
	}

}
