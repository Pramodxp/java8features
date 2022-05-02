package com.learnjava.functionalinterfaces;

import java.util.function.Function;

/**
 * @author pramodr
 *
 */
public class FunctionExample {

	/*
	 * if you want the return value from the following lambda expression we can make
	 * use of <Type>Function for representing/referencing the lambda expression.
	 */
	static Function<String, String> function = (name) -> name.toUpperCase();
	static Function<String, String> addSomeString = (name) -> name.concat("default");

	public static void main(String[] args) {
		System.out.println("Result is : " + function.apply("Pramod"));
		
		//Function Chainning.
		

		/*
		 * 1 - making use of andThen Method of Function Interface. performs function.
		 * 
		 * 2 - operations and then the result of function will be passed as input to the
		 * addSomeStringFunction and performed operation.
		 * 
		 * 3 - outer function(which uses the above as parameter) first.
		 * 
		 * 4 - 	inner function(parameter) next.
		 */
		System.out.println("Result of andThen is : " + function.andThen(addSomeString).apply("Pramod"));

		/*
		 * 1 - making use of compose Method of Function Interface. performs function.
		 * 
		 * 2 - it is reverse of andThen first the function at last will be performed and
		 * result of that will be passed to the previous function and so on.
		 * 
		 * 3 - inner function(parameter) first.
		 * 
		 * 4 - outer function(which uses the above as parameter) next.
		 * 
		 */
		System.out.println("Result of compose is : " + function.compose(addSomeString).apply("Pramod"));
	}
}
