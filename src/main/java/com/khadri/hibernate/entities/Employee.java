package com.khadri.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Employee")
@Table(name="EMPLOYEE2")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Double salary;
	
	private Integer workingDays;
	
	private Integer sickLeaves;
	
	private Double hike;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(Integer workingDays) {
		this.workingDays = workingDays;
	}

	public Integer getSickLeaves() {
		return sickLeaves;
	}

	public void setSickLeaves(Integer sickLeaves) {
		this.sickLeaves = sickLeaves;
	}

	public Double getHike() {
		return hike;
	}

	public void setHike(Double hike) {
		this.hike = hike;
	}
	
	
}
