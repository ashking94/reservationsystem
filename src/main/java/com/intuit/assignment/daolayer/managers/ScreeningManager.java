package com.intuit.assignment.daolayer.managers;

import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.entities.Screening;

public class ScreeningManager extends AbstractManager<Screening> {

	private ScreeningManager() {
	}

	private static final ScreeningManager INSTANCE = new ScreeningManager();

	public static ScreeningManager getInstance() {
		return INSTANCE;
	}

	@Override
	void validate(Screening ele) throws AppException {
		// TODO Auto-generated method stub

	}

}
