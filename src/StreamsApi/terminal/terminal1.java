package StreamsApi.terminal;

import java.util.*;
import java.util.stream.*;

public class terminal1 {
    public static void main(String[] args) {

        // -----------------------------------------------------------
        // 🔹 Category 1: forEach(), filter(), map() - Printing/Transforming
        // -----------------------------------------------------------

        // 1. Print each element in a list of strings.
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        System.out.println("1. Printing each name:");
        names.forEach(System.out::println);

        // 2. Print all even numbers from a list.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("\n2. Printing even numbers:");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // 3. Convert a list of names to uppercase and print them.
        List<String> lowercaseNames = Arrays.asList("john", "doe", "jane");
        System.out.println("\n3. Printing uppercase names:");
        lowercaseNames.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 4. Print the square of each number in a list.
        List<Integer> numsToSquare = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("\n4. Printing squares of numbers:");
        numsToSquare.stream()
                .map(n -> n * n)
                .forEach(System.out::println);

        // -----------------------------------------------------------
        // 🔹 Category 2: collect()
        // -----------------------------------------------------------

        // 1. Convert a list of strings into a Set.
        List<String> duplicateStrings = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
        Set<String> uniqueStrings = duplicateStrings.stream()
                .collect(Collectors.toSet());
        System.out.println("\nCollect 1. Unique Strings (Set): " + uniqueStrings);

        // 2. Convert a list of integers into a comma-separated String.
        List<Integer> numbersToJoin = Arrays.asList(10, 20, 30, 40, 50);
        String commaSeparatedNumbers = numbersToJoin.stream()
                .map(String::valueOf) // Convert Integer to String
                .collect(Collectors.joining(", "));
        System.out.println("Collect 2. Comma-separated Numbers: " + commaSeparatedNumbers);

        // 3. Group a list of employees by department.
        class Employee {
            String name;
            String department;
            public Employee(String name, String department, double salary) {
                this.name = name;
                this.department = department;
            }
            public String getDepartment() { return department; }
            @Override public String toString() { return name + " (" + department + ")"; }
        }

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 60000),
                new Employee("Bob", "IT", 75000),
                new Employee("Charlie", "HR", 62000),
                new Employee("David", "IT", 80000),
                new Employee("Eve", "Sales", 70000)
        );

        Map<String, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("\nCollect 3. Employees Grouped by Department:");
        employeesByDept.forEach((dept, empList) ->
                System.out.println("  " + dept + ": " + empList));
        // Expected output might look like:
        //   HR: [Alice (HR), Charlie (HR)]
        //   IT: [Bob (IT), David (IT)]
        //   Sales: [Eve (Sales)]


        // 4. Partition a list of numbers into even and odd.
        List<Integer> numbersToPartition = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> evenOddPartition = numbersToPartition.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("\nCollect 4. Numbers Partitioned (Even/Odd):");
        System.out.println("  Even: " + evenOddPartition.get(true));
        System.out.println("  Odd: " + evenOddPartition.get(false));


        // 5. Collect a list of strings into a sorted list.
        List<String> unsortedStrings = Arrays.asList("orange", "apple", "grape", "banana");
        List<String> sortedStrings = unsortedStrings.stream()
                .sorted() // Natural order (alphabetical for Strings)
                .collect(Collectors.toList());
        System.out.println("\nCollect 5. Sorted Strings: " + sortedStrings);


        // 6. Count occurrences of each word in a list.
        List<String> wordsForCounting = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> wordCounts = wordsForCounting.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println("\nCollect 6. Word Counts: " + wordCounts);
        // Expected output: {banana=2, orange=1, apple=3}
    }
}
