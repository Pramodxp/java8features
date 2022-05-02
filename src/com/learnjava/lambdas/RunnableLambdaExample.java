package com.learnjava.lambdas;

/**
 * @author pramod
 *
 */
public class RunnableLambdaExample {

	public static void main(String[] args) {
		/*
		 * prior java 8
		 */

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("inside Runnable Interface 1");
			}
		};
		new Thread(runnable).start();

		// java 8.
		Runnable runnableLambda = () -> System.out.println("inside Runnable Interface 2");
		new Thread(runnableLambda).start();

		new Thread(() -> System.out.println("inside Runnable Interface 3")).start();

	}
}
