package com.springboot.backend.service;

import java.util.List;

import com.springboot.backend.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee empployee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployeeById(long id, Employee employee);
	
	void deleteEmployeeById(long id);
}
