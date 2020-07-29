package com.org.test.emp.dto;

import javax.validation.constraints.NotNull;

public class EmployeeRequest {
	
	@NotNull(message = "Name is mandatory")
	private String name;
	
	@NotNull(message = "Age is mandatory")
	private int age;
	
	@NotNull(message = "Gender is mandatory")
	private String gender;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
