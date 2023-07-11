package com.learnjava.practice;

public interface I2 {
	default void display() {
		System.out.println("display method from I2");
	}
	void d1();
}
