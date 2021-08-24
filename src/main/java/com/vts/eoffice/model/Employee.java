package com.vts.eoffice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "emp_no")
	private String empNo;
	
	@Column(name = "emp_fname")
	private String firstName;

	@Column(name = "emp_lname")
	private String lastName;
	
	@Column(name = "gender")
	private String gender;
 


}
