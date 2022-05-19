package com.learnjava.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author pramodr
 *
 */
public class NumericStreamsBoxingUnboxingExample {

	static List<Integer> boxing() {
		return IntStream.rangeClosed(0, 50) // IntStream
				.boxed() // Stream<Integer>
				.collect(Collectors.toList()); // List<Integer>
	}

	static int unBoxing(List<Integer> integers) {
		return integers.stream().mapToInt(Integer::intValue).sum();
	}

	public static void main(String[] args) {
		System.out.println("boxing : " + boxing());
		System.out.println("unBoxing : " + unBoxing(boxing()));
	}
}
