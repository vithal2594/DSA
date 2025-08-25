package slidingWindow.Impo;

import java.util.HashMap;

public class minimumwindowsubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(minWindow("a", "a")); // a
        System.out.println(minWindow("a", "aa")); // ""
    }
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int i = 0, j = 0, formed = 0;
        int required = targetMap.size();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
            if (targetMap.containsKey(ch) &&
                    windowMap.get(ch).intValue() == targetMap.get(ch).intValue()) {
                formed++;
            }
            while (formed == required) {
                // Update min window
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }
                // Try to contract the window
                char leftChar = s.charAt(i);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (targetMap.containsKey(leftChar) &&
                        windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    formed--;
                }
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
