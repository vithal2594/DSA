package StreamsApi.basics;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//1.Convert a String to a stream of characters.
//2.Count number of vowels in a given String using stream.
//3.Use chars() to convert a string to IntStream.
//4.Create a stream of words from a sentence using split().
//5.Remove duplicate characters from a string using stream.
//6.Check if a string has any digits using stream.
//7.Reverse a string using stream and collectors.
public class StringsSteam {
    public static void main(String[] args){
        String str ="Hello Java";
        str.chars().mapToObj(c -> (char) c).forEach(System.out::println);
        long countvowels = str.chars().filter(c -> "aeiouAEIOU".indexOf(c) != -1).count();
        System.out.println(countvowels);

        IntStream intStream= str.chars();
        intStream.forEach(System.out::println);

        String sentence = "Hello World from Java Streams";
        Arrays.stream(sentence.split(" "))
                .forEach(System.out::println);

        String word = "programming";
        String uniqurc = word.chars().distinct().mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println(uniqurc);

        String str2 = "Hello123";
        boolean hasDigits = str2.chars().anyMatch(Character::isDigit);
        System.out.println(hasDigits);

        // Reverse a string using streams and StringBuilder
        String reversed = new StringBuilder(
                str.chars()
                        .mapToObj(c -> String.valueOf((char) c))
                        .collect(Collectors.joining())
        ).reverse().toString();
        System.out.println(reversed);

    }
}
