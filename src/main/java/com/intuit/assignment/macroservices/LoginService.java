package com.intuit.assignment.macroservices;

import com.intuit.assignment.application.ServiceContext;
import com.intuit.assignment.receivers.CancelTicketReceiver;
import com.intuit.assignment.receivers.CreateReservationReceiver;
import com.intuit.assignment.receivers.IReceiver;
import com.intuit.assignment.receivers.LoginFlowReceiver;
import com.intuit.assignment.receivers.MainMenuReceiver;
import com.intuit.assignment.receivers.SeatSelectionReceiver;

public class LoginService implements IReceiver {

	@Override
	public void action(ServiceContext serviceContext) throws Exception {
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (serviceContext == null) {
			serviceContext = new ServiceContext();
			serviceContext.setApStage(ServiceContext.AppnStage.Login);
		}
		new LoginFlowReceiver().action(serviceContext);
		new MainMenuReceiver().action(serviceContext);
		new CancelTicketReceiver().action(serviceContext);
		new SeatSelectionReceiver().action(serviceContext);
		new CreateReservationReceiver().action(serviceContext);
	}

}
