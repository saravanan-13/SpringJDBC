package com.pack.springjdbc.service;

import java.util.List;

import com.pack.springjdbc.model.Employee;

public interface EmployeeService {

	public void insertEmployee(Employee employee);
	public int updateEmployee (Employee employee);
	public int deleteEmployee (int id);
	public List<Employee> listAllEmployee();
	public Employee findByIdEmployee(int id);
}
