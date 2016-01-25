package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"EMPLOYEEA\"")
public class EmployeeA {

	@Id
	@GeneratedValue
	@Column(name = "\"ID\"", nullable = false)
	private Long id;

	@Column(name = "\"NAME\"", nullable = false)
	private String name;

	@Column(name = "\"AGE\"", nullable = false)
	private Long age;

	public EmployeeA() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
