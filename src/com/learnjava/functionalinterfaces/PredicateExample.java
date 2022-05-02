package com.learnjava.functionalinterfaces;

import java.util.function.Predicate;

/**
 * @author pramodr
 *
 */
public class PredicateExample {

	// usecase : check whether the given integer is even number.
	static Predicate<Integer> predicate = (value) -> {
		if (value % 2 == 0) {
			return true;
		}
		return false;
	};

	// can also be writen as below.
	static Predicate<Integer> p1 = (value) -> value % 2 == 0;

	// check if the number is divisible by 5 or not.
	static Predicate<Integer> p2 = (value) -> value % 5 == 0;

	// Predicate and operation
	public static void pridicateAnd() {
		System.out.println("Pridicate And result is  : " + p1.and(p2).test(10)); // predicate chaining
		System.out.println("Pridicate And result is  : " + p1.and(p2).test(9)); // predicate chaining
	}

	// predicate Or Operation.
	public static void pridicateOr() {
		System.out.println("Pridicate Or result is  : " + p1.or(p2).test(10)); // predicate chaining
		System.out.println("Pridicate Or result is  : " + p1.or(p2).test(8)); // predicate chaining
	}

	// predicate negate Operation.
	public static void pridicateNegate() {
		System.out.println("Pridicate Negate result is  : " + p1.or(p2).negate().test(8)); // predicate chaining
	}

	public static void main(String[] args) {

		System.out.println("predicate : " + predicate.test(10));

		System.out.println("predicate1 : " + p1.test(10));

		pridicateAnd();

		pridicateOr();

		pridicateNegate();

	}
}
