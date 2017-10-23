package com.intuit.assignment.entities;

public class Reservation {

	private static int count = 0;

	public Reservation(int screeningId, int userReservedId, String reservationContact, boolean paid) {
		this.id = count++;
		this.screeningId = screeningId;
		this.userReservedId = userReservedId;
		this.reservationContact = reservationContact;
		this.paid = paid;
	}

	private final int id;

	private int screeningId;

	private int userReservedId;

	private String reservationContact;

	private boolean paid;

	private boolean cancelled;

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Reservation.count = count;
	}

	public int getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(int screeningId) {
		this.screeningId = screeningId;
	}

	public int getUserReservedId() {
		return userReservedId;
	}

	public void setUserReservedId(int userReservedId) {
		this.userReservedId = userReservedId;
	}

	public String getReservationContact() {
		return reservationContact;
	}

	public void setReservationContact(String reservationContact) {
		this.reservationContact = reservationContact;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public int getId() {
		return id;
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
