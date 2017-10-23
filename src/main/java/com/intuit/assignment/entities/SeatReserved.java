package com.intuit.assignment.entities;

public class SeatReserved {

	private static int count = 0;

	public SeatReserved(int seatId, int reservationId, int screeningId) {
		this.id = count++;
		this.seatId = seatId;
		this.reservationId = reservationId;
		this.screeningId = screeningId;
	}

	private final int id;

	private int seatId;

	private int reservationId;

	private int screeningId;

	private boolean cancelled;

	public int getId() {
		return id;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(int screeningId) {
		this.screeningId = screeningId;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public enum Column {

		ID("id"), SEATID("seatId");

		Column(String code) {
			this.code = code;
		}

		private String code;

		public String getCode() {
			return code;
		}

	}

}
