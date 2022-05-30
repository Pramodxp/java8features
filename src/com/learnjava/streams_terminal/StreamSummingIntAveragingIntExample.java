package com.learnjava.streams_terminal;

import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamSummingIntAveragingIntExample {

	public static int sum() {
		// provide which field need to be mapped in the calss
		return StudentDataBase.getAllStudents().stream().collect(Collectors.summingInt(Student::getNoteBook));
	}

	public static Double average() {
		// provide which field need to be mapped in the calss.
		return StudentDataBase.getAllStudents().stream().collect(Collectors.averagingInt(Student::getNoteBook));
	}

	public static void main(String[] args) {
		System.out.println("sum : " + sum());
		System.out.println("average : " + average());
	}
}
