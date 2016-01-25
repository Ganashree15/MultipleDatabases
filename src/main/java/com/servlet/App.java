package com.servlet;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.EmployeeA;
import com.model.EmployeeB;
import com.service.EmployeeService;

public class App {

	public static void main(String[] args) throws Exception {
		System.out.println("load context");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeA em1 = new EmployeeA();
		em1.setName("Gana");
		em1.setAge(24L);
		EmployeeB em2 = new EmployeeB();
		em2.setName("Appu");
		em2.setAge(25L);
		EmployeeService emService = (EmployeeService) context.getBean("employeeService");
		emService.persistEmployees(em1, em2);
		context.close();
	}

}
