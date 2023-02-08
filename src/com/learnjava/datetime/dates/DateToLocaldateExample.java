package com.learnjava.datetime.dates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateToLocaldateExample {
	public static void main(String[] args) {

		// performing util conversion.java.util.date and viseversa
		Date date = new Date();
		System.out.println("util date : " + date);
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println("util date converted localdate : " + localDate);

		// how to convert localdate to the java.util.Date
		Date date1 = new Date().from(localDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
		System.out.println("date1 : " + date1);

		// java.sql.Date to localDate and viseversa

		java.sql.Date date2 = java.sql.Date.valueOf(localDate);
		System.out.println("date2 : " + date2);
		LocalDate localDate2 = date2.toLocalDate();
		System.out.println("localDate2 : " + localDate2);
		
		

	}
}
