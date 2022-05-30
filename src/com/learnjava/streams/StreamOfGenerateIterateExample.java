package com.learnjava.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author pramodr
 *
 */
public class StreamOfGenerateIterateExample {
	public static void main(String[] args) {

		// takes in the input and creates the stream of that type.
		System.out.println("\nexecution of(T... values)\n");
		Stream<String> stringStream = Stream.of("adam", "aloy", "sheru", "shin");
		stringStream.forEach(System.out::println);

		// iterate is infinate we should have to limit it.
		// iterate parameters are 1 -> initial value , 2 -> unaryoperator.
		System.out.println("\nexecution of iterate(final T seed, final UnaryOperator<T> f)\n");
		Stream.iterate(1, x -> x * 2).limit(10).forEach(System.out::println);

		// generate goes on infinate.
		// parameter is supplier function
		// we should limit the supplier.
		System.out.println("\nexecution of generate(Supplier<? extends T> s)\n");
		Supplier<Integer> randomNumberSupplier = new Random()::nextInt;
		Stream.generate(randomNumberSupplier).limit(20).forEach(System.out::println);
	}
}
