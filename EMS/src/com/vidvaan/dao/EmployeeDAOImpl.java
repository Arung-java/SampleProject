package com.vidvaan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vidvaan.model.Employee;
import com.vidvaan.queries.Queries;
import com.vidvaan.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void insert(Employee employee) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(Queries.EMP_INSERT);
			preparedStatement.setString(1, employee.getEname());
			preparedStatement.setDouble(2, employee.getEsal());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}

	}

	@Override
	public void update(Employee employee) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(Queries.EMP_UPDATE);
			preparedStatement.setInt(3, employee.getEid());
			preparedStatement.setString(1, employee.getEname());
			preparedStatement.setDouble(2, employee.getEsal());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}
	}

	@Override
	public void delete(Integer eid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(Queries.EMP_DELETE);
			preparedStatement.setInt(1, eid);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}

	}

	@Override
	public Employee findById(Integer eid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(Queries.EMP_FIND_BY_ID);
			preparedStatement.setInt(1, eid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setEid(resultSet.getInt("EID"));
				employee.setEname(resultSet.getString("ENAME"));
				employee.setEsal(resultSet.getDouble("ESAL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(resultSet, preparedStatement, connection);
		}
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = null;
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(Queries.EMP_FIND_ALL);
			resultSet = preparedStatement.executeQuery();
			employees = new ArrayList<>();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEid(resultSet.getInt("EID"));
				employee.setEname(resultSet.getString("ENAME"));
				employee.setEsal(resultSet.getDouble("ESAL"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(resultSet, preparedStatement, connection);
		}
		return employees;
	}

}
