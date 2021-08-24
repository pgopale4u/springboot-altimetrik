package com.vts.eoffice.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "proj_no")
	private String projNo;
	
	@Column(name = "proj_name")
	private String projName;

	@Column(name = "proj_desc")
	private String projDesc;

	/*@OneToMany(mappedBy = "project",  cascade = CascadeType.ALL)
	private List<EmployeeProjects> projectsList;*/
	
}
