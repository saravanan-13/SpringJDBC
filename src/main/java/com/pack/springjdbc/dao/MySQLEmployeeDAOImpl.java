package com.pack.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pack.springjdbc.model.Employee;

@Repository(value = "mysqlDaoImpl")
public class MySQLEmployeeDAOImpl implements EmployeeDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insert(Employee employee) {
		String query = "insert into employee values('" + employee.getId() + "','" + employee.getName() + "','"
				+ employee.getAge() + "','" + employee.getSalary() + "')";
		System.out.println("INSERT Employee in MySQL DAO");
		jdbcTemplate.execute(query);
	}

	public int update(Employee employee) {
		String query = "update employee set age = ?, salary = ? where id = ?";
		jdbcTemplate.update(query, employee.getAge(), employee.getSalary(), employee.getId());
		System.out.println("UPDATE Employee in MySQL DAO");
		return 0;
	}

	public int delete(int id) {
		String query = "delete from employee where id = ?";
		jdbcTemplate.update(query, id);
		System.out.println("DELETE Employee in MySQL DAO");
		return 0;
	}

	public List<Employee> listAll() {

		// Method - 1

//		return jdbcTemplate.query("select * from employee", new ResultSetExtractor<List<Employee>>() {
//			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
//
//				List<Employee> list = new ArrayList<Employee>();
//				while (rs.next()) {
//					Employee e = new Employee();
//					e.setId(rs.getInt(1));
//					e.setName(rs.getString(2));
//					e.setAge(rs.getInt(3));
//					e.setSalary(rs.getDouble(4));
//					list.add(e);
//				}
//				System.out.println("Select All Employee in MySQL DAO");
//				return list;
//
//			}
//
//		});

		// Method - 2

		List<Employee> employeeList = jdbcTemplate.query("select * from employee",
				(rs, rowNum) -> new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
		return employeeList;

		// Method - 3

//		 List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
//		 for(Map<String, Object> row : rows){
//			 Employee employee = new Employee();
//	         employee.setId((Integer) row.get("id"));
//	          employee.setName((String)row.get("name"));
//	          employee.setSalary((Double) row.get("salary"));
//	          employee.setAge((Integer) row.get("age"));
//	          emplist.add(employee);
//	        }
//		return emplist;

	}

	public Employee findById(int id) {
		//Method - 1
		String query = "select * from employee where id = "+ id;
		return jdbcTemplate.queryForObject(query,
				(rs, rowNum) -> new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
		

	}

}
