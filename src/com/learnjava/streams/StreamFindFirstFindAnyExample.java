package com.learnjava.streams;

import java.util.Optional;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamFindFirstFindAnyExample {

	// findFirst and findAny returns the element itself.
	// we can see the difference of both in parallel processing.

	// returns the first occurrence of the list.
	public static Optional<Student> findFirst() {
		return StudentDataBase.getAllStudents().stream().filter((s) -> s.getGpa() > 3.9).findFirst();
	}

	// returns the any occurrence of the list.
	public static Optional<Student> findAny() {
		return StudentDataBase.getAllStudents().stream().filter((s) -> s.getGpa() > 3.9).findAny();
	}

	public static void main(String[] args) {
		// findfirst
		Optional<Student> findFirst = findFirst();

		if (findFirst.isPresent()) {
			System.out.println("find first element is : " + findFirst.get());
		} else {
			System.out.println("no result found !");

		}

		// findany
		Optional<Student> findAny = findAny();

		if (findFirst.isPresent()) {
			System.out.println("find any element is : " + findAny.get());
		} else {
			System.out.println("no result found !");

		}
	}
}
