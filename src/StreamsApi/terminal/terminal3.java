package StreamsApi.terminal;
import java.util.*;
import java.util.stream.*;
public class terminal3 {
    public static void main(String[] args) {

        // Sample data for various operations
        List<Integer> numbers = Arrays.asList(5, 12, -8, 20, 3, 15, 10, 22);
        List<String> words = Arrays.asList("apple", "Banana", "apricot", "grape", "avocado", "Kiwi", "");

        class Employee {
            String name;
            String department;
            String city; // Added for 'allMatch' example
            double salary;

            public Employee(String name, String department, String city, double salary) {
                this.name = name;
                this.department = department;
                this.city = city;
                this.salary = salary;
            }
            public String getDepartment() { return department; }
            public String getCity() { return city; }
            public double getSalary() { return salary; }
            public String getName() { return name; }
            @Override public String toString() { return name + " (" + department + " in " + city + ")"; }
        }

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", "New York", 60000),
                new Employee("Bob", "IT", "London", 75000),
                new Employee("Charlie", "HR", "New York", 62000),
                new Employee("David", "IT", "London", 80000),
                new Employee("Eve", "Sales", "New York", 70000) // Changed to New York for this example
        );

        // -----------------------------------------------------------
        // 🔹 Category 6: anyMatch(), allMatch(), noneMatch()
        // -----------------------------------------------------------

        // 1. Check if any number is negative.
        boolean anyNegative = numbers.stream()
                .anyMatch(n -> n < 0);
        System.out.println("Match 1. Any number is negative: " + anyNegative); // Output: true

        // 2. Check if all strings are in lowercase.
        boolean allLowercase = words.stream()
                .allMatch(s -> s.equals(s.toLowerCase()));
        System.out.println("Match 2. All strings are lowercase: " + allLowercase); // Output: false (due to "Banana", "Kiwi")

        // 3. Check if none of the words are empty strings.
        boolean noneEmpty = words.stream()
                .noneMatch(String::isEmpty); // Or s -> s.length() == 0
        System.out.println("Match 3. None of the words are empty: " + noneEmpty); // Output: false (due to "")

        // 4. Check if all employees are from the same city.
        // For this example, let's make them mostly from "New York"
        List<Employee> cityEmployees = Arrays.asList(
                new Employee("Alice", "HR", "New York", 60000),
                new Employee("Charlie", "HR", "New York", 62000),
                new Employee("Eve", "Sales", "New York", 70000)
        );
        boolean allSameCity = cityEmployees.stream()
                .allMatch(e -> e.getCity().equals("New York"));
        System.out.println("Match 4. All employees are from the same city ('New York'): " + allSameCity); // Output: true

        // -----------------------------------------------------------
        // 🔹 Category 7: findFirst() / findAny()
        // -----------------------------------------------------------

        // 1. Find the first even number.
        Optional<Integer> firstEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .findFirst();
        System.out.println("\nFind 1. First even number: " + firstEven.orElse(0)); // Output: 12

        // 2. Find any name that starts with “A”.
        Optional<String> anyNameStartingWithA = words.stream()
                .filter(s -> s.startsWith("a") || s.startsWith("A"))
                .findAny(); // findAny() can be more performant in parallel streams
        System.out.println("Find 2. Any name starting with 'A': " + anyNameStartingWithA.orElse("N/A")); // Output: Optional[apple] or Optional[apricot] or Optional[avocado]

        // 3. Find the first string with more than 5 characters.
        Optional<String> firstLongString = words.stream()
                .filter(s -> s.length() > 5)
                .findFirst();
        System.out.println("Find 3. First string with > 5 characters: " + firstLongString.orElse("N/A")); // Output: banana

        // -----------------------------------------------------------
        // 🔹 Category 8: Advanced Terminal Collectors
        // -----------------------------------------------------------

        // 1. Create a map of word length to list of words.
        List<String> wordsForMapping = Arrays.asList("cat", "dog", "elephant", "bird", "lion", "tiger");
        Map<Integer, List<String>> wordsByLength = wordsForMapping.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("\nAdv Collectors 1. Words grouped by length: " + wordsByLength);
        // Expected output: {3=[cat, dog], 8=[elephant], 4=[bird, lion], 5=[tiger]}


        // 2. Find the average salary of employees in each department.
        Map<String, Double> avgSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println("Adv Collectors 2. Average salary by department: " + avgSalaryByDepartment);
        // Expected output: {HR=61000.0, IT=77500.0, Sales=70000.0} (based on provided employees list)
    }
}
