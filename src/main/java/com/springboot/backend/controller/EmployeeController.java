package com.springboot.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.springboot.backend.model.Employee;
import com.springboot.backend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//create an Employee Rest API
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		 // Print each field of the Employee object for debugging
        System.out.println("Received Employee First Name: " + employee.getFirstName());
        System.out.println("Received Employee Last Name: " + employee.getLastName());
        System.out.println("Received Employee Email: " + employee.getEmail());

        // Check if firstName is null
        if (employee.getFirstName() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	//get all Employees Rest API
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//get Employee By Id Rest API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK); 
	}
		
		
	//update Employee BY Id Rest API
	@PutMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployeeById(id, employee), HttpStatus.OK); 
	}
	
	//delete Employee By Id Rest API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id){
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<String>("Employee Deleted Successfully..!",HttpStatus.OK); 
	}
}
