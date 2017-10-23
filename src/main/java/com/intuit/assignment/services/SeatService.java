package com.intuit.assignment.services;

import java.util.List;
import java.util.function.Predicate;

import com.intuit.assignment.daolayer.managers.SeatManager;
import com.intuit.assignment.entities.Seat;

public class SeatService {

	private static SeatManager seatManager = SeatManager.getInstance();

	public static List<Seat> retrieveSeats(Predicate<Seat> predicate) {
		return seatManager.getList(predicate);
	}

}
