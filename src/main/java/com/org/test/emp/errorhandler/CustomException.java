package com.org.test.emp.errorhandler;


import java.util.List;

import com.org.test.emp.dto.ValidationNotification;

import lombok.Getter;


@Getter
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final CustomError customError;

	private final List<ValidationNotification> errors;

	public CustomException(String message, CustomError customError) {
		super(message);
		this.customError = customError;
		this.errors = null;
	}

	public CustomException(String message, CustomError customError, List<ValidationNotification> errors) {
		super(message);
		this.customError = customError;
		this.errors = errors;
	}

	public CustomException(String message, CustomError customError, Exception exception) {
		super(message, exception);
		this.customError = customError;
		this.errors = null;
		
	}
	
	public CustomError getCustomError() {
		return customError;
	}

	public List<ValidationNotification> getErrors() {
		return errors;
	}

	

}
