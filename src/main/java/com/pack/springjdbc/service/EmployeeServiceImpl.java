package com.pack.springjdbc.service;

import org.springframework.stereotype.Service;

import com.pack.springjdbc.dao.EmployeeDAO;
import com.pack.springjdbc.model.Employee;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public void insertEmployee(Employee employee) {
		System.out.println("Insert Employee in Employee Service");
		employeeDAO.insert(employee);
	}

}
