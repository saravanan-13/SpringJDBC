package com.pack.springjdbc.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pack.springjdbc.model.Employee;

@Repository(value = "mysqlDaoImpl")
public class MySQLEmployeeDAOImpl implements EmployeeDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int insert(Employee employee) {
		String query = "insert into employee values('" + employee.getId() + "','" + employee.getName() + "','"
				+ employee.getAge() + "','" + employee.getSalary() + "')";
		System.out.println("Insert Employee in MySQL DAO");
		jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.update(query);

	}

}
