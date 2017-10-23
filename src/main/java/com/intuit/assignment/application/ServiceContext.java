package com.intuit.assignment.application;

public class ServiceContext {

	private int userId = -1;

	private int screeningId = -1;

	private int[] seatIds;

	private AppnStage apStage;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(int screeningId) {
		this.screeningId = screeningId;
	}

	public int[] getSeatIds() {
		return seatIds;
	}

	public void setSeatIds(int[] seatIds) {
		this.seatIds = seatIds;
	}

	public AppnStage getApStage() {
		return apStage;
	}

	public void setApStage(AppnStage apStage) {
		this.apStage = apStage;
	}

	public enum AppnStage {
		Login, MainMenu, SeatSelection, SeatAvailability, CreateReservation, Cancel
	}

}
