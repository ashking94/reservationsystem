package com.intuit.assignment.receivers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.intuit.assignment.application.ServiceContext;
import com.intuit.assignment.entities.Auditorium;
import com.intuit.assignment.entities.Screening;
import com.intuit.assignment.entities.Seat;
import com.intuit.assignment.entities.SeatReserved;
import com.intuit.assignment.services.AuditoriumService;
import com.intuit.assignment.services.ScreeningService;
import com.intuit.assignment.services.SeatReservedService;
import com.intuit.assignment.services.SeatService;

public class SeatSelectionReceiver extends CommonMethodsReceiver implements IReceiver {

	@Override
	public void action(ServiceContext serviceContext) throws Exception {
		if (ServiceContext.AppnStage.SeatSelection == serviceContext.getApStage()
				|| ServiceContext.AppnStage.SeatAvailability == serviceContext.getApStage()) {
			boolean tryAgain = true;
			Screening screening = ScreeningService.retrieveScreenings(x -> x.getId() == serviceContext.getScreeningId())
					.get(0);
			Auditorium auditorium = AuditoriumService.retrieveAuditoriums(screening.getAuditoriumId());
			List<Seat> seats = SeatService.retrieveSeats(s -> s.getauditoriumId() == screening.getAuditoriumId());
			while (tryAgain) {
				System.out.println("Refer the seating arrangement below -");
				System.out.println("                    Towards Screen");
				int seatsPerRow = 10;
				int noOfRows = auditorium.getmaxCapacity() / seatsPerRow;
				System.out.format("%-10s", "Rows/No");
				for (int i = 0; i < 10; i++)
					System.out.format("%-4s", i + 1);
				System.out.println();
				int i, j;
				for (i = 0; i < noOfRows; i++) {
					System.out.format("%-10s", (char) (i + 97));
					for (j = 0; j < seatsPerRow; j++) {
						Seat seat = findSeat(i + 1, j + 1, seats);
						List<SeatReserved> lst = SeatReservedService
								.retrieveSeatReserveds(x -> x.getScreeningId() == screening.getId()
										&& x.getSeatId() == seat.getId() && !x.isCancelled());
						if (lst != null && !lst.isEmpty())
							System.out.format("%-4s", "NA");
						else
							System.out.format("%-4s", seat.getId());
					}
					System.out.println();
				}

				if (ServiceContext.AppnStage.SeatAvailability == serviceContext.getApStage()) {
					System.out.println("Going to Login Page.");
					return;
				}

				System.out.println("How many seats do you wish to book? (Max - 10)");
				int noOfSeats = sc.getNextInt();
				while (noOfSeats < 0 || noOfSeats > 10) {
					System.out.println("Enter a value between 1 and 10 (both inclusive)");
					noOfSeats = sc.getNextInt();
				}

				System.out.println("Enter the seat ID of the seat you wish to book."
						+ "\nPlease note the first left column and first top row represents the Row Number and Seat Number in the row respectively.");
				System.out.println(
						"If you want to book seat id 1, 2, and 3, please enter \"1 2 3\" i.e. space separated.");

				int[] seatIds = new int[noOfSeats];
				for (i = 0; i < noOfSeats; i++)
					seatIds[i] = sc.getNextInt();
				if (areSeatsValid(seatIds, seats)) {
					serviceContext.setSeatIds(seatIds);
					tryAgain = false;
				} else {
					System.out.println("Invalid input. Please try again.");
				}
			}
			if (ServiceContext.AppnStage.SeatSelection == serviceContext.getApStage())
				serviceContext.setApStage(ServiceContext.AppnStage.CreateReservation);
		}
	}

	private boolean areSeatsValid(int[] seatIds, List<Seat> seats) throws Exception {
		boolean isValid = true;
		Set<Integer> hashSet = new HashSet<>();
		for (int seatId : seatIds) {
			if (!seats.stream().anyMatch(x -> x.getId() == seatId) || hashSet.contains(seatId)) {
				isValid = false;
			}
			hashSet.add(seatId);
		}
		return isValid;
	}

	private static Seat findSeat(int row, int no, List<Seat> seats) throws Exception {
		return seats.stream().filter(x -> x.getRow() == row && x.getNumber() == no).findFirst().get();
	}
}
