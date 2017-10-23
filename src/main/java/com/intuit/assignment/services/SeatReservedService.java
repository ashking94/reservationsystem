package com.intuit.assignment.services;

import java.util.List;
import java.util.function.Predicate;

import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.daolayer.managers.SeatReservedManager;
import com.intuit.assignment.entities.SeatReserved;

public class SeatReservedService {

	private static SeatReservedManager seatReservedManager = SeatReservedManager.getInstance();

	public static List<SeatReserved> retrieveSeatReserveds(Predicate<SeatReserved> predicate) {
		return seatReservedManager.getList(predicate);
	}

	public static void insert(SeatReserved seatReserved, String code) throws AppException {
		seatReservedManager.insert(seatReserved, code);
	}

}
