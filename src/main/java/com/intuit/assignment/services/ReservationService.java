package com.intuit.assignment.services;

import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.daolayer.managers.ReservationManager;
import com.intuit.assignment.entities.Reservation;

public class ReservationService {

	private static ReservationManager reservationManager = ReservationManager.getInstance();

	public static Reservation retrieveReservations(int reservationId) {
		return reservationManager.getList(x -> x.getId() == reservationId).get(0);
	}

	public static boolean isPresent(int id) {
		return reservationManager.getMap().containsKey(String.valueOf(id));
	}

	public static void insert(Reservation reservation, String code) throws AppException {
		reservationManager.insert(reservation, code);
	}

}
