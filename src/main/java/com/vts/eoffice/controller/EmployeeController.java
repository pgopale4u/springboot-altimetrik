package com.vts.eoffice.controller;

import java.util.List;

import com.vts.eoffice.exception.EmployeeNotFoundException;
import com.vts.eoffice.exception.InvalidInputException;
import com.vts.eoffice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vts.eoffice.model.Employee;


@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {


	@Autowired
	private EmployeeService empService;

	
	// get all employees
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employeeList = null;
		try {
			employeeList = empService.findAll();
		}catch (Exception ex){
			throw new RuntimeException("Exception occured while retrieving data from database");
		}
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}		
	
	// create employee rest api
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee employee1 = null;
		try{
			employee1 = empService.save(employee);
		}catch(Exception ex){
			throw new RuntimeException("Exception occured while storing employee data");
		}
		return new ResponseEntity<Employee>(employee1, HttpStatus.OK);
	}
	
	// get employee by id rest api
	@GetMapping("/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String empid) {
		if(null==empid || !empid.startsWith("E")) {
			throw new InvalidInputException("Employee Id is not valid");
		}
		Employee employee = null;
		try {
			employee = empService.findByEmpId(empid);
		}catch(EmployeeNotFoundException ex){
			throw new EmployeeNotFoundException(ex.getMessage());
		}catch(Exception ex){
			throw new RuntimeException("Exception occured while retrieving employee data");
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	

	
}
