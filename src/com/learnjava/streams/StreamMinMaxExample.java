package com.learnjava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author pramodr
 *
 */
public class StreamMinMaxExample {

	public static Integer findMaxOfIntegers(List<Integer> integers) {
		return integers.stream() // stream<Integer>
				// 10 -> y
				// 5 -> y
				// 4 -> y
				// 8 -> y
				// 12 -> y
				// x -> will be initially 0, and for every iteration it will be having result
				// meaning max value of comparition.
				.reduce(0, (x, y) -> x > y ? x : y);
	}

	public static Optional<Integer> findMaxOfIntegersOptional(List<Integer> integers) {
		return integers.stream() // stream<Integer>
				// 10 -> y
				// 5 -> y
				// 4 -> y
				// 8 -> y
				// 12 -> y
				// x -> will be initially 0, and for every iteration it will be having result
				// meaning max value of comparition.
				.reduce((x, y) -> x > y ? x : y);
	}
	
	
	public static Integer findMinOfIntegers(List<Integer> integers) {
		return integers.stream() // stream<Integer>
				// 10 -> y
				// 5 -> y
				// 4 -> y
				// 8 -> y
				// 12 -> y
				// x -> will be initially 0, and for every iteration it will be having result
				// meaning max value of comparition.
				.reduce(0, (x, y) -> x < y ? x : y);
	}

	public static Optional<Integer> findMinOfIntegersOptional(List<Integer> integers) {
		return integers.stream() // stream<Integer>
				// 10 -> y
				// 5 -> y
				// 4 -> y
				// 8 -> y
				// 12 -> y
				// x -> will be initially 0, and for every iteration it will be having result
				// meaning max value of comparition.
				.reduce((x, y) -> x < y ? x : y);
	}


	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(10, 5, 4, 8, 12);

		Integer findMaxOfIntegers = findMaxOfIntegers(integers);

		System.out.println("findMaxOfIntegers : " + findMaxOfIntegers);

		Optional<Integer> optional = findMaxOfIntegersOptional(integers);
		if (optional.isPresent()) {
			System.out.println("findMaxOfIntegersOptional : " + optional.get());
		}
		
		Integer findMinOfIntegers = findMinOfIntegers(integers);
		
		System.out.println("findMinOfIntegers : " + findMinOfIntegers);
		
		Optional<Integer> optional1 = findMinOfIntegersOptional(integers);
		if (optional1.isPresent()) {
			System.out.println("findMinOfIntegersOptional : " + optional1.get());
		}
	}
}
