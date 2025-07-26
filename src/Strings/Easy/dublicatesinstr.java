package Strings.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class dublicatesinstr {
    public static void main(String[] args) {
        String s = "pwwkewe";
       System.out.println( finddubchar(s));
    }
    public static List<Character> finddubchar(String s){
        HashMap<Character,Integer> mp = new HashMap<>();
        for(char ch: s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        List<Character> ans = new ArrayList<>();
        for(char ch: mp.keySet()){
            if(mp.get(ch)>1){
                ans.add(ch);
            }
        }
        return ans;
    }
}
