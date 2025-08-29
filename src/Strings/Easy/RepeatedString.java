package Strings.Easy;

import java.util.HashSet;
import java.util.Set;

public class RepeatedString {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        String str="he had has he has had";
        System.out.println(repeatedString(str));

    }
    public static String repeatedString(String str){
        String[] words= str.split(" ");
        Set<String> st = new HashSet<>();
        for(String word: words){
            if(st.contains(word)){
                return word;
            }
            st.add(word);
        }
        return "-1";
    }
}

