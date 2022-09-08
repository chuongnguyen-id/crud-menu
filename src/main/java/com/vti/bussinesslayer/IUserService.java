package com.vti.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

public interface IUserService {
	List<User> getListUsers() throws FileNotFoundException, SQLException, IOException, ClassNotFoundException;

	User getUserById(int id, String role1) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;

	boolean isUserIdExits(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;

	User getLogin(String email, String password) throws Exception;
}
