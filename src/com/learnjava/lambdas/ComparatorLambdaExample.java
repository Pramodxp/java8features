package com.learnjava.lambdas;

import java.util.Comparator;

/**
 * @author pramodr
 *
 */
public class ComparatorLambdaExample {
	public static void main(String[] args) {

		/*
		 * prior java 8
		 */
		Comparator<Integer> comparator = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};

		System.out.println("Result of the comparator is : " + comparator.compare(10, 20));

		Comparator<Integer> comparatorLambda = (Integer a,Integer b) -> {return a.compareTo(b);};

		System.out.println("Result of the comparator Lambda is : " + comparatorLambda.compare(10, 20));

//		if there is single statement we dont need to specify return statement.
//		no need to specify the parameter type as well, because we already mentioned in genric.
		Comparator<Integer> comparatorLambda1 = (a, b) -> a.compareTo(b);

		System.out.println("Result of the comparator Lambda 1 is : " + comparatorLambda1.compare(10, 20));
	}

}
