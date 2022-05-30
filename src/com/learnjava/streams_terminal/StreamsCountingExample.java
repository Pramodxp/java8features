package com.learnjava.streams_terminal;

import java.util.stream.Collectors;

import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamsCountingExample {
	public static void main(String[] args) {
		System.out.println(StudentDataBase.getAllStudents().stream().collect(Collectors.counting()));
	}
}
