package com.learnjava.methodreference;

import java.util.function.Function;

/**
 * @author pramodr
 *
 */
public class FunctionMethodReferenceExample {
	static Function<String, String> toUpperCaseLambda = (s) -> s.toUpperCase();

	static Function<String, String> toUpperCaseMethodReference = String::toUpperCase;

	public static void main(String[] args) {
		System.out.println("toUpperCaseLambda : " + toUpperCaseLambda.apply("java8"));
		System.out.println("toUpperCaseMethodReference : " + toUpperCaseMethodReference.apply("java8"));
	}
}
