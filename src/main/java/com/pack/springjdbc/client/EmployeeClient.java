package com.pack.springjdbc.client;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pack.springjdbc.model.Employee;
import com.pack.springjdbc.service.EmployeeService;

public class EmployeeClient {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);

		List<Employee> emplist = employeeService.listAllEmployee();

//		for (Employee emp : emplist) {
//			System.out.println(emp);
//		}
		
//        Consumer<Employee> style = (Employee e) -> System.out.println("Name:"+e.getName() +" and Age:"+e.getAge());
//        emplist.forEach(style);
//
//        System.out.println("-----------FIND BY ID------------");
//        
//        Employee employee = employeeService.findByIdEmployee(102);
//        
//        System.out.println(employee);
		
		Employee employee = new Employee(103, "Cooper", 21, 42000);
		
		employeeService.updateEmployee(employee);
		
//		employeeService.deleteEmployee(102);

	}

}
