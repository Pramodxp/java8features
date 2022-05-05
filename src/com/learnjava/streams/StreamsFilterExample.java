package com.learnjava.streams;

import java.util.List;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamsFilterExample {

	public static void filterStudents() {
		 StudentDataBase.getAllStudents().stream()
				.peek(student -> System.out.println("stream data : \n " + student.getName()))
				.filter(student -> student.getGender().equals("female")) // filters out the data which are only female.
				.peek(student -> System.out.println("filtered stream data : \n " + student.getName()))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		filterStudents();//.forEach(System.out::println);
	}
}
