package com.learnjava.functionalinterfaces;

import java.util.List;
import java.util.function.Consumer;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class ConsumerExample {

	// implementing the consumer interface to print the student data.
	static Consumer<Student> consumer1 = (student) -> System.out.println(student);
	static Consumer<Student> consumer2 = (student) -> System.out.print(student.getName());
	static Consumer<Student> consumer3 = (student) -> System.out.println(student.getActivities());

	/*
	 * use case: i want to iterate and print all the students which are patr of this
	 * list.
	 */
	static void printName() {
		List<Student> allStudents = StudentDataBase.getAllStudents();

		/*
		 * enahancement made to the collections Interface Iterable , in 1.8 the method
		 * added, accepts Consumer.
		 */
		allStudents.forEach(consumer1);
	}

	/*
	 * we are printing the name and list of activities
	 */
	static void printNameAndActivities() {

		System.out.println("\n printNameAndActivities : \n");
		List<Student> allStudents = StudentDataBase.getAllStudents();

		/*
		 * we are performing the consumer chaining here. meaning we are providing
		 * multiple consumer implementation. all those consumer implementations are
		 * executed sequentually.
		 */
		allStudents.forEach(consumer2.andThen(consumer3));
	}

	/*
	 * we are printing the name and list of activities
	 */
	static void printNameAndActivitiesCondition() {
		System.out.println("\n printNameAndActivitiesCondition : \n");

		List<Student> allStudents = StudentDataBase.getAllStudents();

		/*
		 * we are performing the consumer chaining here. meaning we are providing
		 * multiple consumer implementation. all those consumer implementations are
		 * executed sequentually.
		 */
		allStudents.forEach((student) -> {
			if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.9) {
				consumer2.andThen(consumer3).accept(student); //we can chain n number of consumers.
			}
		});
	}

	public static void main(String[] args) {

		// -- definfig the functionality
		// accepts the input as string and convert it to uppercase , and print it to the
		// console.
		Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());

		// providing the date to perform the operation
		// how to pass an input to this functional interface.
		// using the accept method we are going to pass the input firse
		c1.accept("java8");

		// performed the operation what ever we instructed the consumer interface to do.

		// calling the printname method.
//		System.out.println("printName: ");
//		printName();

		// calling the printNameAndActivities method
		printNameAndActivities();
		
		// calling 
		printNameAndActivitiesCondition();
	}

}
