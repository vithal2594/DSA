package slidingWindow.Impo;

import java.util.HashMap;

public class noofSubstringsWithABC {
    public static void main(String[] args){
        System.out.println(numberOfSubstrings("abcabc")); // 10
        System.out.println(numberOfSubstrings("aaacb"));  // 3
        System.out.println(numberOfSubstrings("abc"));
    }
    public static int numberOfSubstrings(String s){
       int i=0;
       int j=0;
       int n=s.length();
       int count =0;
        HashMap<Character,Integer> mp = new HashMap<>();

        while(j < n){
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j),0)+1);
            while(mp.size() == 3){
               count = count+n-j;

               mp.put(s.charAt(i),mp.get(s.charAt(i)) -1);
               if(mp.get(s.charAt(i)) == 0){
                   mp.remove(s.charAt(i));
               }
               i++;
            }
            j++;
        }
        return count;
    }
}
