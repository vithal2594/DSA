package StreamsApi.terminal;

import java.util.*;
import java.util.stream.*;

public class terminal2 {
    public static void main(String[] args) {

        // Sample data for various operations
        List<Integer> numbers = Arrays.asList(5, 12, 8, 20, 3, 15, 10, 22);
        List<String> words = Arrays.asList("apple", "banana", "apricot", "grape", "avocado", "kiwi");

        class Employee {
            String name;
            double salary;

            public Employee(String name, double salary) {
                this.name = name;
                this.salary = salary;
            }
            public double getSalary() { return salary; }
            public String getName() { return name; }
            @Override public String toString() { return name + " ($" + salary + ")"; }
        }

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 60000),
                new Employee("Bob", 75000),
                new Employee("Charlie", 62000),
                new Employee("David", 80000)
        );

        class Student {
            String name;
            int grade;

            public Student(String name, int grade) {
                this.name = name;
                this.grade = grade;
            }
            public int getGrade() { return grade; }
            public String getName() { return name; }
            @Override public String toString() { return name + " (Grade: " + grade + ")"; }
        }

        List<Student> students = Arrays.asList(
                new Student("Sophia", 85),
                new Student("Liam", 92),
                new Student("Olivia", 78),
                new Student("Noah", 95)
        );

        // -----------------------------------------------------------
        // 🔹 Category 3: count(), distinct()
        // -----------------------------------------------------------

        // 1. Count how many numbers are greater than 10 in a list.
        long countGreaterThan10 = numbers.stream()
                .filter(n -> n > 10)
                .count();
        System.out.println("Count 1. Numbers greater than 10: " + countGreaterThan10); // Output: 4 (12, 20, 15, 22)

        // 2. Count the number of strings starting with a given letter.
        char startingLetter = 'a';
        long countStartingWithA = words.stream()
                .filter(s -> s.startsWith(String.valueOf(startingLetter)))
                .count();
        System.out.println("Count 2. Strings starting with '" + startingLetter + "': " + countStartingWithA); // Output: 3 (apple, apricot, avocado)

        // 3. Count distinct elements in a list.
        List<String> withDuplicates = Arrays.asList("red", "green", "blue", "red", "yellow", "blue");
        long distinctCount = withDuplicates.stream()
                .distinct()
                .count();
        System.out.println("Count 3. Distinct elements: " + distinctCount); // Output: 4 (red, green, blue, yellow)

        // -----------------------------------------------------------
        // 🔹 Category 4: min() / max()
        // -----------------------------------------------------------

        // 1. Find the maximum number in a list.
        Optional<Integer> maxNumber = numbers.stream()
                .max(Integer::compare); // Or .max(Comparator.naturalOrder())
        System.out.println("\nMin/Max 1. Maximum number: " + maxNumber.orElse(0)); // Output: 22

        // 2. Find the longest string in a list.
        Optional<String> longestString = words.stream()
                .max(Comparator.comparingInt(String::length));
        System.out.println("Min/Max 2. Longest string: " + longestString.orElse("N/A")); // Output: banana (or avocado if lengths were equal and it came first)

        // 3. Find the employee with the highest salary.
        Optional<Employee> highestPaidEmployee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Min/Max 3. Employee with highest salary: " + highestPaidEmployee.orElse(null)); // Output: David ($80000.0)

        // 4. Find the student with the minimum grade.
        Optional<Student> studentWithMinGrade = students.stream()
                .min(Comparator.comparingInt(Student::getGrade));
        System.out.println("Min/Max 4. Student with minimum grade: " + studentWithMinGrade.orElse(null)); // Output: Olivia (Grade: 78)

        // -----------------------------------------------------------
        // 🔹 Category 5: reduce()
        // -----------------------------------------------------------

        // 1. Find the sum of all numbers.
        // Option 1: Using reduce with an identity
        Integer sumOfNumbers = numbers.stream()
                .reduce(0, Integer::sum); // Identity: 0, Accumulator: (a, b) -> a + b
        System.out.println("\nReduce 1. Sum of all numbers: " + sumOfNumbers); // Output: 85 (5+12+8+20+3+15+10+22)

        // Option 2: Using IntStream.sum() for primitive int streams (more efficient)
        int sumOfNumbersIntStream = numbers.stream()
                .mapToInt(Integer::intValue) // Convert to IntStream
                .sum();
        System.out.println("Reduce 1. Sum of all numbers (IntStream): " + sumOfNumbersIntStream);

        // 2. Multiply all numbers together.
        Optional<Integer> productOfNumbers = numbers.stream()
                .reduce((a, b) -> a * b); // No identity, returns Optional
        System.out.println("Reduce 2. Product of all numbers: " + productOfNumbers.orElse(0)); // Output: 1425600

        // 3. Find the longest string using reduce.
        List<String> stringList = Arrays.asList("apple", "banana", "kiwi", "grapefruit", "fig");
        Optional<String> longestStringReduce = stringList.stream()
                .reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        System.out.println("Reduce 3. Longest string using reduce: " + longestStringReduce.orElse("")); // Output: grapefruit

        // 4. Concatenate all strings in a list using reduce.
        List<String> wordsToConcatenate = Arrays.asList("Java", "Streams", "are", "fun");
        String concatenatedString = wordsToConcatenate.stream()
                .reduce("", (acc, element) -> acc + element + " "); // Identity: "", Accumulator: appends with space
        System.out.println("Reduce 4. Concatenated string: '" + concatenatedString.trim() + "'"); // Output: 'Java Streams are fun'

        // Another common way to concatenate (often preferred for simplicity) is Collectors.joining()
        String concatenatedStringJoining = wordsToConcatenate.stream()
                .collect(Collectors.joining(" "));
        System.out.println("Reduce 4. Concatenated string (Collectors.joining): '" + concatenatedStringJoining + "'");
    }
}
