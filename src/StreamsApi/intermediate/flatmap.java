package StreamsApi.intermediate;
import java.util.*;
import java.util.stream.*;

// 1. Flatten a list of lists of integers.
// 2. From a list of sentences, extract individual words.
// 3. Flatten a list of comma-separated CSV strings to individual values.
// 4. From a list of books (each with a list of authors), create a stream of all authors.
// 5. Given a list of Optionals, extract only present values.
// 6. Flatten a list of arrays of integers.
// 7. Flatten a stream of lists and sort the resulting stream.
// 8. Convert a stream of string arrays into a stream of characters.
// 9. From a list of paragraphs, get all sentences.
// 10. Given a list of tags (like #java,#streams), flatten to individual tags.
public class flatmap {
    public static void main(String[] args){
        List<List<Integer>> l1 = Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4,5),Arrays.asList(6));
        List<Integer> flattenedIntegers = l1.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println("1. Flattened Integers: " + flattenedIntegers);

        List<String> words = Arrays.asList("Hello World", "Java Streams are powerful", "FlatMap is useful");
        List<String> neww = words.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .toList();
        System.out.println(neww);

        List<String> csvStrings = Arrays.asList("apple,banana", "orange,grape", "kiwi");
        List<String> flattenedCsv = csvStrings.stream()
                .flatMap(csv -> Arrays.stream(csv.split(",")))
                .toList();
        System.out.println(flattenedCsv);

        class Book {
            String title;
            List<String> authors;

            Book(String title, List<String> authors) {
                this.title = title;
                this.authors = authors;
            }
        }
        List<Book> books = Arrays.asList(
                new Book("Book One", Arrays.asList("Author A", "Author B")),
                new Book("Book Two", Arrays.asList("Author C")),
                new Book("Book Three", Arrays.asList("Author A", "Author D"))
        );
        List<String> allAuthors = books.stream()
                .flatMap(book -> book.authors.stream())
                .distinct()
                .toList();
        System.out.println("All Authors: " + allAuthors);

        List<Optional<String>> optionals = Arrays.asList(Optional.of("Value1"), Optional.empty(), Optional.of("Value2"));
        List<String> presentValues = optionals.stream()
                .flatMap(Optional::stream)
                .toList();
        System.out.println("Present Values: " + presentValues);

        List<int[]> arraysOfIntegers = Arrays.asList(new int[]{1, 2}, new int[]{3, 4, 5}, new int[]{6});
        List<Integer> flattenedArrays = arraysOfIntegers.stream()
                .flatMapToInt(Arrays::stream)
                .boxed()
                .toList();
        System.out.println("Flattened Arrays: " + flattenedArrays);

        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(3, 1), Arrays.asList(4, 2), Arrays.asList(5));
        List<Integer> sortedFlattened = listOfLists.stream()
                .flatMap(Collection::stream)
                .sorted()
                .toList();
        System.out.println("Sorted Flattened: " + sortedFlattened);

        List<String[]> stringArrays = Arrays.asList(new String[]{"abc", "def"}, new String[]{"ghi", "jkl"});
        List<Character> characters = stringArrays.stream()
                .flatMap(arr -> Arrays.stream(arr).flatMapToInt(String::chars).mapToObj(c -> (char) c))
                .toList();
        System.out.println("Characters from String Arrays: " + characters);

        List<String> paragraphs = Arrays.asList("This is the first sentence. This is the second.", "Here is another paragraph.");
        List<String> sentences = paragraphs.stream()
                .flatMap(paragraph -> Arrays.stream(paragraph.split("\\. ")))
                .toList();
        System.out.println("Sentences from Paragraphs: " + sentences);

        List<String> tags = Arrays.asList("#java,#streams", "#flatmap,#example", "#coding");
        List<String> individualTags = tags.stream()
                .flatMap(tag -> Arrays.stream(tag.split(",")))
                .distinct()
                .toList();
        System.out.println("Individual Tags: " + individualTags);

    }
}
