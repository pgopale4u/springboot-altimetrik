package com.vts.eoffice.service;

import com.vts.eoffice.dto.ProjectEmpDtls;
import com.vts.eoffice.model.Employee;
import com.vts.eoffice.model.EmployeeProjects;
import com.vts.eoffice.model.Project;
import com.vts.eoffice.repository.EmployeeProjectRepository;
import com.vts.eoffice.repository.EmployeeRepository;
import com.vts.eoffice.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private EmployeeProjectRepository employeeProjectRepository;
	
	public List<Project> findAll() throws Exception{
		List<Project> projList = projectRepository.findAll();
		return projList;
	}

	@Transactional
	public Project findByProjNo(String projNo) throws Exception{
		log.info("started in service class ");
		Project proj = projectRepository.findByProjNo(projNo);
		return proj;
	}

	public Project save(Project proj) throws Exception{
		Project projLocal = null;
		Integer maxno = projectRepository.maxProjNo();
		if(maxno == null){
			maxno = 1;
		}else{
			maxno = maxno +1;
		}
		// this can be handle using triggers instead of java code
		String projNo = getProjno(maxno);
		if(projNo != null) {
			proj.setProjNo(projNo);
			projLocal = projectRepository.save(proj);
		}
		return projLocal;
		
	}


	public boolean deleteByEmpId(String empId) {
		// TODO Auto-generated method stub
		return false;
	}
	private String getProjno(Integer maxno) throws Exception{
		String projNo = null;
		String z1 = "";
		int len = 5 - (String.valueOf(maxno).length() + 1);
		for(int i=0; i<len;i++){
			z1 = z1 + "0";
		}
		projNo = "P"+z1+maxno;
		log.info("projNo ============> "+projNo);
		return projNo;
	}

	public ProjectEmpDtls getEmpDtlsByProjectId(String projid) throws Exception{
		ProjectEmpDtls projectEmpDtls = new ProjectEmpDtls();
		Project project = projectRepository.findByProjNo(projid);
		List<Employee> employeeList =  employeeProjectRepository.findByProjectId(projid);
		projectEmpDtls.setProject(project);
		projectEmpDtls.setEmployeeList(employeeList);
		return projectEmpDtls;
	}

	public String disassociateProjectByEmp(String projid, String empid) throws Exception{
		EmployeeProjects employeeProjects = employeeProjectRepository.findByEmpNoAndProjNo(empid, projid);
		log.info("employee ---> "+employeeProjects.getId());
		employeeProjectRepository.delete(employeeProjects);
		return "Project Id: "+projid+ " and Emp Id: "+empid+" are disassociated successfully";
	}
}
