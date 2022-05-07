package com.learnjava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author pramodr
 *
 */
public class StreamsSkipLimitExample {

	public static Optional<Integer> limit(List<Integer> integers) {
		return integers.stream() // stream<Integer> 6,7,8,9,10
				// preforming limit operation on stream.
				.limit(3) // Stream<Integer> 6,7,8
				.reduce((x, y) -> x + y); // 6+7+8 = 21
	}

	public static Optional<Integer> skip(List<Integer> integers) {
		return integers.stream() // stream<Integer> 6,7,8,9,10
				// performing skip operattion on stream.
				.skip(3) // Stream<Integer> 9,10
				.reduce((x, y) -> x + y); // 9+10 = 19
	}

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(6, 7, 8, 9, 10);

		Optional<Integer> limit = limit(integers);

		if (limit.isPresent()) {
			System.out.println("Limit result is : " + limit.get());
		} else {
			System.out.println("no input provided");
		}

		Optional<Integer> skip = skip(integers);

		if (skip.isPresent()) {
			System.out.println("Skip result is : " + skip.get());
		} else {
			System.out.println("no input provided");
		}
	}
}
