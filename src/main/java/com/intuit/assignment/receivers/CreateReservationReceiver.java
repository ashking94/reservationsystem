package com.intuit.assignment.receivers;

import com.intuit.assignment.application.ServiceContext;
import com.intuit.assignment.entities.Reservation;
import com.intuit.assignment.entities.SeatReserved;
import com.intuit.assignment.services.ReservationService;
import com.intuit.assignment.services.SeatReservedService;

public class CreateReservationReceiver extends CommonMethodsReceiver implements IReceiver {

	@Override
	public void action(ServiceContext serviceContext) throws Exception {
		if (serviceContext.getApStage() != ServiceContext.AppnStage.CreateReservation)
			return;

		System.out.println("Accepting Payment");
		try {
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Payment accepted.");

		System.out.println("Please enter 10 digit mobile number.");
		long mobileNo = sc.getNextLong();
		while (mobileNo / (long) Math.pow(10, 9) == 0 || mobileNo / (long) Math.pow(10, 9) > 10) {
			System.out.println("Please enter 10 digit mobile number.");
			mobileNo = sc.getNextLong();
		}

		Reservation reservation = new Reservation(serviceContext.getScreeningId(), serviceContext.getUserId(),
				String.valueOf(mobileNo), true);
		ReservationService.insert(reservation, Reservation.Column.ID.getCode());
		for (Integer seatId : serviceContext.getSeatIds()) {
			SeatReserved seatReserved = new SeatReserved(seatId, reservation.getId(), reservation.getScreeningId());
			SeatReservedService.insert(seatReserved, SeatReserved.Column.ID.getCode());
		}
		System.out.println("Booking is created");
		System.out.println("Please use reference Id for all communication - " + reservation.getId());
		System.out.println("Going to Login..");

	}

}
