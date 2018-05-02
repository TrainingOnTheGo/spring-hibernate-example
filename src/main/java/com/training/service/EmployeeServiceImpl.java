package com.training.service;

import java.util.List;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.Employee;
import com.training.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {		
		List<Employee> employees = new ArrayList<>();
		for(com.training.domain.Employee emp : employeeRepository.findAll()) {
			Employee employee = new Employee();
			employee.setEmpId(emp.getEmp_id());
			employee.setName(emp.getName());
			employee.setSalary(emp.getSalary());
			employees.add(employee);
		}
		return employees;
		
	}

	@Override
	public void saveEmployee(Employee employee) {
		com.training.domain.Employee emp = new com.training.domain.Employee();
		//emp.setEmp_id(employee.getEmpId());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		employeeRepository.saveEmployee(emp);
	}

	@Override
	public void updateEmployee(Employee employee) {
		com.training.domain.Employee emp = new com.training.domain.Employee();
		emp.setEmp_id(employee.getEmpId());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		
		employeeRepository.updateEmployee(emp);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		com.training.domain.Employee employee = employeeRepository.find(employeeId);
		employeeRepository.deleteEmployee(employee);
		
	}

	@Override
	public Employee find(int employeeId) {
		com.training.domain.Employee emp = employeeRepository.find(employeeId);
		Employee employee = new Employee();
		employee.setEmpId(emp.getEmp_id());
		employee.setName(emp.getName());
		employee.setSalary(emp.getSalary());
		return employee;
	}
	
}
