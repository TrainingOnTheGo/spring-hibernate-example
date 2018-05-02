package com.training.model;

import java.io.Serializable;

public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int empId;
	
	private String name;
	
	private String salary;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}

}
