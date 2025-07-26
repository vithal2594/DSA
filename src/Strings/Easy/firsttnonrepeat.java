package Strings.Easy;

import java.util.HashMap;
import java.util.Map;

public class firsttnonrepeat {
    public static void main(String[] args) {
        String s="geeksforgeeks";
        System.out.println(firstnonrepeating(s));
    }
    public static char firstnonrepeating(String s) {
      Map<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s.toCharArray()) {
            if (mp.get(ch) == 1) {
                return ch;
            }
        }
        return (char) -1;
    }
}
