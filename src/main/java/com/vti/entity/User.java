package com.vti.entity;

public class User {
	private int id;
	private String fullName;
	private String email;
	private String password;
	private Role role;
	private String ProSkill;
	private int ExpInYear;
	

	public User() {
		
	}
	
//	public User(int id, String fullName, String email, String password, Role role) {
//		this.id = id;
//		this.fullName = fullName;
//		this.email = email;
//		this.password = password;
//		this.role = role;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	

	public String getPassword() {
		return password;
	}

	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	public String getProSkill() {
		return ProSkill;
	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	public int getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password + ", role="
				+ role + "]";
	}

}
