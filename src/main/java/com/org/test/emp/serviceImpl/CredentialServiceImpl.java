package com.org.test.emp.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.test.emp.dto.CredentialsRequest;
import com.org.test.emp.entities.Credentials;
import com.org.test.emp.repo.CredentialsRepo;
import com.org.test.emp.service.CredentialService;

@Service
public class CredentialServiceImpl implements CredentialService{
	
	@Autowired
	CredentialsRepo credentialsRepo;

	 @Override
	 public Credentials validateCredentials(CredentialsRequest request) throws Exception
	    {
	        Optional<Credentials> credentials = credentialsRepo.findByUserAndPassword(request.getUsername(), request.getPassword());
	         
	        if(credentials.isPresent()) {
	            return credentials.get();
	        } else {
	            throw new Exception("Invalid User");
	        }
	    }
}
