package com.learnjava.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamsComparatorExample {

	public static List<Student> sortStudentByName() {
		return StudentDataBase.getAllStudents() // list<student>
				.stream() // Stream<student>
				.sorted(Comparator.comparing(Student::getName)) // Stream<student> //sorted students by name.
				.collect(Collectors.toList()); // list<student>
	}

	public static List<Student> sortStudentByGPA() {
		return StudentDataBase.getAllStudents() // list<student>
				.stream() // Stream<student>
				.sorted(Comparator.comparing(t -> t.getGpa())) // Stream<student> //sorted students by GPA.
				.collect(Collectors.toList()); // list<student>
	}
	
	public static List<Student> sortStudentByGPADescending() {
		return StudentDataBase.getAllStudents() // list<student>
				.stream() // Stream<student>
				.sorted(Comparator.comparing(Student::getGpa).reversed()) // Stream<student> //sorted students by GPA Desc.
				.collect(Collectors.toList()); // list<student>
	}

	public static void main(String[] args) {
		System.out.println("Students sorted By name :");
		sortStudentByName().forEach(System.out::println);

		System.out.println("\n Students sorted By GPA :");
		sortStudentByGPA().forEach(System.out::println);
		
		System.out.println("\n Students sorted By GPA Descending:");
		sortStudentByGPADescending().forEach(System.out::println);
	}
}
