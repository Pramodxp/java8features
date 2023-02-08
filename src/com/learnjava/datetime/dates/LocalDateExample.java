package com.learnjava.datetime.dates;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample {
	public static void main(String[] args) {
		// gives the systems current date
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate : " + localDate);

		/*
		 * unsupported scenarios
		 * 
		 * 
		 */

//		System.out.println("minus minuits ccannot be done : " + localDate.minus(1, ChronoUnit.MINUTES)); //throws us undupported trmporal type exception because local date does not contain time to substract.

		// to check we can use us supported
		System.out.println("isSupported " + localDate.isSupported(ChronoUnit.MINUTES)); 
		System.out.println("isSupported " + localDate.isSupported(ChronoUnit.YEARS)); 
		
		
		// creating LocalDate in multiple ways.
		// LocalDate.of method is used to create the date by providing parameters.
		LocalDate localDate2 = LocalDate.of(2023, 10, 15);
		System.out.println("localDate2 : " + localDate2);

		LocalDate localDate3 = LocalDate.ofYearDay(2023, 365);
		System.out.println("localDate3 : " + localDate3);

		/*
		 * get values form localdate
		 */
		System.out.println("getMonth : " + localDate.getMonth());
		System.out.println("getMonthValue : " + localDate.getMonthValue());
		System.out.println("getDayOfWeek : " + localDate.getDayOfWeek());
		System.out.println("getDayOfYear : " + localDate.getDayOfYear());

		// chrono field is subclass of Temporalfield
		System.out.println("Day of the month using get : " + localDate.get(ChronoField.DAY_OF_MONTH));

		/*
		 * modifying Local date
		 * 
		 * modifying do not disturb the existing instance, hence creates new instance on
		 * every modification.
		 * 
		 */

//		increasing date
		System.out.println("plusDays " + localDate.plusDays(2));
		System.out.println("plusMonths " + localDate.plusMonths(2));

//		decreasing dates
		System.out.println("minusDays " + localDate.minusDays(2));

		System.out.println("withYear " + localDate.withYear(2019));
		System.out.println("with ChronoField " + localDate.with(ChronoField.YEAR, 2020));
		System.out.println("with TemporalAdjusters " + localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
		System.out.println("with TemporalAdjusters " + localDate.with(TemporalAdjusters.lastDayOfMonth()));

		// substract the years
		System.out.println("minusYears " + localDate.minusYears(2));
		System.out.println("minus ChronoUnit " + localDate.minus(2, ChronoUnit.YEARS));

		/*
		 * Additional support methods
		 */
		System.out.println("isLeapYear " + localDate.isLeapYear());
		System.out.println("isLeapYear " + LocalDate.ofYearDay(2020, 1).isLeapYear());

		// two days are equal or not.
		System.out.println("isEqual " + localDate.isEqual(localDate2));
		System.out.println("isBefore " + localDate.isBefore(localDate2));
		System.out.println("isAfter " + localDate.isAfter(localDate2));

	}
}
