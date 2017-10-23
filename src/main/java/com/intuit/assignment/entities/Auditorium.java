package com.intuit.assignment.entities;

public class Auditorium {

	private static int count = 0;

	public Auditorium(String name, int theaterId, int maxCapacity) {
		this.id = count++;
		this.theaterId = theaterId;
		this.name = name;
		this.maxCapacity = maxCapacity;
	}

	private final int id;

	private int theaterId;

	private String name;

	private int maxCapacity;

	public int getId() {
		return id;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getmaxCapacity() {
		return maxCapacity;
	}

	public void setmaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	@Override
	public String toString() {
		return "Auditorium [id=" + id + ", name=" + name + ", maxCapacity=" + maxCapacity + "]";
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
