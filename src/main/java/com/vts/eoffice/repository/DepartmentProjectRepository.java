package com.vts.eoffice.repository;

import com.vts.eoffice.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentProjectRepository extends JpaRepository<DepartmentProjects, Long>{

	@Query("SELECT t1 FROM Department t1 WHERE deptId IN (" +
			"SELECT t2.deptNo " +
			"FROM DepartmentProjects t2 WHERE t2.projNo= :projNo " +
			") ")
	List<Department> findByProjectId(@Param("projNo") String projno);

	@Query("SELECT t1 FROM Project t1 WHERE projNo IN (" +
			"SELECT t2.projNo " +
			"FROM DepartmentProjects t2 WHERE t2.deptNo= :deptNo " +
			") ")
	List<Project> findByDeptNo(@Param("deptNo") String deptNo);

	DepartmentProjects findByDeptNoAndProjNo(String deptNo, String projno);

}
