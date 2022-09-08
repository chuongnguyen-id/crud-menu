package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	static Scanner scanner = new Scanner(System.in);

	public static void inputAge() {

		System.out.println(" mời nhập tuổi ");
		while (true) {
			try {
				int inputPositive = Integer.parseInt(scanner.nextLine().trim());
				if (inputPositive >= 0) {
					System.err.println(" số tuổi vừa điền là " + inputPositive);
				} else if (inputPositive < 0) {
					System.err.println("Wrong inputing! The age must be greater than 0, please input again");
				}

			} catch (Exception e) {
				System.err.println("wrong inputing! Please input an age as int, input again");

			}
		}

	}

	public static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println("wrong inputing! Please input as int, input again");
			}
		}
	}

	public static float inputFloat() {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println("wrong inputing! Please input as float, input again");
			}
		}
	}

	public static String inputString() {
		while (true) {
			String inputString = scanner.nextLine().trim();
			if (!inputString.isEmpty()) {
				return inputString;
			} else {
				System.err.println("Please input again!");
			}
		}
	}
	
	public static String inputEmail() {
		while (true) {
			String inputEmail = scanner.nextLine().trim();
			if (inputEmail.contains("@gmail.com")) {
				return inputEmail;
			} else {
				System.err.println("Wrong inputing! Please input as email, input again!");
			}
		}
	}
	
	public static String inputPassword() {
		while (true) {
			String inputPassword = scanner.nextLine().trim();
			if (inputPassword.length() < 6 || inputPassword.length() > 12) {
				System.err.println("Wrong inputing! Please input as password, input again!");
				continue;
			}

			boolean hasAtLeast1Character = false;

			for (int i = 0; i < inputPassword.length(); i++) {
				if (Character.isUpperCase(inputPassword.charAt(i)) == true) {
					hasAtLeast1Character = true;
					break;
				}
			}
			if (hasAtLeast1Character == true) {
				return inputPassword;
			} else {
				System.err.println("Please input as password, input again!");
			}
		}
	}
}