package com.learnjava.practiceQuestions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomQuestions {
	public static void main(String[] args) {
//		Q1 Given a list of integers, find out all the even numbers exist in the list using Stream functions?
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		System.out.println("even numbers in the list are: ");
		myList.stream().filter(num -> num % 2 == 0).forEach(System.out::println);

		List<BigDecimal> values = new ArrayList<>();
		values.add(new BigDecimal(10));
		values.add(new BigDecimal(20));
		values.add(new BigDecimal(30));
		values.add(new BigDecimal(40));

		BigDecimal reduce = values.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

//		Given a list of integers, find out all the numbers starting with 1 using Stream functions?
		System.out.println("integers starting with 1 are : ");
		myList.stream().map(num -> num + "").filter(num -> num.startsWith("1")).forEach(System.out::println);

//How to find duplicate elements in a given integers list in java using Stream functions?
		Set<Integer> set = new HashSet<>();
		System.out.println("duplicate elements are :");
		myList.stream().filter(num -> !set.add(num)).forEach(System.out::println);

//		Given a list of integers, find the total number of elements present in the list using Stream functions?
		System.out.println("number of elements in an array is :" + myList.stream().count());

//		 Given a list of integers, find the maximum value element present in it using Stream functions?
		Optional<Integer> max = myList.stream().max((num1, num2) -> num1.compareTo(num2));
		System.out.println("maximum value in an array is : " + max.get());

//		Given a String, find the first non-repeated character in it using Stream functions?
		String input = "Java Hungry Blog Alive is Awesome";

		input.chars().mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))// converting the character to
																						// object and then to lowercase.
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))// store
																												// the
																												// chars
																												// in
																												// map
																												// with
																												// count
				.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst()
				.get();

//		Given a list of integers, find the maximum value element present in it using Stream functions?

		// iterator
//		Iterator<Integer> iterator = myList.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//			
//		}
//		
//		ListIterator<Integer> lis = myList.listIterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
//		lis.set(new Integer("40"));
//		
//		System.out.println(myList);

		// Counting Empty String
		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
		System.out
				.println("Counting Empty String in an array is : " + strList.stream().filter(x -> x.isEmpty()).count());

		// Count String whose length is more than three
		System.out.println("Count String whose length is more than three : "
				+ strList.stream().filter(x -> (x.length() > 3)).count());

		// Count number of String which starts with "a"
		System.out.println("Count number of String which starts with a "
				+ strList.stream().filter(x -> x.startsWith("a")).count());

		// Remove all empty Strings from List
		System.out.println("Remove all empty Strings from List : "
				+ strList.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList()));

		// Create a List with String more than 2
		System.out.println("Create a List with String more than 2 : "
				+ strList.stream().filter(x -> (x.length() > 2 * 2)).collect(Collectors.toList()));

		// Convert String to uppercase and Join them with coma
		System.out.println("Convert String to uppercase and Join them with coma : "
				+ strList.stream().map(String::toUpperCase).collect(Collectors.joining(", ")));

		// Create a List of the square of all distinct numbers
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		System.out.println("Create a List of the square of all distinct numbers : "
				+ numbers.stream().distinct().map(num -> num * 2).collect(Collectors.toList()));

		// sort numbers in the reverse order
		List<Integer> sortedNumbers = numbers.stream().sorted((num1, num2) -> num2.compareTo(num1))
				.collect(Collectors.toList());
		System.out.println("Sorted numbers are : " + sortedNumbers);

		// get the names starts with s
		List<String> names = Arrays.asList("pramod", "sujay", "shashank");
		List<String> namesWithS = names.stream().filter(name -> name.startsWith("s")).collect(Collectors.toList());
		System.out.println("Names starts with s are : " + namesWithS);

		// count of strings in the given string
		String str = "This this is is done by Saket Saket";

		// {Saket=2, by=1, this=1, This=1, is=2, done=1}

		String[] strs = str.split(" ");

		Map<String, Long> mapOfCount = Arrays.asList(strs).stream()
				.collect(Collectors.groupingBy(val -> val, Collectors.counting()));
		System.out.println("count of strings in the given string : " + mapOfCount);

		// filter the list divisible by 3
		List<Integer> nums = Arrays.asList(3, 7, 15, 16);

		Optional<Integer> maxOfValue = nums.stream().filter(num -> (num % 3 == 0))
				.max((num1, num2) -> num1.compareTo(num2));

		// Can an array be converted to a stream? How?
		Integer[] valuesOfInteger = { 10, 20, 30, 40 };
		Stream<Integer> of = Stream.of(valuesOfInteger);
		System.out.println("printing integer values which are converted to stream");
		of.forEach(System.out::println);

		// 14.Write a Java 8 stream operation to find the average length of words in a
		// list of strings.
		List<String> words = Arrays.asList("Hello", "world", "Java", "stream", "operation");

		System.out.println("averaging strring is : "
				+ words.stream().map(str1 -> str1.length()).collect(Collectors.averagingInt(value -> value)));

		double averageLength = words.stream().flatMap(word -> Arrays.stream(word.split(""))).mapToInt(String::length)
				.average().orElse(0);

		System.out.println("gpt code : " + averageLength);

		for (String a : "Hello".split("")) {
			System.out.println(a);
		}

		// 15.Given a list of numbers, write a Java 8 stream operation to find the
		// second smallest number.
		List<Integer> numbers1 = Arrays.asList(5, 2, 8, 1, 9, 3, 6, 4, 7);
		Optional<Integer> findFirst = numbers1.stream().distinct().sorted((val1, val2) -> val1.compareTo(val2)).skip(1)
				.findFirst();

		System.out.println("Second largest element in the list is : "+findFirst.get());
		
		//16.Write a Java 8 stream operation to find the cumulative sum of a list of integers.
		Integer valueInt = numbers1.stream().collect(Collectors.summingInt(val -> val));
		System.out.println("cumulative sum of a list of integers :"+valueInt);
		
		//20.Given a list of strings, write a Java 8 stream operation to find the longest string.
		List<String> strings = Arrays.asList("apple", "banana", "orange", "grapefruit", "kiwi");
//		strings.max(Comparator.comparingInt(value -> value.getInt()));

	}
}
