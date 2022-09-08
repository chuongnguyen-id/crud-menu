package com.vti.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.bussinesslayer.IUserService;
import com.vti.bussinesslayer.UserService;
import com.vti.entity.User;

public class UserController {
	private IUserService userService;

	public UserController() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userService = new UserService();
	}

	public List<User> getListUsers() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		return userService.getListUsers();
	}

	public User getUserById(int id, String role1) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		return userService.getUserById(id, role1);
	}

	public boolean isUserIdExits(int id)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		return userService.isUserIdExits(id);
	}

	public User getLogin(String email, String password) throws Exception {
		return userService.getLogin(email, password);
	}
}
