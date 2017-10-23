package com.intuit.assignment.daolayer.managers;

import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.entities.Reservation;

public class ReservationManager extends AbstractManager<Reservation> {

	private ReservationManager() {
	}

	private static final ReservationManager INSTANCE = new ReservationManager();

	public static ReservationManager getInstance() {
		return INSTANCE;
	}

	@Override
	void validate(Reservation ele) throws AppException {
		// TODO Auto-generated method stub

	}

}
