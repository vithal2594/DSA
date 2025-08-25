package StreamsApi.basics;

import java.util.*;
import java.util.stream.Collectors;

//Basic Collections – List & Set (1–10)
//Create a stream from a List<String> of names.
//Create a stream from a Set<Integer> and print all even numbers.
//Create a stream from a list of integers and print square of each.
//Convert a List<String> to uppercase using stream.
//Count number of elements in a Set<String> using stream.
//Filter strings in a list that start with a vowel.
//Create a stream from a List<Double> and sum all values.
//Create a stream from a List<Integer> and find the max.
//Use List.of(...) and stream to collect values greater than 10.
//Use .stream() on ArrayList<Integer> and sort the elements.
public class Baiscs {
    public static void main(String[] args){
        //1.
        List<String> names = List.of("aman", "ajay", "balu", "ram", "kartik");
        names.stream().forEach(System.out::println);
//
//        //2.
        Set<Integer> nums = Set.of(1, 2, 3,4,12,15,17,18);
        nums.stream().filter(n -> n%2 == 0).forEach(System.out :: println);
//        //3.
        List<Integer> nums1 = List.of(1,2,3);
        nums1.stream().map(n->n*n).forEach(System.out::println);
//        //4.
        names.stream().map(String::toUpperCase).forEach(System.out::println);
//        //5.
        Set<String> names1 = Set.of("abc","haha","lala","lol");
        System.out.println(names1.stream().count());
        //6.
        List<String> str = List.of("Aman", "Ban", "OO","Emly", "Ihs","zml");
        str.stream().filter(s -> !s.isEmpty() && "aeiouAEIOU".indexOf(s.charAt(0)) != -1 ).toList().forEach(System.out::println);

// 7.
        List<Double> numsd = List.of(10.5, 25.9,90.78);
        System.out.println(numsd.stream().mapToDouble(Double::doubleValue).sum());
        //8.
        List<Integer> nums2 = List.of(1,2,3,90,20,12,88);
        System.out.println(nums2.stream().mapToInt(Integer::intValue).max().stream().findFirst());

        //Use List.of(...) and stream to collect values greater than 10.
        List<Integer> l1 = List.of(12, 19,20,25,70,9,8,7);
        l1.stream().filter(i -> i > 10).forEach(System.out::println);

        //Use .stream() on ArrayList<Integer> and sort the elements.
        ArrayList<Integer> al = new ArrayList<>(List.of(12,80,56,90,-1));
        al.stream().sorted().forEach(System.out::println);
    }
}
