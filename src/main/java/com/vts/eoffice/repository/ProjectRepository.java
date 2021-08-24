package com.vts.eoffice.repository;

import com.vts.eoffice.model.Department;
import com.vts.eoffice.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	Project findByProjNo(String proj_no);

	@Query("SELECT max(t.id) FROM Project t")
	Integer maxProjNo();
	
}
