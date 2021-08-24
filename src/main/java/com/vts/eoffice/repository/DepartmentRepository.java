package com.vts.eoffice.repository;

import com.vts.eoffice.model.Department;
import com.vts.eoffice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Department findByDeptId(String dept_id);

	@Query("SELECT max(t.id) FROM Department t")
	Integer maxDeptNo();
	
}
