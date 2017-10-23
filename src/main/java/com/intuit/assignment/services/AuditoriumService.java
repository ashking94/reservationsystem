package com.intuit.assignment.services;

import java.util.List;
import java.util.function.Predicate;

import com.intuit.assignment.daolayer.managers.AuditoriumManager;
import com.intuit.assignment.entities.Auditorium;

public class AuditoriumService {

	private static AuditoriumManager auditoriumManager = AuditoriumManager.getInstance();

	public static Auditorium retrieveAuditoriums(int id) {
		return auditoriumManager.getList(x -> x.getId() == id).get(0);
	}

	public static List<Auditorium> retrieveAuditoriums(Predicate<Auditorium> predicate) {
		return auditoriumManager.getList(predicate);
	}
}
