package com.learnjava.practiceQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PracticeStreams {
	static List<Employee> employeeList;

	static {
		employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
	}

	public static void main(String[] args) {
//		How many male and female employees are there in the organization?
		Map<Object, Long> genderMap = employeeList.stream()
				.collect(Collectors.groupingBy(employee -> employee.getGender(), Collectors.counting()));
		System.out.println(genderMap);

		// Print the name of all departments in the organization?
		employeeList.stream().map(emp -> emp.department).distinct().forEach(System.out::println);

		// What is the average age of male and female employees?
		Map<String, Double> averageAgeOfMaleAndFemale = employeeList.stream().collect(
				Collectors.groupingBy(employee -> employee.getGender(), Collectors.averagingInt(Employee::getAge)));
		System.out.println("average age of male and female is : " + averageAgeOfMaleAndFemale + "\n");

		// Get the details of highest paid employee in the organization?
		Optional<Employee> optionalEmp = employeeList.stream().collect(
				Collectors.maxBy((emp1, emp2) -> new Double(emp1.getSalary()).compareTo(new Double(emp2.getSalary()))));
		System.out.println("highest paid employee : " + optionalEmp.get() + "\n");

//		Get the names of all employees who have joined after 2015?
		List<String> listOfNamesOfEmployees = employeeList.stream().filter(emp -> emp.getYearOfJoining() > 2015)
				.map(Employee::getName).collect(Collectors.toList());
		System.out.println("name of employees who has joined after 2015 : " + listOfNamesOfEmployees + "\n");

		// Count the number of employees in each department?
		Map<String, Long> countOfEmployeesInEachDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("Count of employees in each department is : " + countOfEmployeesInEachDepartment + "\n");

		// What is the average salary of each department?
		Map<String, Double> averageSalaryMap = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("average salary in each department is : " + averageSalaryMap + "\n");

		// Get the details of youngest male employee in the product development
		// department?
		Optional<Employee> youngestMaleEmployee = employeeList.stream().filter(emp -> emp.getGender().equals("Male"))
				.filter(emp -> emp.getDepartment().equals("Product Development"))
				.collect(Collectors.minBy((emp1, emp2) -> new Integer(emp1.getAge()).compareTo(emp2.getAge())));

		if (youngestMaleEmployee.isPresent()) {
			System.out.println("youngest male employee in the in product development department is : "
					+ youngestMaleEmployee.get() + "\n");
		}

		// Who has the most working experience in the organization?
		Optional<Employee> employeeWhoHasMostWorkingExperience = employeeList.stream().collect(Collectors
				.minBy((emp1, emp2) -> new Integer(emp1.getYearOfJoining()).compareTo(emp2.getYearOfJoining())));

		if (employeeWhoHasMostWorkingExperience.isPresent()) {
			System.out.println(
					"employee who has maximum experience : " + employeeWhoHasMostWorkingExperience.get() + "\n");
		}

		// How many male and female employees are there in the sales and marketing team?
		Map<String, Long> employeesInMarketingTeam = employeeList.stream()
				.filter(employee -> employee.getDepartment().equals("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("male and female employees present in the sales and marketing team : "
				+ employeesInMarketingTeam + "\n");

		// What is the average salary of male and female employees?
		Map<String, Double> averageSalaryOfMaleAndFemale = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("the average salary of male and female employees : " + averageSalaryOfMaleAndFemale + "\n");

		// List down the names of all employees in each department?
		Map<String, List<Employee>> departmentMap = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Map.Entry<String, List<Employee>>> entrySet = departmentMap.entrySet();

		for (Entry<String, List<Employee>> entry : entrySet) {
			System.out.println("----------------------------------");

			System.out.println("employees in the department are : " + entry.getKey());
			System.out.println("----------------------------------");
			for (Employee emp : entry.getValue()) {
				System.out.println(emp.getName());
			}
		}
		System.out.println();

		// What is the average salary and total salary of the whole organization?
		DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Average salary of the whole organization is : " + doubleSummaryStatistics.getAverage());
		System.out.println("total salary of the organization is : " + doubleSummaryStatistics.getSum() + "\n");

		// Separate the employees who are younger or equal to 25 years from those
		// employees who are older than 25 years.
		Map<Boolean, List<Employee>> ageSeparatedEmployees = employeeList.stream()
				.collect(Collectors.partitioningBy(emp -> emp.age > 25));

		Set<Map.Entry<Boolean, List<Employee>>> ageSeparatedEmployeesMap = ageSeparatedEmployees.entrySet();
		for (Entry<Boolean, List<Employee>> entry : ageSeparatedEmployeesMap) {
			System.out.println("----------------------------------");

			System.out.println("employees age" + (entry.getKey() == true ? " greater than 25." : " lessthan 25."));
			System.out.println("----------------------------------");
			for (Employee emp : entry.getValue()) {
				System.out.println(emp.getName());
			}
		}

		// Who is the oldest employee in the organization? What is his age and which
		// department he belongs to?
		Optional<Employee> oldestEmployee = employeeList.stream()
				.max((emp1, emp2) -> new Integer(emp1.getAge()).compareTo(new Integer(emp2.getAge())));

		if (oldestEmployee.isPresent()) {
			System.out.println("\nOldest employee in the organization is : " + oldestEmployee.get());
		}
		
		int[] intArray = {2,5,9,7,5,6};
//		ArrayList list
		for(Integer inter:intArray) {
			
		}
//		List<Integer> asList = Arrays.asList(intArray);
		
		Employee[] arrayOfEmps = {
			    new Employee(0, null, 0, null, null, 0, 0), 
			    new Employee(0, null, 0, null, null, 0, 0), 
			    new Employee(0, null, 0, null, null, 0, 0), 
			};
		
		List<Employee> asList1 = Arrays.asList(arrayOfEmps);

	}

}
