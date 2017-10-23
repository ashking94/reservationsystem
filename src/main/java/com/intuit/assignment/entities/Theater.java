package com.intuit.assignment.entities;

public class Theater {

	private static int count = 0;

	public Theater(String name) {
		this.id = count++;
		this.name = name;
	}

	private final int id;

	private String name;

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Theater.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Theater [id=" + id + ", name=" + name + "]";
	}

	public enum Column {

		ID("id");

		Column(String code) {
			this.code = code;
		}

		private String code;

		public String getCode() {
			return code;
		}

	}

}
