package com.vts.eoffice.dto;

import com.vts.eoffice.model.Department;
import com.vts.eoffice.model.Employee;
import com.vts.eoffice.model.Project;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEmpDtls {
	
	private List<Employee> employeeList;
	private Department department;
}
