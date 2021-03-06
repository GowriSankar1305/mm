package com.jocata.vadin.backend.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Company extends AbstractEntity {
	
	public Company()	{
		
	}
	private String name;
	
	public Company(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy = "company",fetch = FetchType.EAGER)
	private List<Contact> employees = new LinkedList<Contact>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contact> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Contact> employees) {
		this.employees = employees;
	}
	
	
}
