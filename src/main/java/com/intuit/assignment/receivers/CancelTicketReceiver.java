package com.intuit.assignment.receivers;

import java.util.List;

import com.intuit.assignment.application.ServiceContext;
import com.intuit.assignment.entities.Reservation;
import com.intuit.assignment.entities.SeatReserved;
import com.intuit.assignment.services.ReservationService;
import com.intuit.assignment.services.SeatReservedService;

public class CancelTicketReceiver extends CommonMethodsReceiver implements IReceiver {

	@Override
	public void action(ServiceContext serviceContext) throws Exception {
		if (ServiceContext.AppnStage.Cancel != serviceContext.getApStage())
			return;
		boolean tryAgain = true;
		while (tryAgain) {
			System.out.println("Please enter the reservation Id to cancel the booking.");
			int reservationId = sc.getNextInt();
			boolean isPresent = ReservationService.isPresent(reservationId);
			Reservation reservation = null;
			boolean isOriginalUser = false;
			if (isPresent) {
				reservation = ReservationService.retrieveReservations(reservationId);
				isOriginalUser = reservation.getUserReservedId() == serviceContext.getUserId();
			}

			if (isOriginalUser) {
				List<SeatReserved> seatReserveds = SeatReservedService
						.retrieveSeatReserveds(x -> x.getReservationId() == reservationId);
				if (seatReserveds.stream().allMatch(x -> x.isCancelled()))
					System.out.println("Your booking is already cancelled.");
				else {
					seatReserveds.forEach(x -> x.setCancelled(true));
					System.out.println("Your booking is cancelled.");
				}
			} else if (!isPresent) {
				System.out.println("Reservation ID does not exist. Please try again.");
			} else {
				System.out.println("You don't have access to cancel this booking. "
						+ "Please login with correct username and password.");
			}
			System.out.println("Going to Login Page.");
			tryAgain = false;
		}
	}

}
