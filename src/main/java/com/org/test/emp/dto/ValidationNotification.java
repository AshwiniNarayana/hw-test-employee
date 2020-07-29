package com.org.test.emp.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ValidationNotification implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4047567069537050122L;
	private boolean valid;
	private String message;
	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}

