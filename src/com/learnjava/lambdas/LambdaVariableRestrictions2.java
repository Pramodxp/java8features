package com.learnjava.lambdas;

import java.util.function.Consumer;

/**
 * @author pramodr
 *
 */
public class LambdaVariableRestrictions2 {

	// inside lambdas we can make use of instance variables and also modify or
	// reassign with new value.
	static int instanceVariable = 10; // instance variable

	public static void main(String[] args) {
		int methodLocalVariable = 4; // local variable.
		Consumer<Integer> c1 = (i) -> {
			// we are not allowed to make the changes to the variable declared out side the
			// scope of lambda.
			// inside lambda the variable declared out side the lambda scope must be
			// effectively considered as final.
//			methodLocalVariable++;

			// changing is allowed.
			instanceVariable++;

			// we can make use of the variable in method scope.
			System.out.println(methodLocalVariable + i);

			// we can print instance variable inside the lambda.
			System.out.println(instanceVariable);
		};

		// we cannot modify the variable inside the method scope hence it is used in
		// side the lambda scope for some operation.
		// uncomment the below line we can see error in side the lambda expression.
//		methodLocalVariable++;

		// we can modify instance variable here
		instanceVariable++;

		c1.accept(10);
	}
}
