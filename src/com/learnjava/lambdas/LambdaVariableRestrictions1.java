package com.learnjava.lambdas;

import java.util.function.Consumer;

/**
 * @author pramodr
 *
 */
public class LambdaVariableRestrictions1 {
	public static void main(String[] args) {
		// not allowed to use variable name already used in the method scope
		int i = 0;

		Consumer<Integer> c1 = (i1) -> {
			//we cant redeclare the variable already in the scope.
//			int i = 2;
			System.out.println("value is : " + i);
		};
	}
}
