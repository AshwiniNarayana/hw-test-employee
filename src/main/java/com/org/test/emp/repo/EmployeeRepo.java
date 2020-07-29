package com.org.test.emp.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.test.emp.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

	public Optional<Employee> findByName(String name);
	
	@Query("SELECT e FROM Employee e WHERE e.gender = ?1 and (e.age >= ?2 and e.age <= ?3)")
	public List<Employee> findByGenderAndAge(String gender, int minAge, int maxAge);

}
