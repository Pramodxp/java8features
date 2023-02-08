package com.learnjava.datetime.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Calendar;

public class NewDateTimeExample {
	public static void main(String[] args) {
		// LocalDate -- current machines local date
		LocalDate localDate = LocalDate.now();
		System.out.println("LocalDate is : " + localDate);
		// LocalTime
		LocalTime localTime = LocalTime.now();
		System.out.println("LocalTime is : " + localTime);
		// LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.UTC);
		System.out.println("LocalDateTime is : " + localDateTime);
		
		
		LocalDateTime local = LocalDateTime.now();
		System.out.println(local);
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
	}
}
