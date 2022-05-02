package com.learnjava.functionalinterfaces;

import java.util.List;
import java.util.function.Predicate;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class PredicateStudentExamlpe {

	static Predicate<Student> gradeLevelPredicate = (student) -> student.getGradeLevel() >= 3;
	static Predicate<Student> gpaPredicate = (student) -> student.getGpa() >= 3.6;

	public static void filterStudentByGradeLevel() {
		System.out.println("\n filterStudentByGradeLevel : \n");
		List<Student> students = StudentDataBase.getAllStudents();
		// iterate on each and every student
		students.forEach((student) -> {
			if (gradeLevelPredicate.test(student)) {
				System.out.println(student);
			}
		});
	}

	public static void filterStudentByGPA() {
		System.out.println("\n filterStudentByGPA : \n");
		List<Student> students = StudentDataBase.getAllStudents();
		// iterate on each and every student
		students.forEach((student) -> {
			if (gpaPredicate.test(student)) {
				System.out.println(student);
			}
		});
	}

	public static void filterStudents() {
		System.out.println("\n filterStudents : \n");
		List<Student> students = StudentDataBase.getAllStudents();

		students.forEach((student) -> {
			if (gradeLevelPredicate.and(gpaPredicate).test(student)) {
				System.out.println(student);
			}
		});
	}

	public static void main(String[] args) {
		filterStudentByGradeLevel();
		filterStudentByGPA();
		filterStudents();
	}

}
