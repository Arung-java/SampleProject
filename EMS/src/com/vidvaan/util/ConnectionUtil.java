package com.vidvaan.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionUtil {

	private static Properties properties = null;

	static {
		properties = new Properties();
		try {
			properties.load(
					ConnectionUtil.class.getClassLoader().getResourceAsStream("com/vidvaan/properties/db.properties"));
			Class.forName(properties.getProperty("driver"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;

	}

	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement statement, Connection connection) {
		try {
			close(connection);
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet resultSet, Statement statement, Connection connection) {
		try {
			close(statement, connection);
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
