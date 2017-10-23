package com.intuit.assignment.entities;

public class Seat {

	private static int count = 0;

	public Seat(int row, int number, int auditoriumId) {
		this.id = count++;
		this.row = row;
		this.number = number;
		this.auditoriumId = auditoriumId;
	}

	private final int id;

	private int row;

	private int number;

	private int auditoriumId;

	public int getId() {
		return id;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getauditoriumId() {
		return auditoriumId;
	}

	public void setauditoriumId(int auditoriumId) {
		this.auditoriumId = auditoriumId;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", row=" + row + ", number=" + number + ", auditoriumId=" + auditoriumId + "]";
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
