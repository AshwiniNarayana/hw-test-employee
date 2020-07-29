package com.org.test.emp.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.org.test.emp.dto.EmployeeRequest;
import com.org.test.emp.entities.Employee;
import com.org.test.emp.errorhandler.CustomError;
import com.org.test.emp.errorhandler.CustomException;
import com.org.test.emp.repo.EmployeeRepo;
import com.org.test.emp.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{
	
	   @Autowired
	   EmployeeRepo employeeRepo;
	   
	   
	   
	   @Override
	   public Employee createEmployee(EmployeeRequest emp) 
	    {
		    String name = (emp.getName()!=null)?emp.getName():"";
	        Optional<Employee> employee = employeeRepo.findByName(name);
	         
	        if(!employee.isPresent()) 
	        {
	            Employee newEntity = new Employee(); 
	            newEntity.setName(emp.getName());
	            newEntity.setAge(emp.getAge());
	            newEntity.setGender(emp.getGender());
	 
	            newEntity = employeeRepo.save(newEntity);
	             
	            return newEntity;
	        } else {
	        	throw new CustomException("Employee already exists", CustomError.CONFLICT) ;
	       }
	    } 
	   
	   @Override
	   public List<Employee> getAllEmployeesByAgeandGender(String gender, int minAge, int maxAge){
		   List<Employee> employeeList = employeeRepo.findByGenderAndAge(gender,minAge,maxAge);
	         
	        if(employeeList.size() > 0) {
	            return employeeList;
	        } else {
	            return new ArrayList<Employee>();
	        }
	   }
	   
	   @Override
	   public List<Employee> getAllEmployees()
	    {
	        List<Employee> employeeList = employeeRepo.findAll();
	         
	        if(employeeList.size() > 0) {
	            return employeeList;
	        } else {
	            return new ArrayList<Employee>();
	        }
	    }
	   
	   @Override
	   public Employee getEmployeeById(long id) throws Exception 
	    {
	        Optional<Employee> employee = employeeRepo.findById(id);
	         
	        if(employee.isPresent()) {
	            return employee.get();
	        } else {
	            throw new Exception("No employee record exist for given id");
	        }
	    }
	     
	    
		
}
