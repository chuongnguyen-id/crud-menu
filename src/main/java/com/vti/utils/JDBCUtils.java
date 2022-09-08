package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	private Properties properties;
	private Connection connection;

	public JDBCUtils() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		// Khai báo các tham số để khởi tạo connection với database
		 properties = new Properties();
		properties.load(new FileInputStream("src/main/resources/database.properties"));
		connect();
	}


	public Connection connect() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		if (connection != null && !connection.isClosed()) {
			return connection;
		}
		// Khai báo các tham số để khởi tạo connection với database
		properties = new Properties();
		properties.load(new FileInputStream("src/main/resources/database.properties"));

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		// Step 1: register the driver class with DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: get a Database Connection
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
