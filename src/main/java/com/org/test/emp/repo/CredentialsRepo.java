
package com.org.test.emp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.test.emp.entities.Credentials;

public interface CredentialsRepo extends JpaRepository<Credentials,Long> {

	public Optional<Credentials> findByUserAndPassword(String name,String Password);

}
