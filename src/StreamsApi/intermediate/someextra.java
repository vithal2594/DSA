package StreamsApi.intermediate;

import java.util.*;

// 1. Get the first 5 numbers from a list. (limit)
// 2. Skip the first 3 elements of a stream. (skip)
// 3. Get the top 3 highest scores from a list. (sort + limit)
// 4. From a list of log messages, skip initial debug messages (assume they start with "DEBUG"). (dropWhile)
// 5. From a sorted list of strings, take all starting with "A" using takeWhile(). (takeWhile)
// 6. From a stream of values, drop all values < 10 using dropWhile(). (dropWhile)
// 7. Given a list of transactions sorted by date, get first 10 recent ones. (limit)
public class someextra {
    public static void main(String[] args){

        List<Integer>l1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        l1.stream().limit(5)
                .forEach(System.out::println);
        l1.stream().skip(3)
                .forEach(System.out::println);

        List<Integer>l2 = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        l2.stream().sorted(Comparator.reverseOrder()).limit(3)
                .forEach(System.out::println);

        List<String>logMessages = Arrays.asList("DEBUG: Initializing", "INFO: Started", "ERROR: Something went wrong", "DEBUG: Debugging", "WARN: Warning issued");
        logMessages.stream()
                .dropWhile(msg -> msg.startsWith("DEBUG"))
                .forEach(System.out::println);

        List<String>sortedStrings = Arrays.asList("Apple", "Banana", "Avocado", "Cherry", "Apricot");
        sortedStrings.stream()
                .takeWhile(s -> s.startsWith("A"))
                .forEach(System.out::println);

        List<Integer>values = Arrays.asList(5, 15, 25, 3, 8, 12);
        values.stream()
                .dropWhile(v -> v < 10)
                .forEach(System.out::println);
        List<String>transactions = Arrays.asList("2023-10-01: Transaction A", "2023-10-02: Transaction B", "2023-10-03: Transaction C", "2023-10-04: Transaction D", "2023-10-05: Transaction E");
        transactions.stream()
                .limit(10)
                .forEach(System.out::println);



    }
}
