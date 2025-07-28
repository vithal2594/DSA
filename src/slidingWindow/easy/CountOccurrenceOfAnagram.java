package slidingWindow.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class CountOccurrenceOfAnagram {
        public static void main(String[] args) {
            String text = "forxxorfxdofr";
            String pattern = "for";

            List<Integer> result = countOcc(text, pattern);
            System.out.println("Anagram starting indices: " + result);
            System.out.println("Total anagrams found: " + result.size());
        }
        public static List<Integer> countOcc(String text, String pattern){
            List<Integer> result = new ArrayList<>();
            int[] patc = new int[26];
            int[] winc = new int[26];

            for (char ch : pattern.toCharArray()) {
                patc[ch - 'a']++;
            }
            int i = 0, j = 0;
            int k = pattern.length();
            while (j < text.length()) {
                winc[text.charAt(j) - 'a']++;
                if (j - i + 1 < k) {
                    j++;
                } else if (j - i + 1 == k) {
                    if (Arrays.equals(patc, winc)) {
                        result.add(i);
                    }
                    winc[text.charAt(i) - 'a']--;
                    i++;
                    j++;
                }
            }
            return result;
        }
    }