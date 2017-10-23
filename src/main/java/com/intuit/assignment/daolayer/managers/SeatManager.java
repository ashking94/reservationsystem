package com.intuit.assignment.daolayer.managers;

import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.entities.Seat;

public class SeatManager extends AbstractManager<Seat> {

	private SeatManager() {
	}

	private static final SeatManager INSTANCE = new SeatManager();

	public static SeatManager getInstance() {
		return INSTANCE;
	}

	@Override
	void validate(Seat ele) throws AppException {
		// TODO Auto-generated method stub

	}

}
