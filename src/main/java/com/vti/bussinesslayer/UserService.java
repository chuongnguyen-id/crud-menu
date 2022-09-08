package com.vti.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.datalayer.IUserRepository;
import com.vti.datalayer.UserRepository;
import com.vti.entity.User;

public class UserService implements IUserService {
	private IUserRepository userRepository;

	public UserService() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userRepository = new UserRepository();
	}

	public List<User> getListUsers() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		return userRepository.getListUsers();
	}

	public User getUserById(int id, String role1) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		return userRepository.getUserById(id, role1);
	}

	public boolean isUserIdExits(int id)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		return userRepository.isUserIdExits(id);
	}

	public User getLogin(String email, String password) throws Exception {
		return userRepository.getLogin(email, password);
	}

}
