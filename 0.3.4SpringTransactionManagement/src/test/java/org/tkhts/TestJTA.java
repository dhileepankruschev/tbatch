package org.tkhts;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.tx.entity.TableOne;
import com.spring.tx.entity.TableTwo;
import com.spring.tx.service.TransactionalService;

public class TestJTA {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext context = new 
                ClassPathXmlApplicationContext("spring-config.xml");
		
		TransactionalService transactionalService = context.getBean(TransactionalService.class);
      
		TableOne tableOne = new TableOne();
		tableOne.setValue("value1");
		
		TableTwo tableTwo = new TableTwo();
		tableTwo.setValue("value2");
		
		try {
			transactionalService.persist(tableOne, tableTwo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
