package com.vti.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

public interface IUserRepository {
	List<User> getListUsers() throws FileNotFoundException, SQLException, IOException, ClassNotFoundException;

	User getUserById(int id, String role1) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;

	boolean isUserIdExits(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

	User getLogin(String email, String password) throws ClassNotFoundException, SQLException, Exception;
}
