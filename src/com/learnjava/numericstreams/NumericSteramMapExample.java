package com.learnjava.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author pramodr
 *
 */
public class NumericSteramMapExample {

	static List<Integer> mapToObject() {
		return IntStream.rangeClosed(1, 5) // IntStream
				.mapToObj(i -> {
					return new Integer(i); // converting to Integer.
				}).collect(Collectors.toList());
	}

	static long mapToLong() {
		return IntStream.rangeClosed(1, 5).mapToLong(i -> i).sum();
	}

	static double mapToDouble() {
		return IntStream.rangeClosed(1, 5).mapToDouble(i -> i).sum();
	}

	public static void main(String[] args) {
		System.out.println("mapToObject : " + mapToObject());
		System.out.println("mapToLong : " + mapToLong());
		System.out.println("mapToDouble : " + mapToDouble());
	}
}
