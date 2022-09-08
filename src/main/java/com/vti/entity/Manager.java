package com.vti.entity;

public class Manager extends User {
	private int ExpInYear;

//	public Manager(int id, String fullName, String email, String password, Role role, int expInYear) {
//		super(id, fullName, email, password, role);
//		ExpInYear = expInYear;
//	}

	public int getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}

	@Override
	public String toString() {
		return super.toString() + "Manager [ExpInYear=" + ExpInYear + "]";
	}

}
