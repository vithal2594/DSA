package StreamsApi.intermediate;

import java.time.LocalDate;
import java.util.List;

// 1. Square each number in a list.
// 2. Convert a list of strings to uppercase.
// 3. Convert a list of product objects to their price list.
// 4. Map strings to their lengths.
// 5. Convert a list of integers to their binary string representations.
// 6. Map a list of integers to boolean: is even?
// 7. Round a list of doubles to 2 decimal places.
// 8. Convert a list of dates (strings) to LocalDate objects.
// 9. Map a list of temperatures in Celsius to Fahrenheit.
// 10. From a list of full names, extract only first names.
public class map {
    public static void main(String [] args){
        List<Integer> l1 = List.of(1, 2, 3, 4, 5);
        l1.stream()
                .map(n -> n * n)
                .forEach(System.out::println);

        List<String> l2 = List.of("hello", "world", "java");
        l2.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        List<Product> products = List.of(new Product("Apple", 1.2), new Product("Banana", 0.8));
//        System.out.println(products);
        products.stream()
                .map(Product::getPrice)
                .forEach(System.out::println);

        List<String> l3 = List.of("apple", "banana", "cherry");
        l3.stream()
                .map(String::length)
                .forEach(System.out::println);
        List<Integer> l4 = List.of(1,2,10, 20, 30);
        l4.stream()
                .map(Integer::toBinaryString)
                .forEach(System.out::println);

        l1.stream()
                .map(n -> n % 2 == 0)
                .forEach(System.out::println);

        List<Double> l5 = List.of(1.2345, 2.3456, 3.4567);
        l5.stream()
                .map(d -> Math.round(d * 100.0) / 100.0)
                .forEach(System.out::println);
        List<String> l6 = List.of("2023-01-01", "2023-02-02", "2023-03-03");
        l6.stream()
                .map(LocalDate::parse).toList()
                .forEach(System.out::println);

        List<Double> celsiusTemps = List.of(0.0, 20.0, 37.0);
        celsiusTemps.stream()
                .map(c -> c * 9 / 5 + 32)
                .forEach(System.out::println);
        List<String> fullNames = List.of("John Doe", "Jane Smith", "Alice Johnson");
        fullNames.stream()
                .map(name -> name.split(" ")[0])
                .forEach(System.out::println);
    }
    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
        public double getPrice() {
            return price;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
