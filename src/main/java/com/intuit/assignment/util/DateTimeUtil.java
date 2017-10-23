package com.intuit.assignment.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

	public static final SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

	public static Date getDate(String dateString) throws ParseException {
		return format1.parse(dateString);
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date date(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		Date returnDate = new Date(cal.getTime().getTime());
		return returnDate;
	}
}
