package com.checkproducer.kafkaproducer.studentmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	private String name;
	private String fname;
	
	public Students() {
		super();
	}

	public Students(int id, String name, String fname) {
		super();
		this.id = id;
		this.name = name;
		this.fname = fname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", fname=" + fname + "]";
	}
	
	

	

}
