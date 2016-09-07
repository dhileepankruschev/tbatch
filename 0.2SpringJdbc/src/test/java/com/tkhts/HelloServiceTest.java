package com.tkhts;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.tkhts.dao.StudentJDBCTemplate;
import com.tkhts.entity.Student;


public class HelloServiceTest {

	@Before
	public void setUp() throws Exception {
		/*
		 * Create a database test 
		 * 
		 * Create Student table in test database
		 * create table Student (id int not null AUTO_INCREMENT PRIMARY KEY, name varchar(20), age int);
		 */
	}

	
	@Test
	@Transactional
	public void test() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

	       StudentJDBCTemplate studentJDBCTemplate = 
	       (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
	       
	       System.out.println("------Records Creation--------" );
	       studentJDBCTemplate.create("Zara", 11);
	       studentJDBCTemplate.create("Nuha", 2);
	       studentJDBCTemplate.create("Ayan", 15);

	       System.out.println("------Listing Multiple Records--------" );
	       List<Student> students = studentJDBCTemplate.listStudents();
	       for (Student record : students) {
	          System.out.print("ID : " + record.getId() );
	          System.out.print(", Name : " + record.getName() );
	          System.out.println(", Age : " + record.getAge());
	       }

	       System.out.println("----Updating Record with ID = 2 -----" );
	       studentJDBCTemplate.update(2, 20);

	       System.out.println("----Listing Record with ID = 2 -----" );
	       Student student = studentJDBCTemplate.getStudent(2);
	       System.out.print("ID : " + student.getId() );
	       System.out.print(", Name : " + student.getName() );
	       System.out.println(", Age : " + student.getAge());
	}

}
