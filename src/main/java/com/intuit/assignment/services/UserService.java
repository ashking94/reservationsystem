package com.intuit.assignment.services;

import java.util.List;

import com.intuit.assignment.daolayer.managers.UserManager;
import com.intuit.assignment.entities.User;

public class UserService {

	private static UserManager userManager = UserManager.getInstance();

	public static int authenticateUser(String username, String password) {
		List<User> lstUser = userManager
				.getList(e -> username.equals(e.getUsername()) && password.equals(e.getPassword()));
		int auth = -1;
		if (!lstUser.isEmpty() && lstUser.size() == 1)
			auth = lstUser.get(0).getId();
		return auth;
	}
}
