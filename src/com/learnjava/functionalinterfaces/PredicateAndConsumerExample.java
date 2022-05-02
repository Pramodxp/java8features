package com.learnjava.functionalinterfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class PredicateAndConsumerExample {

	Predicate<Student> p1 = (student) -> student.getGradeLevel() >= 3;
	Predicate<Student> p2 = (student) -> student.getGpa() >= 3.9;

	// we can use bipredicate insted, which accepts 2 inputs.
	BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel >= 3 && gpa >= 3.9;

	// to print the name and activities
	BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out
			.println("name : " + name + " activities : " + activities);

	// accepts student and performs filtering operation.
	Consumer<Student> studentConsumer = (student) -> {
		if (biPredicate.test(student.getGradeLevel(), student.getGpa())) {
			studentBiConsumer.accept(student.getName(), student.getActivities());
		}
	};

	// instance method
	public void printNameAndActivities(List<Student> students) {
		students.forEach(studentConsumer);
	}

	public static void main(String[] args) {
		List<Student> students = StudentDataBase.getAllStudents();
		new PredicateAndConsumerExample().printNameAndActivities(students);
	}
}
