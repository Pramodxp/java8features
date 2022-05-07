package com.learnjava.streams;

import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamsMatchExample {

	// any of the element in stream match the predicate returns true
	public static boolean anyMatch() {
		return StudentDataBase.getAllStudents().stream().anyMatch((student) -> student.getGpa() >= 3.9);
	}

	// all data in stream should match in the predicate to return true.
	public static boolean allMatch() {
		return StudentDataBase.getAllStudents().stream().anyMatch((student) -> student.getGpa() >= 3.9);
	}

	// all data should not match the predicate to return true.
	public static boolean noneMatch() {
		return StudentDataBase.getAllStudents().stream().noneMatch((student) -> student.getGpa() >= 3.9);
	}

	public static void main(String[] args) {
		System.out.println("result of any match is : " + anyMatch());
		System.out.println("result of all match is : " + allMatch());
		System.out.println("result of none match is : " + noneMatch());
	}
}
