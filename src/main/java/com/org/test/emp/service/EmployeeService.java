package com.org.test.emp.service;


import java.util.List;

import com.org.test.emp.dto.EmployeeRequest;
import com.org.test.emp.entities.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(EmployeeRequest entity);

	public List<Employee> getAllEmployeesByAgeandGender(String gender, int minAge, int maxAge);
	
    public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(long id) throws Exception;
	
	
}
