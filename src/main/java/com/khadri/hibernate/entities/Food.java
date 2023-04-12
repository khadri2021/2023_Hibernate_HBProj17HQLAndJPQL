package com.khadri.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity(name = "Food")
@Table(name = "FOOD")
@NamedQuery(name="find_cost",query = "from Food where cost=:tiffenCost")
public class Food {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String cost;

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

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

}
