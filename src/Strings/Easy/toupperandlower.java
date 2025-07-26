package Strings.Easy;

public class toupperandlower {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(s);
        System.out.println(toUpperCase1(s));
        System.out.println(toLowerCase1(s));
    }
    public static String toUpperCase1(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.append((char)(c - 32)); // Convert to uppercase
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
    public static String toLowerCase1(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                result.append((char)(c + 32)); // Convert to lowercase
            } else {
                result.append(c); // Leave other chars unchanged
            }
        }

        return result.toString();
    }
}
