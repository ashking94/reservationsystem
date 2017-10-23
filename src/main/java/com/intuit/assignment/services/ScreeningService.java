package com.intuit.assignment.services;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import com.intuit.assignment.daolayer.managers.ScreeningManager;
import com.intuit.assignment.entities.Screening;
import com.intuit.assignment.util.DateTimeUtil;

public class ScreeningService {

	private static ScreeningManager screeningManager = ScreeningManager.getInstance();

	public static List<Screening> retrieveScreenings(Date screeningDate) {
		Date nextDay = DateTimeUtil.addDays(screeningDate, 1);
		List<Screening> lst = screeningManager.getList(
				x -> x.getScreenigStart().compareTo(screeningDate) > 0 && x.getScreenigStart().compareTo(nextDay) < 0);
		return lst;
	}

	public static List<Screening> retrieveScreenings(Predicate<Screening> predicate) {
		return screeningManager.getList(predicate);
	}

	public static boolean authenticateScreening(int id) {
		return screeningManager.getList(x -> x.getId() == id && x.getScreenigStart().compareTo(new Date()) > 0)
				.size() > 0;
	}

}
