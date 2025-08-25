package stream;

import java.time.LocalTime;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

public class StreamCreateDemo {

    public static void main(String[] args) throws Exception {

        // 1. Create a Stream from a List<String>
        List<String> list = List.of("Alice", "Bob");
        list.stream().forEach(System.out::println); // used directly

        // 2. Stream from a Set<Integer>
        Set<Integer> set = Set.of(1, 2, 3);
        set.stream().forEach(System.out::println);

        // 3. Parallel stream
        list.parallelStream().forEach(System.out::println);

        // 4. Filter names starting with 'A'
        list.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);

        // 5. Sum of list of integers
        List<Integer> numbers = List.of(1, 2, 3);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);

        // 6. Array to stream
        int[] array = {1, 2, 3, 4};
        Arrays.stream(array).forEach(System.out::println);

        // 7. Count strings with 'a'
        String[] arr = {"apple", "banana", "grape"};
        long count = Arrays.stream(arr).filter(s -> s.contains("a")).count();
        System.out.println("Count of words with 'a': " + count);

        // 8. Max from double[]
        double[] dArr = {1.2, 5.7, 3.6};
        Arrays.stream(dArr).max().ifPresent(max -> System.out.println("Max: " + max));

        // 9. Array to list
        List<String> collected = Arrays.stream(arr).toList();
        System.out.println("Collected list: " + collected);

        // 10. int[] to List<Integer>
        List<Integer> boxed = Arrays.stream(array).boxed().toList();
        System.out.println("Boxed list: " + boxed);

        // 11. Stream.of to Set
        Set<String> set2 = Stream.of("one", "two").collect(Collectors.toSet());
        System.out.println("Set2: " + set2);

        // 12. Filter even numbers
        Stream.of(1, 2, 3, 4).filter(i -> i % 2 == 0).forEach(System.out::println);

        // 13. Stream of custom objects
        Stream.of(new Person("A"), new Person("B")).forEach(System.out::println);

        // 14. Average of doubles
        OptionalDouble avg = Stream.of(1.2, 2.4, 3.6).mapToDouble(Double::doubleValue).average();
        avg.ifPresent(a -> System.out.println("Average: " + a));

        // 15. First 10 even numbers
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        // 16. Powers of 2
        Stream.iterate(2, n -> n * 2).limit(5).forEach(System.out::println);

        // 17. Odd numbers
        Stream.iterate(1, n -> n + 2).limit(10).forEach(System.out::println);

        // 18. Skip 5, take 5
        Stream.iterate(1, n -> n + 1).skip(5).limit(5).forEach(System.out::println);

        // 19. Random numbers
        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        // 20. Constant values
        Stream.generate(() -> "Hello").limit(10).forEach(System.out::println);

        // 21. UUIDs
        List<UUID> uuids = Stream.generate(UUID::randomUUID).limit(3).toList();
        System.out.println("UUIDs: " + uuids);

        // 22. Current time
        Stream.generate(LocalTime::now).limit(3).forEach(System.out::println);

        // 23. Builder example
        Stream.<String>builder().add("apple").add("banana").build()
                .map(String::toUpperCase).forEach(System.out::println);

        // 24. Builder max
        OptionalInt maxBuilt = Stream.<Integer>builder().add(1).add(2).add(3).build()
                .mapToInt(Integer::intValue).max();
        maxBuilt.ifPresent(maxVal -> System.out.println("Builder Max: " + maxVal));

        // 25. Empty builder
        long countEmpty = Stream.<String>builder().build().count();
        System.out.println("Empty stream count: " + countEmpty);

        // 26. Read file lines (commented out to avoid FileNotFoundException)
        // long fileLines = Files.lines(Paths.get("file.txt")).count();

        // 27. Split sentence
        String sentence = "I love Java Streams";
        Pattern.compile(" ").splitAsStream(sentence).forEach(System.out::println);

        // 28. Merge two streams
        Stream.concat(Stream.of("a"), Stream.of("b")).forEach(System.out::println);

        // 29. Flatten list of arrays
        List<String[]> data = List.of(new String[]{"a", "b"}, new String[]{"c"});
        data.stream().flatMap(Arrays::stream).forEach(System.out::println);

        // 30. IntStream range to list
        List<Integer> rangeList = IntStream.range(1, 6).boxed().toList();
        System.out.println("Range List: " + rangeList);
    }

    static class Person {
        String name;

        Person(String name) {
            this.name = name;
        }

        public String toString() {
            return "Person{name='" + name + "'}";
        }
    }
}
