package StreamsApi.basics;
//1.Create a stream using Stream.generate() to generate random numbers.
//2.Create a stream using Stream.iterate() to generate square numbers.
//3.Use BufferedReader.lines() to read lines from a file (if allowed).
//4.Read words from a file and stream-filter words > 5 letters.
//5.Create a stream from user input using Scanner.tokens() (simulate).
//6.Use Files.walk() to create a stream of file paths (advanced).
//7.Use IntStream.range() to print numbers from 1 to 100.
//8.Use LongStream.rangeClosed() to get 1 to 10 factorial.
//9.Use DoubleStream.generate() to simulate sensor data (e.g., temperature).
//10.Create a stream from multiple values using Stream.of(1, 2, 3...).

import java.util.stream.*;

public class othersource {
    public static  void main(String[] args){
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
        Stream.iterate(1, n -> n + 1).limit(5).map(n -> n * n).forEach(System.out::println);

        DoubleStream.generate(() -> 20 + Math.random() * 10).limit(5).forEach(System.out::println);
        Stream.of(1, 2, 3, 4).forEach(System.out::println);
        long factorial = LongStream.rangeClosed(1, 5).reduce(1, (a, b) -> a * b);
        System.out.println(factorial);
        IntStream.range(1, 101).forEach(System.out::println);

    }
}
