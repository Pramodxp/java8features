package com.learnjava.functionalinterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

	static Comparator<Integer> comparator = (a, b) -> a.compareTo(b);

	public static void main(String[] args) {

		// extends BIfunction Interface when we have input and out put as same type we
		// make use of BinaryOperator over BiFunction.
		BinaryOperator<Integer> binaryOperator = (a, b) -> a * b;

		System.out.println("Multiplication of numbers : " + binaryOperator.apply(10, 20));

		// using static methods of BinaryOperator class.
		BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
		BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);

		System.out.println("minBy value is :" + minBy.apply(10, 20));
		System.out.println("maxBy value is :" + maxBy.apply(10, 20));

	}
}
