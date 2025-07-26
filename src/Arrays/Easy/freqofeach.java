package Arrays.Easy;

import java.util.HashMap;

public class freqofeach {
    public static void main(String[] args) {
        int [] arr= {1,2,3,1,2,3,4,2,3,3,3,4,5};
        HashMap<Integer, Integer> ans = eachfreq(arr);
        for(int key: ans.keySet()){
            System.out.println(key + " " + ans.get(key));
        }
    }
    public static HashMap<Integer, Integer> eachfreq(int[] arr){
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int num: arr){
            mp.put(num, mp.getOrDefault(num,0)+1);
        }
        return mp;
    }

}
