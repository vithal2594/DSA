package Strings.Easy;

public class capitalfirstLet {
    public static void main(String[] args) {
        String input = "   hello   world   from java ";
        System.out.println(capitalizeFirstLetters(input));
        // Output: "Hello World From Java"
    }
    public static String capitalizeFirstLetters(String input) {
        String[] words = input.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                words[i] = words[i].substring(0, 1).toUpperCase()
                        + words[i].substring(1).toLowerCase();
            }
        }
        return String.join(" ", words);
    }

}
