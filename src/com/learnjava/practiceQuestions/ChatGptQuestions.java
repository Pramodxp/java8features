package com.learnjava.practiceQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChatGptQuestions {

	public static void main(String[] args) {
//		1.Write a Java 8 stream operation to filter out the even numbers from a list of integers.
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> evenNumbers = numbers.stream().filter(num -> num %2 ==0).collect(Collectors.toList());

//		2.Given a list of strings, write a Java 8 stream operation to transform each string to uppercase and collect them into a new list.
		List<String> strings = Arrays.asList("apple", "banana", "orange");
		List<String> uppercaseValues = strings.stream().map(value -> value.toUpperCase()).collect(Collectors.toList());

//		3.Write a Java 8 stream operation to find the sum of all integers in a list.
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
		int sumIntValue = numbers1.stream().reduce(0, (a,b)->a+b);

//		4.Given a list of names, write a Java 8 stream operation to find the length of the longest name.
		List<String> names = Arrays.asList("John", "Alice", "Michael", "Emily");
		Optional<Integer> longestValue = names.stream().sorted((val1,val2) -> new Integer(val2.length()).compareTo(new Integer(val1.length()))).map(value -> value.length()).findFirst();

//		5.Write a Java 8 stream operation to check if all elements of a list satisfy a given condition (e.g., all numbers are positive).
		List<Integer> numbers11 = Arrays.asList(1, 2, 3, 4, 5);
		boolean allPositive = numbers11.stream()
		                .allMatch(number -> number > 0);



//		6.Given a list of strings, write a Java 8 stream operation to concatenate all the strings into a single comma-separated string.
		strings = Arrays.asList("apple", "banana", "orange");
		strings.stream().collect(Collectors.joining(","));


//		7.Write a Java 8 stream operation to find the average of a list of integers.
		numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream().collect(Collectors.averagingInt(value -> value));

//		8.Given a list of Person objects with name and age attributes, 
//		write a Java 8 stream operation to filter out persons above a certain age threshold and collect their names into a list.
//		List<Person> persons = Arrays.asList(
//		    new Person("John", 25),
//		    new Person("Alice", 30),
//		    new Person("Michael", 40),
//		    new Person("Emily", 20)
//		);

//		int ageThreshold = 30;
//		List<Person> agedPersons = persons.stream().filter(person -> person.getAge() > ageThreshold).collect(Collectors.toList());


//		9.Write a Java 8 stream operation to find the product of all numbers in a list of doubles.
		List<Double> numbersDoubles = Arrays.asList(1.5, 2.0, 3.0, 4.5);

//		10.Given a list of strings, write a Java 8 stream operation to count the number of strings that start with a specific letter.
		strings = Arrays.asList("apple", "banana", "orange", "avocado", "grape");
		char startingLetter = 'a';
		List<String> startedStrings = strings.stream().filter(value -> value.startsWith(""+startingLetter)).collect(Collectors.toList());


//		11.Given a list of Employee objects with attributes such as name, department, 
//		and salary, write a Java 8 stream operation to find the department with the highest total salary.
//		List<Employee> employees = Arrays.asList(
//		    new Employee("John", "Sales", 5000),
//		    new Employee("Alice", "Finance", 6000),
//		    new Employee("Michael", "Sales", 7000),
//		    new Employee("Emily", "Finance", 5500),
//		    new Employee("David", "HR", 4500)
//		);
//
//		String DepartmentWithMaxSalaryCount = employees.stream().collect(Collectors.groupingBy(employee -> employee.getDepartment(), collectors.summingInt(employee.getSalary()))).entrySet().stream().
//		max(Comparator.ComparingInt(Map.Entry::getValue))
//		.map(Map.Entry::getKey).orElse("Unknown");

//		12.Write a Java 8 stream operation to find the most common word in a list of strings.
		List<String> words = Arrays.asList("apple", "banana", "orange", "banana", "apple", "grape", "apple");

		words.stream().collect(Collectors.groupingBy(word -> word, Collectors.counting())).entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey);

//		13.Given a list of transactions with attributes like buyer, seller, and amount, write a Java 8 stream operation to find the total amount spent by each buyer.
//		List<Transaction> transactions = Arrays.asList(
//		    new Transaction("John", "Alice", 500),
//		    new Transaction("John", "Michael", 1000),
//		    new Transaction("Alice", "Emily", 700),
//		    new Transaction("Michael", "Alice", 800),
//		    new Transaction("John", "Emily", 300)
//		);
//
//		Map<String, Integer> buyersTotalAmount = transactions.stream().collect(Collectors.groupingBy(trans -> trans.getBuyer(), Collectors.summingInt(trans -> trans.getAmount())));
//		Map<String, Integer> sellerTotalAmount = transactions.stream().collect(Collectors.groupingBy(trans -> trans.getSeller(), Collectors.summingInt(trans -> trans.getAmount())));
//
//		buyersTotalAmount.stream().map(trans -> buyersTotalAmount.put(trans.getBuyer(),sellerTotalAmount.get(trans.getBuyer()).getAmount() - trans.getAmount())).collect(collectors.toMap());

//		14.Write a Java 8 stream operation to find the average length of words in a list of strings.
		words = Arrays.asList("apple", "banana", "orange", "grapefruit", "kiwi");

		words.stream().map(str -> str.length()).collect(Collectors.averagingInt(number -> number));

//		15.Given a list of numbers, write a Java 8 stream operation to find the second smallest number.
		numbers = Arrays.asList(5, 2, 8, 1, 9, 3, 6, 4, 7);
		numbers.stream().distinct().sorted((val1, val2)-> val1.compareTo(val2)).skip(1).findFirst();

//		16.Write a Java 8 stream operation to find the cumulative sum of a list of integers.
		numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream().collect(Collectors.summingInt(val -> val));


//		17.Given a list of strings, write a Java 8 stream operation to find the frequency count of each unique word.
		words = Arrays.asList("apple", "banana", "orange", "banana", "apple", "grape", "apple");
		words.stream().collect(Collectors.groupingBy(strs -> strs, Collectors.counting()));

//		18.Write a Java 8 stream operation to filter out duplicate elements from a list.
		numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6, 7, 1);
		numbers.stream().distinct().collect(Collectors.toCollection(ArrayList<Integer>::new));

//		19.Given a list of names, write a Java 8 stream operation to sort the names in descending order of their lengths and collect them into a new list.
		names = Arrays.asList("John", "Alice", "Michael", "Emily", "Tom");
//		names.stream().sorted((name1,name2) -> Integer.parseInt(name2.size()).compareTo(Integer.parseInt(name1.size()))).collect(Collectors::toList);

//		20.Given a list of strings, write a Java 8 stream operation to find the longest string.
		strings = Arrays.asList("apple", "banana", "orange", "grapefruit", "kiwi");
//		strings.max(Comparator.comparingInt(value -> value.getInt()));


//		21.Write a Java 8 stream operation to convert a list of strings into a single comma-separated string enclosed in square brackets.
		strings = Arrays.asList("apple", "banana", "orange");
		strings.stream().collect(Collectors.joining(","));

//		22.Given a list of numbers, write a Java 8 stream operation to calculate the factorial of each number and store the results in a map.
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//		numbers.stream().collect(collectors.toMap(number -> number, Class::calculateFactorial));

//		23.Write a Java 8 stream operation to find the average age of people from a list of Person objects.
//		List<Person> persons = Arrays.asList(
//		        new Person("John", 25),
//		        new Person("Alice", 30),
//		        new Person("Michael", 40),
//		        new Person("Emily", 20)
//		);
//
//		Integer averageAgeOfPersons = persons.stream().collect(Collectors.averagingInt(Person::getAge));

//		24.Given a list of strings, write a Java 8 stream operation to check if all strings contain only lowercase letters.
		strings = Arrays.asList("apple", "Banana", "orange", "grape");

//		boolean isAllLowerCase = strings.stream().allMatch(value.equals(value.toLowerCase()));

//		25.Given a list of strings, write a Java 8 stream operation to find the count of distinct vowels (a, e, i, o, u) across all the strings.
		strings = Arrays.asList("apple", "banana", "orange", "grapefruit", "kiwi");

//		List<String> vowels = Arrays.asList(a,e,i,o,u);
//		long countofdistinct = strings.stream().flatMap(strss -> strss.split("")).distinct().filter(val -> vowels.contains(val)).distinct().count();


	}
	
	public long calculateFactorial(int number){
	 	long factorial = 1;
	        for (int i = 1; i <= number; i++) {
	            factorial *= i;
	        }
	        return factorial;
	}
}
