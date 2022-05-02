package com.learnjava.functionalinterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class BiFunctionExample {

	/*
	 * usecase:
	 * 
	 * 1st parameter we pass studentlist and 2nd parameter we pass predicate
	 * function.
	 * 
	 * output will be map of students and there respective GPA.
	 */

	static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = ((students, predicate) -> {
		Map<String, Double> studentGradeMap = new HashMap<>();
		students.forEach(student -> {
			if (predicate.test(student)) {
				studentGradeMap.put(student.getName(), student.getGpa());
			}
		});
		return studentGradeMap;
	});

	public static void main(String[] args) {
		// we are dynamically passing the predicate function to the existing logic.
		Map<String, Double> result = biFunction.apply(StudentDataBase.getAllStudents(),
				PredicateStudentExamlpe.gradeLevelPredicate);

		System.out.println("The Result is : " + result);
	}
}
