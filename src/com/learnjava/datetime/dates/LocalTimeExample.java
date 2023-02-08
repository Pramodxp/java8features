package com.learnjava.datetime.dates;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author pramodr
 *
 */
public class LocalTimeExample {
	public static void main(String[] args) {
		// create an instance of local Time.-- gives machines current time.
		LocalTime localTime = LocalTime.now();
		System.out.println("localTime : " + localTime);

//		differrent options to create local time
		LocalTime localTime2 = LocalTime.of(23, 23);
		System.out.println("localTime2 : " + localTime2);

		LocalTime localTime3 = LocalTime.of(23, 23, 23);
		System.out.println("localTime3 : " + localTime3);

		LocalTime localTime4 = LocalTime.of(23, 23, 23, 234);
		System.out.println("localTime3 : " + localTime4);

		/// how to get the hour min and second from LocalTime instance
		System.out.println("getHour : " + localTime.getHour());
		System.out.println("getMinute : " + localTime.getMinute());
		System.out.println("getSecond : " + localTime.getSecond());

		// only use the chrono field related to the time instance
		System.out.println("get ChronoField.CLOCK_HOUR_OF_DAY : " + localTime.get(ChronoField.CLOCK_HOUR_OF_DAY));

		// this will represent the current time in seconds.
		System.out.println("toSecondOfDay : " + localTime.toSecondOfDay());

		// modify the time when it is created.
		// modify the values of the LocalTime.
		// LocalTime is immutable it dosent change the actual instance.

		System.out.println("minusHours : " + localTime.minusHours(2));
		System.out.println("minus ChronoUnit.HOURS: " + localTime.minus(2, ChronoUnit.HOURS));

		System.out.println("with LocalTime.MIDNIGHT : " + localTime.with(LocalTime.MIDNIGHT));

		// set hour for the current time
		System.out.println("with  ChronoField.HOUR_OF_DAY : " + localTime.with(ChronoField.HOUR_OF_DAY, 22));

		// add minuits to the current time
		System.out.println("plusMinutes : " + localTime.plusMinutes(20));
		
		System.out.println("plusMinutes : " + localTime.withHour(10));
		

	}
}
