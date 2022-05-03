package com.learnjava.functionalinterfaces;

import java.util.function.UnaryOperator;

/**
 * @author pramodr
 *
 */
public class UnaryOperatorExample {

	// when we want to write a function but its input and output are of same type we
	// can make use of UnaryOperator interface.
	static UnaryOperator<String> unaryOperator = (s) -> s.concat("default");

	public static void main(String[] args) {
		System.out.println(unaryOperator.apply("pramod"));
	}
}
