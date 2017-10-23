package com.intuit.assignment.daolayer.managers;

import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.entities.Theater;

public class TheaterManager extends AbstractManager<Theater> {

	private TheaterManager() {
	}

	private static final TheaterManager INSTANCE = new TheaterManager();

	public static TheaterManager getInstance() {
		return INSTANCE;
	}

	@Override
	void validate(Theater ele) throws AppException {
	}

}
