package com.tkhts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.myapp.service.MyService;

public class AspectTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		MyService service = (MyService) applicationContext.getBean("myService");
		System.out.println(service.getClass().getName());
		service.doService();
	}
}
