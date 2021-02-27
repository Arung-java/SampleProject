package com.vidvaan.service;

import java.util.List;

import com.vidvaan.dao.EmployeeDAO;
import com.vidvaan.dao.EmployeeDAOImpl;
import com.vidvaan.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	@Override
	public void insert(Employee employee) {
		employeeDAO.insert(employee);		
	}

	@Override
	public void update(Employee employee) {
		employeeDAO.update(employee);
		
	}

	@Override
	public void delete(Integer eid) {
		employeeDAO.delete(eid);
		
	}

	@Override
	public Employee findById(Integer eid) {
		return employeeDAO.findById(eid);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

}
