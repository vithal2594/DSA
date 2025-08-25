package slidingWindow.Impo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class longestsubstringnonrepeating {
    public static void main(String[] args){
        String str = "abcabcbb";
         System.out.println( longestsub(str));
        System.out.println( lengthOfLongestSubstring(str));
    }
    public static int longestsub(String s){
        int i=0;
        int j=0;
        int n=s.length();
        int maxle=0;
        HashSet<Character> st = new HashSet<>();
        while(j < n){
            if(!st.contains(s.charAt(j))){
                st.add(s.charAt(j));
                maxle = Math.max(maxle,j-i+1);
                j++;
            }else{
                st.remove(s.charAt(i));
                i++;
            }
        }
        return maxle;
    }
    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            if(map.size() == j - i + 1){
                max = Math.max(max, j - i + 1);
                j++;
            }
            else if(map.size() < j - i + 1){
                while(map.size() < j - i + 1){
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}
