package com.learnjava.streams;

import java.util.List;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamFlatMapExample {

	public static List<String> getStudentActivities() {
		return StudentDataBase.getAllStudents().stream() // stream<student>
				.map(Student::getActivities) // stream<List<String>
				.flatMap(List::stream) // stream<string>
				.distinct() // stream<String>
				.sorted()  //stream<String> -> sorted elements.
				.collect(Collectors.toList());
	}

	public static long getStudentActivitiesCount() {
		return StudentDataBase.getAllStudents().stream() // stream<student>
				.map(Student::getActivities) // stream<List<String>
				.flatMap(List::stream) // stream<string>
				.distinct() // stream<String> ->with distinct elements
				.count();
	}

	public static void main(String[] args) {
		System.out.println("getStudentActivities : " + getStudentActivities());
		System.out.println("getStudentActivitiesCount : " + getStudentActivitiesCount());
	}
}
