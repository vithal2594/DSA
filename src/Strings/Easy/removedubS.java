package Strings.Easy;

import java.util.*;

public class removedubS {
    public static void main(String[] args) {
        String str = "geeksforgeeksz";
        System.out.println("Original String: " + str);
        System.out.println("String after removing duplicates: " + removedub(str));
    }
    public static String removedub(String str){
        StringBuilder ans = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            if(set.contains(str.charAt(i))){
                continue;
            }
            set.add(str.charAt(i));
            ans.append(str.charAt(i));
        }
        return ans.toString();
    }
}
