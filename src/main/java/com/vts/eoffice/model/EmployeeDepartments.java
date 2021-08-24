package com.vts.eoffice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "emp_dept")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDepartments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "emp_no")
	private String empNo;
	
	@Column(name = "dept_no")
	private String deptNo;



}
