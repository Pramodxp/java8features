package com.learnjava.methodreference;

import java.util.function.Function;
import java.util.function.Supplier;

import com.learnjava.data.Student;

/**
 * @author pramodr
 *
 */
public class ConstructorReferenceExample {

	// the student class should contain no argument constructor.
	static Supplier<Student> studentSupplier = Student::new;

	static Function<String, Student> functionStudent = Student::new;

	public static void main(String[] args) {
		System.out.println("studentSupplier : " + studentSupplier.get());
		System.out.println("functionStudent : " + functionStudent.apply("pramod"));
	}
}
