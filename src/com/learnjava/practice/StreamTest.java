package com.learnjava.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String[] args) {

		Student student1 = new Student("Jayesh", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Student student2 = new Student("Khyati", 20, new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Student student3 = new Student("Jason", 20, new Address("1236"),
				Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

		List<Student> students = Arrays.asList(student1, student2, student3);
		System.out.println("-----------------------------------------------------------");

		// Get student with exact match name "jayesh"
		Predicate<Student> namePredicate = student -> "jayesh".equalsIgnoreCase(student.getName());
		Optional<Student> findFirst = students.stream().filter(namePredicate).findFirst();
		System.out.println(findFirst.isPresent() ? findFirst.get() : "no Student Found");
		System.out.println("-----------------------------------------------------------");

		// Get student with matching address "1235"
		Predicate<Student> addressPredicate = student -> "1235".equals(student.getAddress());
		Optional<Student> addressBasedStudent = students.stream().filter(addressPredicate).findFirst();
		System.out.println(addressBasedStudent.isPresent() ? addressBasedStudent.get() : "no Student Found");
		System.out.println("-----------------------------------------------------------");

		// Get all student having mobile numbers 3333.
		Predicate<Student> mobileNumberPredicate = student -> {
			return student.getMobileNumbers().stream().anyMatch(mobile -> "3333".contains(mobile.getNumber()));
		};

		String mobileNumberStudents = students.stream().filter(mobileNumberPredicate).map(Student::getName)
				.collect(Collectors.joining(",", "[", "]"));
		System.out.println(mobileNumberStudents);
		System.out.println("-----------------------------------------------------------");

		// Get all student having mobile number 1233 and 1234
		Predicate<Student> multipleMobileNumberPredicate = student -> {
			return student.getMobileNumbers().stream()
					.allMatch(mobile -> "1234".contains(mobile.getNumber()) || "1233".contains(mobile.getNumber()));
		};

		String names = students.stream().filter(multipleMobileNumberPredicate).map(Student::getName)
				.collect(Collectors.joining(",", "[", "]"));

		System.out.println(names);
		System.out.println("-----------------------------------------------------------");

		/*****************************************************
		 * Create a List<Student> from the List<TempStudent>
		 *****************************************************/
		TempStudent tmpStud1 = new TempStudent("Jayesh1", 201, new Address("12341"),
				Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

		TempStudent tmpStud2 = new TempStudent("Khyati1", 202, new Address("12351"),
				Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

		List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

		// Create a List<Student> from the List<TempStudent>
		System.out.println("-----------------------------------------------------------");
		List<Student> studentList = tmpStudents.stream().map(tmpStudent -> new Student(tmpStudent.name, tmpStudent.age,
				tmpStudent.address, tmpStudent.mobileNumbers)).collect(Collectors.toList());
		System.out.println(studentList);
		System.out.println("-----------------------------------------------------------");

		// Convert List<Student> to List<String> of student name
		List<String> nameList = students.stream().map(Student::getName).collect(Collectors.toList());
		System.out.println(nameList);
		System.out.println("-----------------------------------------------------------");

		// Convert List<students> to String
		String studentsNames = students.stream()
				.collect(Collectors.mapping(Student::getName, Collectors.joining(",", "[", "]")));
		System.out.println(studentsNames);
		System.out.println("-----------------------------------------------------------");

		// Change the case of List<String>
		List<String> namesList = Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");
		List<String> upperNames = namesList.stream().map(s -> s.toUpperCase()).toList();
		System.out.println(upperNames);
		System.out.println("-----------------------------------------------------------");

		// Sort List<String>
		System.out.println(namesList.stream().sorted().toList());
		System.out.println("-----------------------------------------------------------");

		// Conditionally apply Filter condition, say if flag is enabled then.
		
	}
}