package com.learnjava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamReduceExample {
	public static int getMultiplicationOfIntegers(List<Integer> integers) {
		return integers.stream() // Stream<Integer> 1 3 5 7
				// i is the initial value for operation
				// iterations
				// a=1,b=1 result = 1
				// a=1,b=3 result = 3
				// a=3,b=5 result = 15
				// a=15,b=7 result = 105
				.reduce(1, (a, b) -> a * b);
	}

	public static Optional<Integer> getMultiplicationOfIntegersWithOutIdentity(List<Integer> integers) {
		return integers.stream() // Stream<Integer> 1 3 5 7
				// i is the initial value for operation
				// iterations
				// a=1,b=1 result = 1
				// a=1,b=3 result = 3
				// a=3,b=5 result = 15
				// a=15,b=7 result = 105
				.reduce((a, b) -> a * b);
	}

	public static Optional<Student> getHighestGpaStudent() {
		return StudentDataBase.getAllStudents().stream().
				//students one by one
				//returned data will be maintained till the end for comparison.
				reduce((s1, s2) -> {
			if (s1.getGpa() > s2.getGpa()) {
				return s1;
			} else {
				return s2;
			}
		});
	}

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 3, 5, 7);
		System.out.println("getMultiplicationOfIntegers : " + getMultiplicationOfIntegers(integers));

		Optional<Integer> optional = getMultiplicationOfIntegersWithOutIdentity(integers);
		if (optional.isPresent()) { // Mandatory to check isPresent , if data is not returned we will face
									// exception during .get operation.
			System.out.println("getMultiplicationOfIntegersWithOutIdentity : " + optional.get());
		}

		Optional<Student> highestGpaStudent = getHighestGpaStudent();

		if (highestGpaStudent.isPresent()) {
			System.out.println(highestGpaStudent.get());
		}
	}
}
