package com.vijay.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@Column
	private int sid;
	@Column

	private String sName;

	public Student(int sid, String sName) {
		super();
		this.sid = sid;
		this.sName = sName;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + "]";
	}

}
