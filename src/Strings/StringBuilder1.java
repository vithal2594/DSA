package Prac.Strings;

import java.util.Scanner;

public class StringBuilder1 {
    
    public static void stringcasting(String str){
        StringBuilder result= new StringBuilder();
        for(char ch: str.toCharArray()){
            if(Character.isUpperCase(ch)){
               result.append(Character.toLowerCase(ch));
            }else if(Character.isLowerCase(ch)){
                result.append(Character.toUpperCase(ch));
            }else{
                result.append(ch);
            }
        }
        System.out.println("Swapped Case Strings");
        System.out.println(result);
    }
    public static void stringcastingusingascii(String str){
        StringBuilder result = new StringBuilder();
        for(char ch: str.toCharArray()){
            if(ch>='A' && ch<='Z'){
                result.append((char)(ch+32));
            }else if(ch >= 'a' && ch <='z'){
                result.append((char)(ch-32));
            }else{
                result.append(ch);
            }
        }
        System.out.println("Swapped Case Strings using ascii");
        System.out.println(result);
    }
    public static void ispalindrome(String str){
        StringBuilder gtr = new StringBuilder(str);
        gtr.reverse();
        if(str.equals(gtr.toString())){
            System.out.println("Its a palindrome");
        }else{
            System.out.println("NOT palindrome");
        }

    }
    public static void ispalindromeusingwhile(String str){
        int i=0;
        int j=str.length()-1;

        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                System.out.println("Not Palindrome");
                return;
            }
            i++;
            j--;
        }
        System.out.println("It's a palindrome");
    }
    public static void countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        // return count;
        System.out.println("Total palindromic substrings: " + count);
    }
    public static String reverseEachword(String str){
       String words[] = str.split(" ");
       StringBuilder result = new StringBuilder();
       for(String word : words){
          result.append(new StringBuilder(word).reverse().toString()).append(" ");
       }
       return result.toString().trim();
    }

    public static String conschar(String str){
        StringBuilder result = new StringBuilder();
        int count=1;
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }else{
                result.append(str.charAt(i-1)).append(count);
                count=1;
            }
        }
        result.append(str.charAt(str.length()-1)).append(count);
        if(result.length() < str.length()){
            return str;
        }
        return result.toString();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String str = sc.nextLine(); 
        System.out.println("Compressed: " + conschar(str));  // Output: a3b2c1
        // reverseEachword(str);
        // countSubstrings(str);
        // ispalindromeusingwhile(str);
        // ispalindrome(str);
        // stringcasting(str);
        // stringcastingusingascii(str);
        sc.close();
    }
}
