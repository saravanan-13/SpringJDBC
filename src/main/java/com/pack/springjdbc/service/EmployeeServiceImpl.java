package com.pack.springjdbc.service;

import java.util.List;

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

	public int updateEmployee(Employee employee) {
		System.out.println("Update Employee in Employee Service");
		employeeDAO.update(employee);
		return 0;
	}

	public int deleteEmployee(int id) {
		System.out.println("Delete Employee in Employee Service");
		employeeDAO.delete(id);
		return 0;
	}

	public List<Employee> listAllEmployee() {
		System.out.println("List ALL Employee in Employee Service");
		return employeeDAO.listAll();
	}

	public Employee findByIdEmployee(int id) {
		System.out.println("Find by Id Employee in Employee Service");
		return employeeDAO.findById(id);
	}

}
