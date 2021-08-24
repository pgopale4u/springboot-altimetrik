package com.vts.eoffice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "emp_project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProjects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "emp_no")
	private String empNo;
	
	@Column(name = "proj_no")
	private String projNo;

	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "emp_no", nullable = false)
	private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "proj_no", nullable = false)
	private Project project;*/

}
