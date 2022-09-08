package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;
import com.vti.presentationlayer.UserController;
import com.vti.utils.ScannerUtils;

public class Function {
	private UserController userController;

	public Function() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userController = new UserController();
	}

	public void getListUser() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<User> users = userController.getListUsers();
		String leftAlignFormat = "| %-2d | %-16s | %-22s | %-11s | %-11s |%n";
		System.out.format("+----+------------------+------------------------+-------------+-------------+%n");
		System.out.format("|ID  |    Fullname      |   Email                | Password    |     Role    |%n");
		System.out.format("+----+------------------+------------------------+-------------+-------------+%n");

		for (User user : users) {
			System.out.format(leftAlignFormat, user.getId(), user.getFullName(), user.getEmail(), user.getPassword(),
					user.getRole());
		}
		System.out.format("+----+------------------+------------------------+-------------+-------------+%n");
	}

	public void getUserById() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			System.out.println("------------------------------");
			System.out.println("Mời chọn chức vụ muốn tìm: ");
			System.out.println("1. Manager");
			System.out.println("2. Employee");
			System.out.println("Mời nhập lựa chọn: ");
			int role2 = ScannerUtils.inputInt();
			
			System.out.println("------------------------------");
			System.out.print("Mời bạn nhập vào ProjectID muốn tìm: ");
			int id = ScannerUtils.inputInt();

			if (userController.isUserIdExits(id) && role2 == 1) {
				System.out.println(userController.getUserById(id, "MANAGER"));
				return;
			} else if (userController.isUserIdExits(id) && role2 == 2) {
				System.out.println(userController.getUserById(id, "EMPLOYEE"));
				return;
			} else {
				System.err.println("id không tồn tại! Mời nhập lại!");
			}
			
		}
	}


	public User login() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.print("Mời bạn nhập vào Email: ");
			String email = ScannerUtils.inputEmail();

			System.out.print("Mời bạn nhập password: ");
			String password = ScannerUtils.inputPassword();
			try {
				return userController.getLogin(email, password);

			} catch (Exception e) {
				System.err.println(e.getMessage() + "\n");
			}
		}
	}

}
