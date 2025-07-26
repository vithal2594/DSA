package Arrays.Easy;

import java.util.HashMap;

public class contpaiofsum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int target = 5;
        System.out.println("Count of pairs with sum 3: " + countPairs(nums, target));
    }
    public static int countPairs(int[] nums, int target) {
       int count=0;
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int num: nums){
        map.put(num, map.getOrDefault(num,0)+1);
       }
       for(int num: nums){
        if(map.containsKey(target-num)){
            count+=map.get(target-num);
            if(target-num == num){
                count--;
            }
        }
       }
       return count/2;
    }
}
