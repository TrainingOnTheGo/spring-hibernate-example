package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.model.Employee;
import com.training.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Employee> find() {
		System.out.println("Test");
		List<Employee> empList = employeeService.findAll();
		for(Employee emp : empList) {
			System.out.println(emp.getEmpId());
		}
		
		return empList;
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Employee findRecord(@RequestParam int employeeId) {
		System.out.println("Employee Id: " + employeeId);
		Employee employee = employeeService.find(employeeId);
		System.out.println(employee.getEmpId());
		return employee;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody String findWithParameters(@RequestBody Employee employee) {
		System.out.println(employee.getEmpId());
		employeeService.updateEmployee(employee);
		return "success";
	}
	
	@RequestMapping(value="/employee", method=RequestMethod.PUT	)
	public @ResponseBody String add(@RequestBody Employee employee) {
		System.out.println(employee.getEmpId());
		employeeService.saveEmployee(employee);
		//System.out.println(employeeService.findAll());
		return "success";
	}
	
	@RequestMapping(value="/employee", method=RequestMethod.DELETE	)
	public @ResponseBody String delete(@RequestBody Employee employee) {
		System.out.println(employee.getEmpId());
		employeeService.deleteEmployee(employee.getEmpId());
		//System.out.println(employeeService.findAll());
		return "success";
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
