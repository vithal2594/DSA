package StreamsApi;

import java.util.*;

//“ABC” - 20
//“XYZ” - 60
//DEF - 50
//QWE - 40
public class hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> mp = new HashMap<>();
        mp.put("ABC", 20);
        mp.put("EFG", 20);
        mp.put("XYZ", 60);
        mp.put("DEF", 50);
        mp.put("QWE", 90);
        mp.put("QWF", 40);
        System.out.println(mp);

        mp.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()).forEach(System.out::println);
        System.out.println("<---------------------->");
        mp.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey()).forEach(System.out::println);
        System.out.println("<---------------------->");
        mp.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .forEach(System.out::println);

        System.out.println("<---------------------->");

        mp.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByKey().thenComparing(Map.Entry.comparingByValue()))
                .forEach(System.out::println);


    }
}
