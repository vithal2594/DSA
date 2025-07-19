package StreamsApi.intermediate;

import java.util.*;

//Group 1: filter() & distinct() (1–10)
//Filter even numbers from a list of integers.
//From a list of strings, filter those that start with 'A'.
//Filter employees (custom objects) with salary > 50,000.
//Remove duplicates from a list of integers.
//From a list of city names, filter names longer than 5 letters.
//Filter non-null values from a list of strings.
//Given a list of emails, filter only those ending with @gmail.com.
//Filter numbers divisible by both 3 and 5.
//From a list of file names, keep only .java files.
//Remove duplicate and empty strings from a list.
public class filterdisticnt {
    public static void main(String[] args){
        List<Integer> li = List.of(1,2,3,4,5,6,7,8,9,10);
        li.stream().filter(i-> i%2 == 0).forEach(System.out::println);

        List<String> str = List.of("Aman", "Ajay", "Balu", "Ram", "Kartik");
        str.stream().filter(s -> s.startsWith("A")).forEach(System.out::println);

        List<Employee> employees = List.of(
                new Employee("John", 60000),
                new Employee("Jane", 45000),
                new Employee("Doe", 70000)
        );
        List<Employee> highSalaryEmployees = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .toList();
        highSalaryEmployees.forEach(System.out::println);

        List<Integer> nums = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNums = nums.stream()
                .distinct()
                .toList();
        System.out.println(distinctNums);
        List<String> cities = List.of("NewYork", "LA", "SanFrancisco", "Miami", "Dallas");
        cities.stream().filter(i-> i.length() > 5)
                .forEach(System.out::println);

        List<String> strings = Arrays.asList("apple", "banana", null, "orange", "kiwi", null);
        List<String> nonNullStrings = strings.stream()
                .filter(Objects::nonNull)
                .toList();
        System.out.println(nonNullStrings);
        List<String> emails = List.of("xyz","az@gmail.com", "123");
        List<String> gmailEmails = emails.stream()
                .filter(email -> email.endsWith("@gmail.com"))
                .toList();
        System.out.println(gmailEmails);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> divisibleBy3And5 = numbers.stream()
                .filter(n -> n % 3 == 0 && n % 5 == 0)
                .toList();
        System.out.println(divisibleBy3And5);
        List<String> fileNames = List.of("file1.java", "file2.txt", "file3.java", "file4.doc");
        List<String> javaFiles = fileNames.stream()
                .filter(name -> name.endsWith(".java"))
                .toList();
        System.out.println(javaFiles);
        List<String> mixedStrings = Arrays.asList("apple", "", "banana", " ", "orange", "kiwi", "", null);
        List<String> filteredStrings = mixedStrings.stream()
                .filter(s -> s != null && !s.isEmpty() && !s.trim().isEmpty())
                .distinct()
                .toList();
        System.out.println(filteredStrings);
    }
    public static class Employee{
        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
