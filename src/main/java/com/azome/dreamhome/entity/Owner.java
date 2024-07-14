package com.azome.dreamhome.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String fname;
	private String lname;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="owner_id")
	private List<Property> property=new ArrayList<Property>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public List<Property> getProperty() {
		return property;
	}

	public void setProperty(List<Property> property) {
		this.property = property;
	}

	public Owner(Long id, String fname, String lname, List<Property> property) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.property = property;
	}

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
