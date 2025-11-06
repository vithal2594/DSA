package StreamsApi.intermediate;

import java.util.*;

// 1. Print each number before and after squaring using peek().
// 2. Log filtering and mapping of strings using peek().
// 3. Use peek() to audit before collecting employee names to a list.
public class peek {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .peek(n -> System.out.println("Before squaring: " + n))
                .map(n -> n * n)
                .peek(n -> System.out.println("After squaring: " + n))
                .forEach(System.out::println);

        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        strings.stream()
                .filter(s -> s.length() > 5)
                .peek(s -> System.out.println("Filtering: " + s))
                .map(String::toUpperCase)
                .peek(s -> System.out.println("Mapping to uppercase: " + s))
                .forEach(System.out::println);

        List<String> employees = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> employeeNames = employees.stream()
                .peek(e -> System.out.println("Auditing employee: " + e))
                .toList();
        System.out.println("Collected employee names: " + employeeNames);
    }
}
