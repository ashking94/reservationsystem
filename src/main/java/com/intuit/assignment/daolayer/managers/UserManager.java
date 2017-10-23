package com.intuit.assignment.daolayer.managers;

import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.entities.User;

public class UserManager extends AbstractManager<User> {

	private UserManager() {
	}

	private static final UserManager INSTANCE = new UserManager();

	public static UserManager getInstance() {
		return INSTANCE;
	}

	@Override
	void validate(User ele) throws AppException {
		// TODO Auto-generated method stub

	}

}
