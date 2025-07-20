package StreamsApi.intermediate;

import java.util.Comparator;
import java.util.List;

// 1. Sort a list of integers in ascending order.
// 2. Sort a list of strings alphabetically.
// 3. Sort employees by salary (custom comparator).
// 4. Sort product list by name length.
// 5. Sort a list of dates in descending order.
public class sorted {
    public static void main(String[] args){

        List<Integer> l1 = List.of(5, 3, 8, 1, 2);
        l1.stream()
                .sorted()
                .forEach(System.out::println);

        List<String> l2 = List.of("banana", "apple", "cherry");
        l2.stream()
                .sorted()
                .forEach(System.out::println);

        List<Employee> employees = List.of(
                new Employee("John", 50000),
                new Employee("Jane", 60000),
                new Employee("Doe", 55000),
                new Employee("Alice", 80000),
                new Employee("Alice", 70000)
        );
        employees.stream()
                .sorted((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()))
                .forEach(e -> System.out.println(e.getName() + ": " + e.getSalary()));
        System.out.println("<---------Sorted by name and then by salary-------->:");
//        employees.stream()
//                .sorted(
//                        Comparator.comparing(Employee::getName)
//                                .thenComparing(Employee::getSalary)
//                )
//                .forEach(e -> System.out.println(e.getName() + ": " + e.getSalary()));
//
//        employees.stream()
//                .sorted(
//                        Comparator.comparing(Employee::getSalary)
//                                .thenComparing(Employee::getName)
//                )
//                .forEach(e -> System.out.println(e.getName() + ": " + e.getSalary()));



        List<String> products = List.of("Apple", "Banana", "Cherry", "Date");
        products.stream()
                .sorted((p1, p2) -> Integer.compare(p1.length(), p2.length()))
                .forEach(System.out::println);

        List<String> dates = List.of("2023-10-01", "2022-05-15", "2021-12-31");
        dates.stream()
                .sorted((d1, d2) -> d2.compareTo(d1)) // Descending order
                .forEach(System.out::println);

    }


    public static class Employee {
        private String name;
        private int salary;

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }
    }
}
