package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

public class Demo {
	public static void main(String[] args)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		menuLogin();
	}

	private static void menuLogin() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Function function = new Function();
		User user = function.login();
		System.out.println("Đăng nhập thành công!");
		System.out.println(user.getFullName() + " - " + user.getRole());
		if (user.getRole() == Role.MANAGER) {
			menuManager(user);
		} else {
			menuUser(user);
		}
	}

	private static void menuUser(User user) {
		System.out.println("Chức vụ Employee không có chức năng!");
	}

	private static void menuManager(User user)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Function function = new Function();
		System.out.println("--------------MENU--------------");
		System.out.println("Chọn chức năng sử dụng: ");
		System.out.println("1: In ra danh sách các Manager và Project");
		System.out.println("2: Tìm User theo ProjectID");
		System.out.println("3: Login");
		System.out.println("4: Thoát chương trình");

		while (true) {
			System.out.print("Mời bạn nhập chức năng: ");
			int choose = ScannerUtils.inputInt();

			switch (choose) {
			case 1:
				function.getListUser();
				break;
			case 2:
				function.getUserById();
				break;
			case 3:
				function.login();
				break;
			case 4:
				System.out.println("Đã thoát chương trình!");
				return;
			}
		}
	}
}
