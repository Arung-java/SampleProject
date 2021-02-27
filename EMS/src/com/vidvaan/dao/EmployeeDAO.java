package com.vidvaan.dao;

import java.util.List;

import com.vidvaan.model.Employee;

public interface EmployeeDAO {
	public void insert(Employee employee);
	public void update(Employee employee);
	public void delete(Integer eid);
	public Employee findById(Integer eid);
	public List<Employee> findAll();
}
