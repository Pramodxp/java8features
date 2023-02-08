package com.learnjava.datetime.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalDateTimeExample {

	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("localDateTime : " + localDateTime);

		LocalDateTime localDateTime1 = LocalDateTime.of(2022, 9, 9, 20, 20);
		System.out.println("localDateTime1 : " + localDateTime1);

		// creating localdatetime using locu + localDateTime2);

		// getting time from localdatetime.
		System.out.println("hour : " + localDateTime.getHour());
		System.out.println("Minute : " + localDateTime.getMinute());
		System.out.println("Second : " + localDateTime.getSecond());
		System.out.println("Nano : " + localDateTime.getNano());
		System.out.println("Day of month : " + localDateTime.getDayOfMonth());
		System.out.println("DAY_OF_MONTH : " + localDateTime.get(ChronoField.DAY_OF_MONTH));

		// mofiying Localdatetime
		System.out.println("plusHours : " + localDateTime.plusHours(2));
		System.out.println("minusDays : " + localDateTime.minusDays(2));

		System.out.println("withMonth : " + localDateTime.withMonth(12));

		// converting localdate and localtime to localdatetime and viseversa.
		LocalDate localDate = LocalDate.of(2019, 01, 01);
		System.out.println("atTime : " + localDate.atTime(12, 20));

		// we are going to add date to time and we get localdatetime.
		LocalTime localTime = LocalTime.of(23, 59);

		System.out.println("atDate : " + localTime.atDate(localDate));

		// get localdate and localtime from the localdatetime instance.

		LocalDateTime localDateTime2 = localTime.atDate(localDate);
		System.out.println("toLocalDate : "+localDateTime2.toLocalDate());
		System.out.println("toLocalTime : "+localDateTime2.toLocalTime());

	}

}
