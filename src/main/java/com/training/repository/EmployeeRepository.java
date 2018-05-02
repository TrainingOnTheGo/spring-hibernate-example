package com.training.repository;

import java.util.List;

import com.training.domain.Employee;

public interface EmployeeRepository {
	
	public void saveEmployee(Employee employee);
	 
    public void updateEmployee(Employee employee);
 
    public void deleteEmployee(Employee employee);
 
    public Employee find(int employeeId);
 
    public List <Employee> findAll();

}