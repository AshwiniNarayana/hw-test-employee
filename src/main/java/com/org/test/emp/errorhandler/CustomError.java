package com.org.test.emp.errorhandler;


public enum CustomError {
	EMPLOYEE_NOT_FOUND(404, "Employee Not Found"), 
	CREDENTIALS_NOT_FOUND(404, "Credentials Not Found"), 
	CONFLICT(409, "Duplicate Entry Found");

	
	private int responseError;
	private String message;
	

	private CustomError(int responseError, String message) {
		this.responseError = responseError;
		this.message = message;
	}

	public int getResponseError() {
		return responseError;
	}

	public String getMessage() {
		return message;
	}

}
