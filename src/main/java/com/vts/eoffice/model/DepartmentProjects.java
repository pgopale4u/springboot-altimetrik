package com.vts.eoffice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "dept_project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentProjects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "dept_no")
	private String deptNo;
	
	@Column(name = "proj_no")
	private String projNo;



}
