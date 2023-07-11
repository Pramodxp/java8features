package com.learnjava.streams_terminal;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamGroupingByExample {

	public static void groupingByGender() {
		Map<String, List<Student>> groupingByGenderMap = StudentDataBase.getAllStudents().stream() // Stream<Student>
				// depending on the classifier the group by will happen.
				.collect(Collectors.groupingBy(Student::getGender));
		System.out.println(groupingByGenderMap);
	}

	// we can make use of customized classifier for grouping on condition.
	public static void customizedGroupBy() {
		Map<String, List<Student>> customizedGroupBy = StudentDataBase.getAllStudents().stream() // Stream<Student>
				// customizing the group by on conditio and giving string for those perticular
				// group.
				.collect(Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));

		System.out.println(customizedGroupBy);
	}

	public static void twoLevelGrouping_1() {
		Map<Integer, Map<String, List<Student>>> studentMap = StudentDataBase.getAllStudents().stream()
				// groupingBy(1 --> key of map , 2 --> collector || values)
				.collect(Collectors.groupingBy(Student::getGradeLevel,
						Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
		System.out.println(studentMap);
	}

	public static void twoLevelGrouping_2() {
		Map<Integer, Integer> studentMap = StudentDataBase.getAllStudents().stream()
				// groupingBy(1 --> key of map , 2 --> collector || values)
				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.summingInt(Student::getNoteBook)));
		System.out.println(studentMap);
	}

	public static void twoLevelGrouping_3() {
		Map<String, Integer> studentMap = StudentDataBase.getAllStudents().stream()
				// groupingBy(1 --> key of map , 2 --> collector || values)
				.collect(Collectors.groupingBy(Student::getName, Collectors.summingInt(Student::getNoteBook)));
		System.out.println(studentMap);
	}

	public static void threeArgumentGroupBy() {
		LinkedHashMap<String, Set<Student>> studentLinkedHashMap = StudentDataBase.getAllStudents().stream()
				// Collectors.groupingBy(key , result type , output)
				.collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new, Collectors.toSet()));

		System.out.println(studentLinkedHashMap);
	}

	public static void topLevelGpaStudentForEachGrade() {
		Map<Integer, Optional<Student>> maxGpaStudentOptionalMap = StudentDataBase.getAllStudents().stream().collect(
				Collectors.groupingBy(Student::getGradeLevel, Collectors.maxBy(Comparator.comparing(Student::getGpa))));
//		System.out.println(maxGpaStudentOptionalMap);

		// collectingAndThen()

		Map<Integer, Student> maxGpaStudentMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors
						// collectingAndThen
						.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
		System.out.println(maxGpaStudentMap);
	}

	public static void leastLevelGpaStudentForEachGrade() {
		Map<Integer, Optional<Student>> minGpaStudentOptionalMap = StudentDataBase.getAllStudents().stream().collect(
				Collectors.groupingBy(Student::getGradeLevel, Collectors.minBy(Comparator.comparing(Student::getGpa))));
//		System.out.println(minGpaStudentOptionalMap);

		// collectingAndThen()

		Map<Integer, Student> minGpaStudentMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors
						// collectingAndThen
						.collectingAndThen(Collectors.minBy(Comparator.comparing(Student::getGpa)), Optional::get)));
		System.out.println(minGpaStudentMap);
	}

	public static void main(String[] args) {
//		groupingByGender();
//		customizedGroupBy();
//		twoLevelGrouping_1();
//		twoLevelGrouping_2();
//		twoLevelGrouping_3();
//		threeArgumentGroupBy();

//		topLevelGpaStudentForEachGrade();

		leastLevelGpaStudentForEachGrade();

	}
}
