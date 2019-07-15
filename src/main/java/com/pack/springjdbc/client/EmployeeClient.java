package com.pack.springjdbc.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pack.springjdbc.model.Employee;
import com.pack.springjdbc.service.EmployeeService;

public class EmployeeClient {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
		
		Employee cooper = new Employee(102,"Sheldon Cooper", 44, 50000);
		employeeService.insertEmployee(cooper);

	}

}
