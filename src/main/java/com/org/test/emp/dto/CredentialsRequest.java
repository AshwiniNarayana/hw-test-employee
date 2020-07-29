package com.org.test.emp.dto;

import javax.validation.constraints.NotNull;

public class CredentialsRequest {
	
	@NotNull(message = "UserName is mandatory")
	private String username;
	
	@NotNull(message = "Password is mandatory")
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
