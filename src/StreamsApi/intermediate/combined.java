package StreamsApi.intermediate;

import java.util.*;

// 1. From a list of integers, square, filter even, sort descending, and limit 3.
// 2. From a list of strings, filter non-empty, map to uppercase, and collect.
// 3. From a list of products, get top 5 by price (map, sorted, limit).
// 4. From a list of names, filter starting with ‘A’, map to lowercase, sort.
// 5. Flatten nested lists of strings, remove duplicates, sort, and collect.
public class combined {
    public static void main(String[] args){

        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result1 = l1.stream()
                .map(i -> i * i)
                .filter(i -> i % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        System.out.println("Result 1: " + result1);

        List<String> l2 = Arrays.asList("apple", "", "banana", "cherry", "date");
        List<String> result2 = l2.stream()
                .filter(s -> !s.isEmpty())
                .map(String::toUpperCase)
                .toList();
        System.out.println("Result 2: " + result2);

        List<Product> products = Arrays.asList(
                new Product("Product1", 100),
                new Product("Product2", 200),
                new Product("Product3", 150),
                new Product("Product4", 300),
                new Product("Product5", 250)
        );
        List<Product> result3 = products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(5)
                .toList();
        System.out.println("Result 3: " + result3);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Anna", "David");
        List<String> result4 = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toLowerCase)
                .sorted()
                .toList();
        System.out.println("Result 4: " + result4);
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("banana", "cherry"),
                Arrays.asList("apple", "date")
        );
        List<String> result5 = nestedList.stream()
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .toList();
        System.out.println("Result 5: " + result5);
    }

    public static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Product{name='" + name + "', price=" + price + '}';
        }
    }
}
