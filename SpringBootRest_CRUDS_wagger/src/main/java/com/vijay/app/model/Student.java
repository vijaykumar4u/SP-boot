package com.vijay.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;




@Entity


public class Student {
	@Id
	private int id;
	private String fname;
	private String lname;
	public int getId() {
		return id;
	}
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(int id, String fname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}

	public void setId(int id) {
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
	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
	}
	
	

}
