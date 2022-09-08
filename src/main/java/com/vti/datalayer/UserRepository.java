package com.vti.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.utils.JDBCUtils;

public class UserRepository implements IUserRepository {
	private JDBCUtils jdbc;
	private Connection connection;

	// Tạo Instance JDBCUtils để getConnection
	public UserRepository() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbc = new JDBCUtils();
	}

	public List<User> getListUsers() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		List<User> listUsers = new ArrayList<User>();
		
		// Create a statment object
		Statement statement = jdbc.connect().createStatement();

		// Execute query
		String sql = "SELECT * FROM `User` u JOIN Project p ON u.ProjectId =p.ProjectId WHERE `Role` = 'MANAGER';";
		ResultSet resultSet = statement.executeQuery(sql);

		// Handling result set
		while (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt(1));
			user.setFullName(resultSet.getString(2));
			user.setEmail(resultSet.getString(3));
			user.setPassword(resultSet.getString(4));
			Role role = Role.valueOf(resultSet.getString(8));
			user.setRole(role);
			
			listUsers.add(user);
		}

		return listUsers;
	}

	public User getUserById(int id, String role1) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		try {

			// Step 2: get connect
			connection = jdbc.connect();

			// Step 3: Create a statement object
			String sql = "SELECT * FROM `User` u JOIN Project p ON u.ProjectId =p.ProjectId WHERE p.ProjectId = ? AND u.`Role` = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, role1);

			// Step 4: Execute SQL query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setFullName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPassword(resultSet.getString(4));
				Role role = Role.valueOf(resultSet.getString(8));
				user.setRole(role);
				
				return user;
			}
			return null;

		} finally {
			
		}
	}


	public boolean isUserIdExits(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		try {

			// step 2: get connect
			connection = jdbc.connect();

			// Step 3: Create a statement object

			String sql = "SELECT * FROM `User` " + " WHERE ID = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute Query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set

			if (resultSet.next()) {

				return true;
			}

			return false;
		} finally {
			
		}
	}
	
	public User getLogin(String email, String password) throws Exception {
		try {

			// step 2: get connect
			connection = jdbc.connect();

			// Step 3: Create a statement object

			String sql = "SELECT * FROM `User` " + "WHERE Email = ? AND Password = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			// Step 4: Execute Query

			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result
			if (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setFullName(resultSet.getString(2));
				Role role = Role.valueOf(resultSet.getString(8));
				user.setRole(role);
				
				return user;
			} else {
				throw new Exception("Sai tài khoản hoặc mật khẩu!");
			}

		} finally {
			
		}
	}

}
