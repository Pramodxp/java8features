package com.learnjava.streams_terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamsPartitioningByExample {

	// Collectors.partitioningBy(predicate)
	public static void partitioningBy_1() {
		Predicate<Student> studentPredicate = student -> student.getGpa() >= 3.8;
		Map<Boolean, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.partitioningBy(studentPredicate));

		System.out.println(studentMap);
	}

	// Collectors.partitioningBy(predicate,collector)
	public static void partitioningBy_2() {
		Predicate<Student> studentPredicate = student -> student.getGpa() >= 3.8;
		Map<Boolean, Set<Student>> studentMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.partitioningBy(studentPredicate, Collectors.toSet()));

		System.out.println(studentMap);
	}

	public static void main(String[] args) {
//		partitioningBy_1();
		partitioningBy_2();
	}
}
