package com.learnjava.functionalinterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class FunctionStudentExample {

	Function<List<Student>, Map<String, Double>> studentFunction = (students -> {
		Map<String, Double> studentGradeMap = new HashMap<>();
		// we are going to iterate over eacha and every student.
		students.forEach(student -> {
			// filter the student who has grade greater than 3, making use of predicate
			// defined before.
			if (PredicateStudentExamlpe.gpaPredicate.test(student)) {
				studentGradeMap.put(student.getName(), student.getGpa());
			}
		});
		return studentGradeMap;
	});

	public static void main(String[] args) {
		System.out.println(new FunctionStudentExample().studentFunction.apply(StudentDataBase.getAllStudents()));
	}
}
