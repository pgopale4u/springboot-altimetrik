package com.vts.eoffice.controller;

import com.vts.eoffice.dto.ProjectEmpDtls;
import com.vts.eoffice.exception.ProjectNotFoundException;
import com.vts.eoffice.model.Project;
import com.vts.eoffice.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/projects")
@Slf4j
public class ProjectController {


	@Autowired
	private ProjectService projectService;

	
	// get all projects
	@GetMapping
	public ResponseEntity<List<Project>> findAllProjects(){
		List<Project> projectList = null;
		try{
			projectList = projectService.findAll();
		}catch (Exception ex){
			throw new RuntimeException("Exception occured while retrieving data from database");
		}
        return  new ResponseEntity<>(projectList, HttpStatus.OK);
	}		
	
	// create projects rest api
	@PostMapping
	public ResponseEntity<Project> createProject(@RequestBody Project project) {
		Project project1 = null;
		try{
			project1 = projectService.save(project);
		}catch (Exception ex){
			throw new RuntimeException("Exception occured while retrieving data from database");
		}
        return  new ResponseEntity<>(project1, HttpStatus.OK);
	}
	
	// get projects by id rest api
	@GetMapping("/{projid}")
	public ResponseEntity<Project> findByProjectById(@PathVariable String projid) {
		Project project = null;
		try{
			log.info("getprojectBy Id method............");
			project = projectService.findByProjNo(projid);
		}catch(ProjectNotFoundException ex){
			throw new ProjectNotFoundException(ex.getMessage());
		}catch (Exception ex){
			throw new RuntimeException("Exception occured while retrieving data from database");
		}
			return  new ResponseEntity<>(project, HttpStatus.OK);
		}

	@GetMapping("/empdtls/{projid}")
	public ResponseEntity<ProjectEmpDtls> getEmpDtlsbyProjectById(@PathVariable String projid) {
		ProjectEmpDtls projectEmpDtls = null;
		try{
			projectEmpDtls = projectService.getEmpDtlsByProjectId(projid);
		}catch (Exception ex){
			throw new RuntimeException("Exception occured while retrieving data from database");
		}
			return  new ResponseEntity<>(projectEmpDtls, HttpStatus.OK);
	}


	@DeleteMapping("/empdtls/{projid}/{empid}")
	public ResponseEntity<String> getEmpDtlsbyProjectById(@PathVariable String projid, @PathVariable String empid) {
			String response = null;
			try{
				response = projectService.disassociateProjectByEmp(projid, empid);
			}catch (Exception ex){
				throw new RuntimeException("Exception occured while retrieving data from database");
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
}
