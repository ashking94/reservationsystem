package com.intuit.assignment.daolayer.managers;

import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.entities.SeatReserved;

public class SeatReservedManager extends AbstractManager<SeatReserved> {

	private SeatReservedManager() {
	}

	private static final SeatReservedManager INSTANCE = new SeatReservedManager();

	public static SeatReservedManager getInstance() {
		return INSTANCE;
	}

	@Override
	void validate(SeatReserved ele) throws AppException {
		// TODO Auto-generated method stub

	}

}
