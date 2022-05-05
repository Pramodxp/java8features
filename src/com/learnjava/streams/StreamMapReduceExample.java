package com.learnjava.streams;

import java.util.Optional;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class StreamMapReduceExample {

	// total number of note books students has.
	public static Integer getTotalNumberOfNotebooksOfStudents() {
		return StudentDataBase.getAllStudents().stream() // Stream<Student>
				.filter((student) -> student.getGradeLevel() >= 3) // Stream<Student>
				.filter(student -> student.getGender().equals("female")) // Stream<Student>
				.map(Student::getNoteBook) // Stream<Integer>
				// 0 is the initial value.
//				.reduce(0, (b1, b2) -> b1 + b2); // sum of integers

				// insted we can make we can make use of Integer class Methods.
				.reduce(0, Integer::sum);
	}

	// without identity returns optional
	public static Optional<Integer> getTotalNumberOfNotebooksOfStudentsOptional() {
		return StudentDataBase.getAllStudents().stream().map(Student::getNoteBook).reduce((b1, b2) -> b1 + b2);
	}

	public static void main(String[] args) {
		System.out.println("getTotalNumberOfNotebooksOfStudents :" + getTotalNumberOfNotebooksOfStudents());

		Optional<Integer> optional = getTotalNumberOfNotebooksOfStudentsOptional();

		if (optional.isPresent()) {
			System.out.println("getTotalNumberOfNotebooksOfStudentsOptional :"
					+ getTotalNumberOfNotebooksOfStudentsOptional().get());
		}
	}
}
