package Strings.Easy;

import java.util.*;
public class freqChar {
    public static void main(String[] args) {
        String s="vitthal";
        freqchar(s);
    }

    public static void freqchar(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> entry: mp.entrySet()){
            if(entry.getValue() > 1){
                System.out.print("['" + entry.getKey() + "', " + entry.getValue() + "], ");            }
        }
    }
}
