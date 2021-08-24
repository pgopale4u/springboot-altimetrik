package com.vts.eoffice.repository;

import com.vts.eoffice.model.Employee;
import com.vts.eoffice.model.EmployeeProjects;
import com.vts.eoffice.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProjects, Long>{

	//EmployeeProjects findByProject(Project project);


	@Query("SELECT t1 FROM Employee t1 WHERE emp_no IN (" +
			"SELECT t2.empNo " +
			"FROM EmployeeProjects t2 WHERE t2.projNo= :projNo " +
			") ")
	List<Employee> findByProjectId(@Param("projNo") String projno);

/*
	@Query("select t1 from EmployeeProjects t1 where t1.empNo= :empNo and t1.projNo= :projNo")
	EmployeeProjects findByEmpIdProjectId(@Param("projNo") String projno, @Param("empNo") String empNo);
*/

	EmployeeProjects findByEmpNoAndProjNo(String empNo, String projno);
}
