package com.learnjava.numericstreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author pramodr
 *
 */
public class NumericStreamsRangesExample {
	public static void main(String[] args) {
		IntStream intStream = IntStream.range(1, 50);
		System.out.println("\nIntsteram Range function : " + intStream.count());

		IntStream.range(1, 50).forEach(value -> System.out.print(value + " , "));

		System.out.println("\nIntStream rangeClosed() : " + IntStream.rangeClosed(1, 50).count());

		IntStream.rangeClosed(1, 50).forEach(value -> System.out.print(value + " , "));

		// LongStream
		System.out.println("\n\nlong Stream : \n");
		LongStream.range(1, 50).forEach(value -> System.out.print(value + " , "));

		System.out.println("\nLongStream Range function : " + LongStream.range(1, 50).count());
		System.out.println("\nLongStream Range function : " + LongStream.rangeClosed(1, 50).count());

		// DoubleStream
		LongStream.range(1, 50).asDoubleStream().forEach(value -> System.out.print(value + " ,"));

	}
}
