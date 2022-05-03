package com.learnjava.methodreference;

import java.util.List;
import java.util.function.Consumer;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class ConsumerMethodReferenceExample {

	// lambda expression
	static Consumer<Student> studentConsumerLambda = student -> System.out.println(student);

	// methodReference
	// className::methodname
	static Consumer<Student> studentConsumerMethodReference = System.out::println;

	// classname:instanceMethodname
	static Consumer<Student> c2 = Student::printAllActivities;

	public static void main(String[] args) {
		List<Student> students = StudentDataBase.getAllStudents();
		System.out.println("studentConsumerLambda : ");
		students.forEach(studentConsumerLambda);

		System.out.println("\n studentConsumerMethodReference :");
		students.forEach(studentConsumerMethodReference);

		System.out.println("\n c2 print all activities :");
		students.forEach(c2);
	}
}
