package com.vts.eoffice.service;

import com.vts.eoffice.dto.DepartmentEmpDtls;
import com.vts.eoffice.dto.DepartmentProjectDtls;
import com.vts.eoffice.dto.ProjectEmpDtls;
import com.vts.eoffice.exception.DepartmentNotFoundException;
import com.vts.eoffice.exception.EmployeeNotFoundException;
import com.vts.eoffice.model.Department;
import com.vts.eoffice.model.Employee;
import com.vts.eoffice.model.Project;
import com.vts.eoffice.repository.DepartmentProjectRepository;
import com.vts.eoffice.repository.DepartmentRepository;
import com.vts.eoffice.repository.EmployeeDepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository deptRepo;

	@Autowired
	private EmployeeDepartmentRepository employeeDepartmentRepository;

	@Autowired
	private DepartmentProjectRepository departmentProjectRepository;

	@Transactional
	public Department findByDeptId(String deptId) throws Exception{
		Department dept = deptRepo.findByDeptId(deptId);
		if(dept == null){
			throw new DepartmentNotFoundException("Department Data not found");
		}
		return dept;
	}

	@Transactional
	public Department save(Department dept) throws Exception {
		Department deptLocal = null;
		Integer maxno = deptRepo.maxDeptNo();
		if(maxno == null){
			maxno = 1;
		}else{
			maxno = maxno +1;
		}
		// this can be handle using triggers instead of java code
		String deptNo = getDeprtno(maxno);
		if(deptNo != null) {
			dept.setDeptId(deptNo);
			deptLocal = deptRepo.save(dept);
		}
		return deptLocal;
	}

	private String getDeprtno(Integer maxno) throws Exception{
		String deptNo = null;
		String z1 = "";
		int len = 5 - (String.valueOf(maxno).length() + 1);
		for(int i=0; i<len;i++){
			z1 = z1 + "0";
		}

		deptNo = "D"+z1+maxno;
		log.info("empno ============> "+deptNo);



		return deptNo;
	}

	public List<Department> findAllDepartment()throws Exception {
		return	deptRepo.findAll();
	}

	public DepartmentEmpDtls findAllEmployessByDepartment(String deptId) throws Exception{
		DepartmentEmpDtls departmentEmpDtls = new DepartmentEmpDtls();
		Department department = deptRepo.findByDeptId(deptId);
		List<Employee> employeeList =  employeeDepartmentRepository.findByDeptNo(deptId);
		departmentEmpDtls.setDepartment(department);
		departmentEmpDtls.setEmployeeList(employeeList);
		return departmentEmpDtls;
	}

	public DepartmentProjectDtls findAllProjectsByDepartment(String deptid) throws Exception{
		DepartmentProjectDtls departmentProjectDtls = new DepartmentProjectDtls();
		Department department = deptRepo.findByDeptId(deptid);
		List<Project> projectList = departmentProjectRepository.findByDeptNo(deptid);
		departmentProjectDtls.setDepartment(department);
		departmentProjectDtls.setProjectList(projectList);
		return  departmentProjectDtls;
	}
}
