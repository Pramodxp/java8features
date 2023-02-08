package com.learnjava.datetime.dates;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ComparingTimeDurationExample {
	public static void main(String[] args) {
		LocalTime localTime = LocalTime.of(7, 20);
		LocalTime localTime1 = LocalTime.of(8, 20);

		System.out.println("LocalTime.Until minuits : " + localTime.until(localTime1, ChronoUnit.MINUTES));
		System.out.println("LocalTime.Until SECONDS : " + localTime.until(localTime1, ChronoUnit.SECONDS));

		// Duration.between(localtime,localtime2);

		Duration duration = Duration.between(localTime, localTime1);
		System.out.println("minuites : " + duration.toMinutes());

		Duration ofHours = Duration.ofHours(2);
		System.out.println("toMinuites : " + ofHours.toMinutes());
	}
}
