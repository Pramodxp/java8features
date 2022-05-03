package com.learnjava.methodreference;

import java.util.function.Predicate;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

/**
 * @author pramodr
 *
 */
public class RefactorMethodReferenceExample {

	// in case if we want to make use of Method reference.then we need to move this
	// logic to seperate method.[note : not mandetory].
	static Predicate<Student> predicate1 = student -> student.getGradeLevel() >= 3;

	static Predicate<Student> predicate2MrthodReference = RefactorMethodReferenceExample::checkGradeLevel;

	// moved the logic to this method make it accessible by method reference.
	public static boolean checkGradeLevel(Student student) {
		return student.getGradeLevel() >= 3;
	}

	public static void main(String[] args) {
		System.out.println("\n predicate1 : " + predicate1.test(StudentDataBase.studentSupplier.get()));

		System.out.println("\n predicate2MrthodReference :"
				+ predicate2MrthodReference.test(StudentDataBase.studentSupplier.get()));
	}
}
