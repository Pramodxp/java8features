package com.learnjava.practiceQuestions;
// java program to replace an element
// from ArrayList using Java ListIterator

import java.util.ArrayList;
import java.util.ListIterator;

class GFG {
	public static void main(String[] args)
	{
		ArrayList<String> name = new ArrayList<>();
		name.add("Yash");
		name.add("Akash");
		name.add("Amar");
		name.add("Abhishek");
		name.add("Rajnikanth");

		ListIterator<String> iterator = name.listIterator();

		System.out.println("Before Replacing...");
		
		// Printing the original list
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		
		// Simce the iterator was on last element
		// so the set function used here will replace
		// the last element
		iterator.set("Mohit");
		
		System.out.println();
		System.out.println("After Replacing...");

		for (String n : name) {
			System.out.print(n+" ");
		}
	}
}
