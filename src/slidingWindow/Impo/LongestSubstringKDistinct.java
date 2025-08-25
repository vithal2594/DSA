package slidingWindow.Impo;

import java.util.HashMap;

public class LongestSubstringKDistinct {

    public static void main(String[] args) {
        System.out.println(lengthofsubskdis("eceba", 2));  // Output: 3
        System.out.println(lengthofsubskdis("aa", 1));     // Output: 2
        System.out.println(lengthofsubskdis("aabbcc", 2));
        System.out.println(lengthofsubskdis("aabacbebebe", 3));


        System.out.println(kDistinctChars("eceba", 2));  // Output: 3
        System.out.println(kDistinctChars("aa", 1));     // Output: 2
        System.out.println(kDistinctChars("aabbcc", 2));
        System.out.println(kDistinctChars("aabacbebebe", 3));
    }// Output: 4    }
    public static int lengthofsubskdis(String s, int k){
        int i=0;
        int j=0;
        int n=s.length();
        int maxi=0;

        HashMap<Character,Integer> mp = new HashMap<>();
        while(j < n){
            mp.put(s.charAt(j),mp.getOrDefault(s.charAt(j),0)+1);
            while(mp.size() > k){
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                if(mp.get(s.charAt(i)) == 0){
                    mp.remove(s.charAt(i));
                }
                i++;
            }
            maxi= Math.max(maxi, j-i+1);
            j++;
        }
        return maxi;
    }
    public static int kDistinctChars(String str,int k) {
        int i = 0, j = 0;
        int max = -1;  // Initialize to -1 to handle case when no valid substring exists
        HashMap<Character, Integer> map = new HashMap<>();
        while (j < str.length()) {
            char ch = str.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            // If the number of unique characters is less than k, expand window
            if (map.size() < k) {
                j++;
            }
            // If the number of unique characters is exactly k, check max
            else if (map.size() == k) {
                max = Math.max(max, j - i + 1);
                j++;
            }
            // If more than k unique characters, shrink window from left
            else {
                while (map.size() > k) {
                    char leftChar = str.charAt(i);
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}
