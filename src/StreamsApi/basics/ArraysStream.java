package StreamsApi.basics;
//1.Create a stream from an int[] using Arrays.stream().
//2.Create a stream from a String[] and filter those with length > 5.
//3.Convert a double[] to a List<Double> using stream.
//4.Find the average of an int[] using IntStream.
//5.Print odd numbers from an Integer[] using stream.
//6.Create a stream from a char[] and print characters.
//7.Convert a String[] of numbers to List<Integer>.
//8.Use Stream.of() to create a stream from string values directly.
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraysStream {
    public  static void  main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        Arrays.stream(arr).forEach(System.out::println);

        String[] str = {"hello", "world", "java", "stream", "example", "wow", "lol"};
        Arrays.stream(str).filter(s -> s.length() > 5).forEach(System.out::println);

        double[] dbl = {1.1, 2.2, 3.3, 4.4, 5.5};
        List<Double> doubleList = Arrays.stream(dbl).boxed().toList();
        System.out.println(doubleList);

        int[] intArr = {1, 2, 3, 4, 5};
        double average = Arrays.stream(intArr).average().orElse(0.0);
        System.out.println(average);

        Integer[] integerArr = {1, 2, 3, 4, 5};
        Arrays.stream(integerArr).filter(n -> n % 2 != 0).forEach(System.out::println);

        char[] charArr = {'a', 'b', 'c', 'd', 'e','x','y','z'};
//        Arrays.stream(charArr).forEach(ch -> System.out.println(ch));    }
        IntStream.range(0, charArr.length).mapToObj(i ->charArr[i]).forEach(System.out::println);

        String[] numberStr = {"1", "2", "3", "4", "5"};
        Arrays.stream(numberStr).mapToInt(Integer::parseInt)
                .forEach(System.out::println);

        Stream.of("apple", "banana", "cherry")
                .forEach(System.out::println);
    }
}
