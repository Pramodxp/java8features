package com.learnjava.datetime.dates;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class ZonedDateTimeExample {
	public static void main(String[] args) {
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("ZonedDateTime : " + zonedDateTime);

		// get offset value and zoneId value form ZonedDateTime.
		System.out.println("zoneoffset : " + zonedDateTime.getOffset());
		System.out.println("zoneId : " + zonedDateTime.getZone());

		// get all the available zoneIds
		System.out.println("getAvailableZoneIds : ");
		ZoneId.getAvailableZoneIds().forEach(zone -> System.out.println(zone));

		System.out.println("No of zones available : " + ZoneId.getAvailableZoneIds().size());

		// how to get different time zones in america. CST/EST/MST/PST
		System.out.println("UTC : " + ZonedDateTime.now(ZoneId.of("UTC")));
		System.out.println("Chicago CST : " + ZonedDateTime.now(ZoneId.of("America/Chicago")));
		System.out.println("Detroit EST : " + ZonedDateTime.now(ZoneId.of("America/Detroit")));
		System.out.println("LA PST : " + ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
		System.out.println("Denver MST : " + ZonedDateTime.now(ZoneId.of("America/Denver")));

		// zonedateandtime which takes in the colck.
		System.out.println("Zone using clock : " + ZonedDateTime.now(Clock.system(ZoneId.of("America/Chicago"))));

		// convert a localdatetime into zonedatetime with out zone
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Chicago"));
		System.out.println("America/Chicago zone localdate time : " + localDateTime);

		LocalDateTime localDateTime1 = LocalDateTime.now(Clock.system(ZoneId.of("America/Chicago")));
		System.out.println("America/Chicago clock localdate time : " + localDateTime1);

		// creating localdatetime using of instant method
		LocalDateTime ofInstant = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("America/Chicago"));
		System.out.println("ofInstant : " + ofInstant);

		// convert from localdatetime, instant to zonelocaldate and time

		LocalDateTime localDateTime2 = LocalDateTime.now();
		System.out.println("localdatetime2 : " + localDateTime2);

		ZonedDateTime dateTime = localDateTime2.atZone(ZoneId.of("America/Denver"));

		System.out.println("converted local date time to zone date time : " + dateTime);

		ZonedDateTime zonedDateTime2 = Instant.now().atZone(ZoneId.of("America/Chicago"));
		System.out.println("instant to zone date time : " + zonedDateTime2);

		//add the offset to the localdate and time and returns offsetdateTime.
		OffsetDateTime offsetDateTime = localDateTime2.atOffset(ZoneOffset.ofHours(-6));
		System.out.println("offsetDateTime : " + offsetDateTime);
		
		

	}
}
