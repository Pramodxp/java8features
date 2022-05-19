package com.learnjava.numericstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author pramodr
 *
 */
public class NumericStreamsExample {

	static Integer sumOfNnumbers(List<Integer> numbers) {
		return numbers.stream().reduce(0, (x, y) -> x + y); // unboxing will happen everytime.
	}

	static Integer sumOfNnumbersIntStream() {
		return IntStream.rangeClosed(1, 6) // intStream
				.sum();
	}

//	performing sum of n numbers.
	public static void main(String[] args) {

		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);

		System.out.println("sum of N numbers : " + sumOfNnumbers(integerList));
		System.out.println("sum of N numbers Int Stream : " + sumOfNnumbersIntStream());
	}

}
