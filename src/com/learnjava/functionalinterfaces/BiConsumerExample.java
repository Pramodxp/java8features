package com.learnjava.functionalinterfaces;

import java.util.List;
import java.util.function.BiConsumer;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class BiConsumerExample {

	static void printNameAndActivities() {
		System.out.println("**************************************************************");
		System.out.println("Inside printNameAndActivities :");
		System.out.println("**************************************************************");

		BiConsumer<String, List<String>> biConsumer = (name, activities) -> {
			System.out.println(name + " " + activities);
		};

		List<Student> students = StudentDataBase.getAllStudents();
		
		// in here we are defining one more inline consumer which performs the operation
		// of the biConsumer defination already defined.
		students.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));

	}

	public static void main(String[] args) {

		BiConsumer<String, String> biConsumer = (a, b) -> {
			System.out.println("a : " + a + " b : " + b);
		};

		biConsumer.accept("java7", "java8");

		// BODMAS
		BiConsumer<Integer, Integer> addition = (a, b) -> {
			System.out.println("addition is : " + a + b);
		};

		BiConsumer<Integer, Integer> multiply = (a, b) -> {
			System.out.println("multiply is : " + a * b);
		};

		BiConsumer<Integer, Integer> division = (a, b) -> {
			System.out.println("division is : " + a / b);
		};

		BiConsumer<Integer, Integer> substraction = (a, b) -> {
			System.out.println("substraction is : " + (a - b));
		};

		// constructor chaining.
		addition.andThen(substraction).andThen(multiply).andThen(division).accept(10, 20);

		printNameAndActivities();
	}
}
