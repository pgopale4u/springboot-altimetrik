package com.vts.eoffice.service;

import java.util.List;

import com.vts.eoffice.exception.EmployeeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vts.eoffice.model.Employee;
import com.vts.eoffice.repository.EmployeeRepository;

@Service
@Slf4j
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	public List<Employee> findAll() throws Exception{
		List<Employee> empList = empRepo.findAll();
		return empList;
	}

	@Transactional
	public Employee findByEmpId(String empId) throws Exception {
		Employee emp = empRepo.findByEmpNo(empId);
		if(emp == null){
			throw new EmployeeNotFoundException("Employee Data not found");
		}
		return emp;
	}




	public Employee save(Employee emp) throws Exception{
		Employee empLocal = null;
		Integer maxno = empRepo.maxEmpNo();
		if(maxno == null){
			maxno = 1;
		}else{
			maxno = maxno +1;
		}
		// this can be handle using triggers instead of java code
		String empNo = getEmpno(maxno);
		if(empNo != null) {
			emp.setEmpNo(empNo);
			empLocal = empRepo.save(emp);
		}
		return empLocal;
		
	}


	public boolean deleteByEmpId(String empId) {
		// TODO Auto-generated method stub
		return false;
	}
	private String getEmpno(Integer maxno) throws Exception{
		String empNo = null;
		String z1 = "";
		int len = 5 - (String.valueOf(maxno).length() + 1);
		for(int i=0; i<len;i++){
			z1 = z1 + "0";
		}

		empNo = "E"+z1+maxno;
		log.info("empno ============> "+empNo);
		return empNo;
	}

}
