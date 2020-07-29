package com.org.test.emp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.test.emp.dto.CredentialsRequest;
import com.org.test.emp.entities.Credentials;
import com.org.test.emp.service.CredentialService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class CredentialsController {
		
		@Autowired
		CredentialService credentialService;
			
		@PostMapping("/login")
	    public ResponseEntity<Credentials> validateCredentials(@Valid @RequestBody CredentialsRequest credentialsRequest) throws Exception {
			Credentials credentials = credentialService.validateCredentials(credentialsRequest); 
	        return new ResponseEntity<>(credentials, HttpStatus.OK);
	    }

}
