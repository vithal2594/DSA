package Arrays.Easy;

import java.util.HashSet;

public class isdublicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("Contains duplicate: " + containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
