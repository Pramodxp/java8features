package com.learnjava.datetime.dates;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ComparingDatesPeriodsExample {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(2018, 1, 1);
		LocalDate localDate1 = LocalDate.of(2018, 12, 31);

		// until will give you the result as period.
		Period period = localDate.until(localDate1);
		System.out.println("getDays : " + period.getDays()); // only compares days
		System.out.println("getMonths : " + period.getMonths()); // only compares months
		System.out.println("getYears : " + period.getYears()); // only compares years

		Period periodofdays = Period.ofDays(10);
		System.out.println("periodofdays.getDays : " + periodofdays.getDays());

		Period ofYears = Period.ofYears(20);
		System.out.println("ofYears.getYears() : " + ofYears.getYears());
		// calculate the months in the period
		System.out.println("toTotalMonths : " + ofYears.toTotalMonths());

		// period class has the factory method
		//between methods accepts parameters localdate not localtime.
		//dosent have the any time related
		Period between = Period.between(localDate, localDate1);
		System.out.println("between.get(ChronoUnit.DAYS) : " + between.get(ChronoUnit.DAYS));
		System.out.println("between.get(ChronoUnit.MONTHS) : " + between.get(ChronoUnit.MONTHS));
		System.out.println("between.get(ChronoUnit.YEARS) : " + between.get(ChronoUnit.YEARS));
		

	}
}
