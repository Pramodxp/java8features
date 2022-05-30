package com.learnjava.streams_terminal;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamMappingExample {
	public static void main(String[] args) {

		// using map collector in the terminal operations itself.

		List<String> nameList = StudentDataBase.getAllStudents() // list<student>
				.stream() // <stream<student>>
				.collect(Collectors.mapping(Student::getName, Collectors.toList()));

		System.out.println("name List : " + nameList);

		Set<String> nameSet = StudentDataBase.getAllStudents() // list<student>
				.stream() // <stream<student>>
				.collect(Collectors.mapping(Student::getName, Collectors.toSet()));

		System.out.println("name Set : " + nameSet);

		List<String> usingMapIntermediateFunction = StudentDataBase.getAllStudents() // list<student>
				.stream() // <stream<student>>
				.map(s -> s.getName()) // avoiding this step in above functions.
				.collect(Collectors.toList());

		System.out.println("using Map Intermediate Function : " + usingMapIntermediateFunction);
	}
}
