package com.vts.eoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vts.eoffice.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findByEmpNo(String empId);

	@Query("SELECT max(t.id) FROM Employee t")
	Integer maxEmpNo();
}
