package com.vts.eoffice.repository;

import com.vts.eoffice.model.Employee;
import com.vts.eoffice.model.EmployeeDepartments;
import com.vts.eoffice.model.EmployeeProjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDepartmentRepository extends JpaRepository<EmployeeDepartments, Long>{

	@Query("SELECT t1 FROM Employee t1 WHERE emp_no IN (" +
			"SELECT t2.empNo " +
			"FROM EmployeeDepartments t2 WHERE t2.deptNo= :deptNo " +
			") ")
	List<Employee> findByDeptNo(@Param("deptNo") String deptno);

	EmployeeDepartments findByEmpNoAndDeptNo(String empNo, String deptno);
}
