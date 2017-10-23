package com.intuit.assignment.receivers;

import com.intuit.assignment.application.ServiceContext;
import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.daolayer.exception.AppExceptionEnum;

public class MainMenuReceiver extends CommonMethodsReceiver implements IReceiver {

	@Override
	public void action(ServiceContext serviceContext) throws AppException {

		try {
			boolean tryAgain = true;

			while (tryAgain) {
				System.out.println("Please select the operation that you wish to perform :");
				System.out.println("Book a ticket (a)");
				System.out.println("Check Seat Availability (b)");
				System.out.println("Cancel Ticket (c)");
				char ch = sc.getFirstChar();
				switch (ch) {
				case 'a':
					serviceContext.setApStage(ServiceContext.AppnStage.SeatSelection);
					showBookTicketOptions(serviceContext);
					tryAgain = false;
					break;
				case 'b':
					serviceContext.setApStage(ServiceContext.AppnStage.SeatAvailability);
					showBookTicketOptions(serviceContext);
					tryAgain = false;
					break;
				case 'c':
					serviceContext.setApStage(ServiceContext.AppnStage.Cancel);
					tryAgain = false;
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			}
		} catch (Exception e) {
			throw new AppException(AppExceptionEnum.MAINMENU, MainMenuReceiver.class.getSimpleName());
		}
	}

}
