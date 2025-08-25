package slidingWindow.Impo;

import java.util.HashMap;

public class LongestRepeatingCharReplace {
    public static void main(String[] args){
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
    public static int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int maxlen = 0;
        int maxfreq = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        while (j < n) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            maxfreq = Math.max(maxfreq, mp.get(s.charAt(j)));

            if ((j - i + 1) - maxfreq > k) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                if (mp.get(s.charAt(i)) == 0) {
                    mp.remove(s.charAt(i));
                }
                i++;
            }
            maxlen = Math.max(maxlen, j - i + 1);
            j++;
        }
        return maxlen;
    }
}
