package com.learnjava.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class SupplierExample {
	public static void main(String[] args) {
		// supplier dosent take any input but supplies output.
		// supplier is opposite to the consumer functional interface.
		Supplier<Student> studentSupplier = () -> new Student("Adam", 2, 3.6, "male",
				Arrays.asList("swimming", "basketball", "volleyball"));

		System.out.println("studentSupplier : " + studentSupplier.get());

		//
		Supplier<List<Student>> studentListSupplier = () -> StudentDataBase.getAllStudents();

		System.out.println("studentListSupplier : " + studentListSupplier.get());
	}
}
