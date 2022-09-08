package com.vti.entity;

public class Emloyee extends User {
	private String ProSkill;
//
//	public Emloyee(int id, String fullName, String email, String password, Role role, String proSkill) {
//		super(id, fullName, email, password, role);
//		ProSkill = proSkill;
//	}

	public String getProSkill() {
		return ProSkill;
	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	@Override
	public String toString() {
		return super.toString() + "Employee [ProSkill=" + ProSkill + "]";
	}

}
