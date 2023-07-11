package com.learnjava.practice;

public interface I1 {
	default void display() {
		System.out.println("display from I1");
	}
	
	
	
	void d1();
}
