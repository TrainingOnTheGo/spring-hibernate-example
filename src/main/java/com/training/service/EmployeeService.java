package com.training.service;

import java.util.List;

import com.training.model.Employee;

public interface EmployeeService {

	public void saveEmployee(com.training.model.Employee employee);
	 
    public void updateEmployee(com.training.model.Employee employee);
 
    public void deleteEmployee(int employeeId);
 
    public Employee find(int employeeId);
 
    public List<Employee> findAll();

}