package com.org.test.emp.errorhandler;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class ErrorMessage {
	private int status;
	private List<String> errors;
	private String message;
	private String path;
	private String referenceId;

	public ErrorMessage(int status, String message, String error, String path,String referenceId) {
		this.status = status;
		this.message = message;
		this.path = path;
		errors = Arrays.asList(error);
		this.referenceId = referenceId;
	}

	public ErrorMessage(int status, String message, List<String> errors, String path,String referenceId) {
		this.status = status;
		this.message = message;
		this.path = path;
		this.errors = errors;
		this.referenceId = referenceId;
	}

}
