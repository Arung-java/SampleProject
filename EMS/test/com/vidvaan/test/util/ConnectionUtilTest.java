package com.vidvaan.test.util;

import java.sql.Connection;

import org.junit.Test;

import com.vidvaan.dao.EmployeeDAO;
import com.vidvaan.dao.EmployeeDAOImpl;
import com.vidvaan.util.ConnectionUtil;

public class ConnectionUtilTest {
	
	@Test
	public void connectionTest() {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);
	}
	
	@Test
	public void selectAllTest() {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		System.out.println(employeeDAO.findAll());
	}

}
