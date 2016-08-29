package com.demo;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("foo-reader")
@Scope("step")
public final class MyReader implements ItemReader<User> {
 
 String fileName;
	
  public User read() throws Exception {
	  
    System.out.println("Reader ... ");
    System.out.println(this.fileName);
    return new User(21,"Ravi", 34); 
  }

//  @Value("#{jobParameters['fileName']}")
//  public void setFileName(final String name) {
//    this.fileName = name;
//  }
}