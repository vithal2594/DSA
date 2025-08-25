package slidingWindow.Impo;

import java.util.HashMap;
import java.util.Map;

public class countanagramoccurance {
    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(countAnagrams(s, p)); // Output: 2
    }
    public static int countAnagrams(String s, String p) {
        int n = s.length(), k = p.length();
        if (n < k) return 0;

        Map<Character, Integer> pMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int i = 0, j = 0, count = 0;

        while (j < n) {
            char endChar = s.charAt(j);
            windowMap.put(endChar, windowMap.getOrDefault(endChar, 0) + 1);
            if (j - i + 1 == k) {
                if (windowMap.equals(pMap)) {
                    count++;
                }
                // shrink window from left
                char startChar = s.charAt(i);
                windowMap.put(startChar, windowMap.get(startChar) - 1);
                if (windowMap.get(startChar) == 0) {
                    windowMap.remove(startChar);
                }
                i++;
            }
            j++;
        }
        return count;
    }
}
