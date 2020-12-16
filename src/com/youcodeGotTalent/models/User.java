package com.youcodeGotTalent.models;

public class User {
	private long id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String first_name, String last_name, String email, String phone) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
	}

	public User(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", phone=" + phone + "]";
	}

//User methods

	// add user
	public void addUser() {

	}

	// find user
	public User findUserById() {
		return null;

	}

	// update user
	public void updateUser() {

	}
}
