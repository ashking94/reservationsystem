package com.intuit.assignment.services;

import java.util.List;
import java.util.function.Predicate;

import com.intuit.assignment.daolayer.managers.TheaterManager;
import com.intuit.assignment.entities.Theater;

public class TheaterService {

	private static TheaterManager theaterManager = TheaterManager.getInstance();

	public static Theater retrieveTheater(int id) {
		return theaterManager.getList(x -> x.getId() == id).get(0);
	}

	public static Theater retrieveTheater(Predicate<Theater> predicate) {
		return theaterManager.getList(predicate).get(0);
	}

	public static List<Theater> retrieveAllTheaters() {
		return theaterManager.getList();
	}
}
