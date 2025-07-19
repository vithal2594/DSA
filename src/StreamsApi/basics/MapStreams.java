package StreamsApi.basics;
//1.Create a stream of keys from a Map<String, Integer>.
//2.Create a stream of values from a Map<String, Integer> and filter > 50.
//3.Create a stream of entries (key-value pairs) and print each.
//4.Find max value in a Map<String, Integer> using stream.
//5.Convert a Map<String, Integer> to a list of formatted strings: "key=value".

import java.util.*;

public class MapStreams {
    public static  void main(String[] args){
        Map<String, Integer> map = Map.of("apple", 50, "banana", 30, "cherry", 70, "date", 20, "elderberry", 90
        );
        map.keySet().stream().forEach(System.out::println);
        map.values().stream().filter(v-> v>50).forEach(System.out::println);
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
        Optional<Integer> maxValue = map.values().stream().max(Integer::compareTo);
        System.out.println(maxValue);
        List<String> formattedList = map.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .toList();
        System.out.println(formattedList);
    }
}
