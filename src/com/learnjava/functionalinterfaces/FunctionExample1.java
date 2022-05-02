package com.learnjava.functionalinterfaces;

/**
 * @author pramodr
 *
 */
public class FunctionExample1 {

	//reusablity of the Function.
	public static String performConcat(String string) {
		return FunctionExample.addSomeString.apply(string);
	}

	public static void main(String[] args) {
		String result = performConcat("JioDanDanaDan");
		System.out.println("Result is : " + result);
	}

}
