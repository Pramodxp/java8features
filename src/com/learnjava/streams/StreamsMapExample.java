package com.learnjava.streams;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamsMapExample {

	/*
	 * usecase:
	 * 
	 * collect all the students in the list and print the list.
	 */
	public static List<String> getStudentNamesList() {
		return StudentDataBase.getAllStudents().stream() // will return Stream<Student>
				.map(new Function<Student, String>() {

					@Override
					public String apply(Student t) {
						// TODO Auto-DD method stub
						return t.getName();
					}

				}) // get name from the student and returns stream<string>
				.map(String::toUpperCase) // returns Stream<String> --> which is converted toupper case.
				.collect(Collectors.toList()); // returns the list<string>
	}

	public static Set<String> getStudentNamesSet() {
		return StudentDataBase.getAllStudents().stream() // will return Stream<Student>
				.map(new Function<Student, String>() {

					@Override
					public String apply(Student t) {
						// TODO Auto-DD method stub
						return t.getName();
					}

				}) // get name from the student and returns stream<string>
				.map(String::toUpperCase) // returns Stream<String> --> which is converted toupper case.
				.collect(Collectors.toSet()); // returns the list<string>
	}

	public static void main(String[] args) {
		System.out.println(getStudentNamesList());
		System.out.println(getStudentNamesSet());
	}
}
