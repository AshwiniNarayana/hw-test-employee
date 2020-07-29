package com.org.test.emp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.test.emp.dto.EmployeeRequest;
import com.org.test.emp.entities.Employee;
import com.org.test.emp.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
		
	@PostMapping("/employee")
    public ResponseEntity<Employee> createConsumerApp(@Valid @RequestBody EmployeeRequest employeeRequest) {
    	Employee employee = employeeService.createEmployee(employeeRequest); 
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
	
	@GetMapping("employee/{gender}/{minAge}/{maxAge}")
    public ResponseEntity<List<Employee>> getAllEmployeesByAgeandGender(@PathVariable("gender") String gender,
    		@PathVariable("minAge") int minAge,@PathVariable("maxAge") int maxAge) {
        List<Employee> list = employeeService.getAllEmployeesByAgeandGender(gender,minAge,maxAge);
        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
	@GetMapping("employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = employeeService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	@GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) throws Exception {
        Employee entity = employeeService.getEmployeeById(id);
        return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
    }
	

}
