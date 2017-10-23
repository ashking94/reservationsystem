package com.intuit.assignment.receivers;

import com.intuit.assignment.application.ServiceContext;
import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.daolayer.exception.AppExceptionEnum;
import com.intuit.assignment.services.UserService;
import com.intuit.assignment.util.DisplayUtil;

public class LoginFlowReceiver extends CommonMethodsReceiver implements IReceiver {

	@Override
	public void action(ServiceContext serviceContext) throws AppException {
		try {
			if (serviceContext.getApStage() != ServiceContext.AppnStage.Login)
				return;
			DisplayUtil.printDelimitedStart("Main Menu");
			boolean tryAgain = true;
			while (tryAgain) {
				System.out.println("Please login before proceeding");
				System.out.println("Username : ");
				String username = sc.getNextString();
				System.out.println("Password : ");
				String password = sc.getNextString();

				int employeeId = UserService.authenticateUser(username, password);
				if (employeeId != -1) {
					serviceContext.setUserId(employeeId);
					tryAgain = false;
				} else {
					System.out.println("Either username or password is wrong. Please try again!!");
				}
			}
			System.out.println("You are successfully logged in.");
			serviceContext.setApStage(ServiceContext.AppnStage.MainMenu);
		} catch (Exception e) {
			throw new AppException(AppExceptionEnum.LOGINERROR, LoginFlowReceiver.class.getSimpleName());
		}
	}

}
