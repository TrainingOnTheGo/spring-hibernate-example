package com.training.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.domain.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void saveEmployee(Employee employee) {
		getSession().save(employee);
	    System.out.println("Employee Saved!!");
	}

	@Override
	public void updateEmployee(Employee employee) {
		getSession().update(employee);
	    System.out.println("Employee Updated!!");
	}

	@Override
	public void deleteEmployee(Employee employee) {
		getSession().delete(employee);
        System.out.println("Employee Deleted!!");
		
	}

	@Override
	public Employee find(int employeeId) {
		Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("emp_id",employeeId));
        return (Employee) criteria.uniqueResult();
	}
	
	@Override
	public List<Employee> findAll() {
		Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
	}
	
	protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
