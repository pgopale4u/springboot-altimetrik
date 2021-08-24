package com.vts.eoffice.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "dept_no")
	private String deptId;
	
	@Column(name = "dept_name")
	private String deptName;

	@Column(name = "dept_description")
	private String deptDesc;


	
}
