package com.vts.eoffice.dto;

import com.vts.eoffice.model.Department;
import com.vts.eoffice.model.Employee;
import com.vts.eoffice.model.Project;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentProjectDtls {
	
	private List<Project> projectList;
	private Department department;
}
