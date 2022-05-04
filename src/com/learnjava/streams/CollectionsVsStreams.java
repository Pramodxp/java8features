package com.learnjava.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author pramodr
 *
 */
public class CollectionsVsStreams {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
//		can add and modify collection
		names.add("jack");
		names.add("john");
		names.add("lisha");

//		cant modify streams once it is created.
//		names.stream().add

//		elements in collection can be accessed in any order.
		names.get(2);

//		elements in streams can only be accessed sequence.

//		collection can be traversed n number of times.
		for (String name : names) {
			System.out.println(name);
		}

		for (String name : names) {
			System.out.println(name);
		}

//		streams can be traversed only once
		Stream<String> stream = names.stream();

		stream.forEach(System.out::println);

		// we will get an exception if we try to traverse the stream again.
		stream.forEach(System.out::println);
	}
}
