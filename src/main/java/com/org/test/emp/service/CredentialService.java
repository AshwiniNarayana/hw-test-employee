package com.org.test.emp.service;

import com.org.test.emp.dto.CredentialsRequest;
import com.org.test.emp.entities.Credentials;

public interface CredentialService {
	
	
	public Credentials validateCredentials(CredentialsRequest request) throws Exception;
}
