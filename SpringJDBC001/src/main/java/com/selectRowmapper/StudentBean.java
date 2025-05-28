package com.selectRowmapper;

public class StudentBean {
	private int rollno;
	private String name;
	private String location;

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
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

	@Override
	public String toString() {
		return "StudentBean [rollno=" + rollno + ", name=" + name + ", location=" + location + "]";
	}
	
}
