package com.khadri.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity(name = "Company")
@Table(name = "COMPANY")
@NamedQuery(name = Company.NamedQueries.BY_NAME, query = "select c from Company c where name=:name")
@NamedQuery(name = Company.NamedQueries.BY_LOCATION, query = "select c from Company c where location=:loc")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String location;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public class NamedQueries {
		public static final String BY_LOCATION = "FIND_BY_LOCATION";
		public static final String BY_NAME = "FIND_BY_NAME";

	}

}
