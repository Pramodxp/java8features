package com.learnjava.streams_terminal;

import static java.util.stream.Collectors.joining;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamsJoiningExample {

	public static String joining_1() {
		return StudentDataBase.getAllStudents().stream() // stream<student>
				.map(Student::getName)// <stream<string>>
				.collect(joining());
	}

	public static String joining_2() {
		return StudentDataBase.getAllStudents().stream() // stream<student>
				.map(Student::getName)// <stream<string>>
				.collect(joining("-"));
	}

	public static String joining_3() {
		return StudentDataBase.getAllStudents().stream() // stream<student>
				.map(Student::getName)// <stream<string>>
				.collect(joining("-", "(", ")"));
	}

	public static void main(String[] args) {
		System.out.println("joining_1 : " + joining_1());
		System.out.println("joining_2 : " + joining_2());
		System.out.println("joining_3 : " + joining_3());
	}
}
