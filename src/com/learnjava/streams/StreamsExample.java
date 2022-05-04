package com.learnjava.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamsExample {
	public static void main(String[] args) {
		// student name and activities in a map.
		/*
		 * conditions -
		 * 
		 * want students whose grade level is greater than or equal 3.
		 * 
		 * gpa is greater tahn or equal to 3.9.
		 */

		Predicate<Student> studentGradeLevelPredicate = (student) -> student.getGradeLevel() >= 3;
		Predicate<Student> studentGPAPredicate = (student) -> student.getGpa() >= 3.9;

		// stream is passing the elements one by one from top to the bottom.
		// if we want to debug through the streams, we can make use of peek method which
		// accepts consumer and returns the stream.
		Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
				.peek((student) -> System.out.println("Initial Stream Data : " + student))
				// we can make use of method reference directly.
//				.collect(Collectors.toMap((student) -> student.getName(), (student) -> student.getActivities()));
				.filter(studentGradeLevelPredicate) // return stream<student>
				.peek((student) -> System.out.println("After 1st filter : " + student))
				.filter(studentGPAPredicate) // return stream<student>
				.peek((student) -> System.out.println("After 2nd filter : " + student))
				.collect(Collectors.toMap(Student::getName, Student::getActivities)); // returns the desired result
																						// <Map>

		System.out.println("\n Map datas : " + studentMap);

	}
}
