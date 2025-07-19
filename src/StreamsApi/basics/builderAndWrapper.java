package StreamsApi.basics;

import java.util.*;
import java.util.stream.*;

//1.Use Stream.Builder to build a stream manually.
//2.Combine two streams using Stream.concat().
//3.Use Stream.empty() and check if it's empty.
//4.Create a stream from an Enum values list.
//5.Convert a List<Optional<String>> to a stream of present strings.
//6.Flatten a list of lists using stream of list → flatMap.
//7.Use IntStream.of(1, 2, 3) and double all values.
//8.Convert Optional<String> to stream using optional.stream().
//9.Create stream from nested arrays: String[][].
//10.Create a stream from a CSV string using .split() and .stream().
public class builderAndWrapper {
    public static void main(String[] arges){
        Stream.Builder<String> str = Stream.builder();
        str.add("Hello");
        str.add("vithal");
        str.add("How are you");
        str.build().forEach(System.out::println);

        Stream<String> s1 = Stream.of("x","y");
        Stream<String> s2 = Stream.of("z");
        Stream.concat(s1,s2).forEach(System.out::println);

        Stream<Object> emptyStream = Stream.empty();
        System.out.println(emptyStream.count());

        enum Day {MON,TUE, WED}
        Arrays.stream(Day.values()).forEach(System.out::println);

        List<Optional<String>> opts = List.of(Optional.of("onr"),Optional.of("two"),Optional.empty());
        opts.stream().flatMap(Optional::stream).forEach(System.out::println);

        List<List<String>> listOfLists = List.of(List.of("a", "b"), List.of("c"));
        listOfLists.stream().flatMap(Collection::stream).forEach(System.out::println);

        IntStream.of(1, 2, 3).map(n -> n * 2).forEach(System.out::println);

        Optional<String> opt = Optional.of("hello");
        opt.stream().forEach(System.out::println);

        String[][] nested = {{"a", "b"}, {"c", "d"}};
        Stream.of(nested).flatMap(Arrays::stream).forEach(System.out::println);

        String csv = "1,2,3,4";
        Arrays.stream(csv.split(",")).map(Integer::parseInt).forEach(System.out::println);
    }
}
