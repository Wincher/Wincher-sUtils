package com.wincher.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtil {
	public static void main(String[] args) {
		iteratorDate(2014,2015);
	}

	private static void iteratorDate(int startYear,int endYear) {
		Calendar calendar = new GregorianCalendar();
		Calendar calendarEnd = new GregorianCalendar();
		calendar.set(Calendar.YEAR, startYear);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendarEnd.set(Calendar.YEAR, endYear + 1);
		calendarEnd.set(Calendar.MONTH, 11);
		calendarEnd.set(Calendar.DAY_OF_MONTH, 31);

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

		while (calendar.getTime().getTime() <= calendarEnd.getTime().getTime()) {
			System.out.println(sf.format(calendar.getTime()));
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
	}

}
