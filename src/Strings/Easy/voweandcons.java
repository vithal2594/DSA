package Strings.Easy;

public class voweandcons {
    public static void main(String[] args) {
        String str = "geeksforgeeks11";
        int v = 0, c = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                v++;
            } else {
                c++;
            }
        }
        System.out.println("Vowels : " + v);
        System.out.println("Consonants : " + c);
    }
}
