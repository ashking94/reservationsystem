package com.intuit.assignment.entities;

/*
 * This class would have a corresponding table in DB.
 * Type - Master Table
 */

public class User {

	private static int count = 0;

	public User(String username, String password) {
		this.id = count++;
		this.username = username;
		this.password = password;
	}

	private final int id;

	private String username;

	private String password;

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	public enum Column {

		ID("id"), USERNAME("username");

		Column(String code) {
			this.code = code;
		}

		private String code;

		public String getCode() {
			return code;
		}

	}

}
