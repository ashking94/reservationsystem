package com.intuit.assignment.daolayer.managers;

import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.entities.Auditorium;

public class AuditoriumManager extends AbstractManager<Auditorium> {

	private AuditoriumManager() {
	}

	private static final AuditoriumManager INSTANCE = new AuditoriumManager();

	public static AuditoriumManager getInstance() {
		return INSTANCE;
	}

	@Override
	void validate(Auditorium ele) throws AppException{
		
	}

}
