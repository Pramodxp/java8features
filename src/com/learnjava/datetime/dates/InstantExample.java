package com.learnjava.datetime.dates;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class InstantExample {
	public static void main(String[] args) {
		// gives you the current time of this machine but it is represented in seconds.
		Instant instant = Instant.now();

		// if we print it prints as date and time because the toString method of the
		// instant class gives in human readable format.
		// but behind the scene it represent the time in a big number.
		System.out.println(instant);

		// methods that are part of instant class are:

		// jan 1st 1970 -> is called epoch -> every day has 86400 seconds.
		System.out.println("getEpochSecond : " + instant.getEpochSecond());

		// starting of the epoch
		Instant ofEpochSecond = Instant.ofEpochSecond(0);
		System.out.println("Instant.ofEpochSecond : " + ofEpochSecond);

		// Instant of now
		Instant now = Instant.now();
		System.out.println("Instant.now : " + now);

		// to find out the difference
		Duration duration = Duration.between(instant, now);

		// we are going to get the duration and represent that in nano form.
		System.out.println("duration : " + duration.getNano());

		System.out.println(Instant.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());
		
		
	}
}
