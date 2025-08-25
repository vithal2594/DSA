package slidingWindow.Impo;
//992. Subarrays with K Different Integers
//Given an integer array nums and an integer k, return the number of good subarrays of nums.
// A good array is an array where the number of different integers in that array is exactly k.
// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
// A subarray is a contiguous part of an array.

import java.util.HashMap;

public class subarrwithkdiffint {
    public static void main(String[] args){
        int[] nums1 = {1, 2, 1, 2, 3};
        int k1 = 2;
        System.out.println(subarraysWithKDistinct(nums1, k1)); // Output: 7

        int[] nums2 = {1, 2, 1, 3, 4};
        int k2 = 3;
        System.out.println(subarraysWithKDistinct(nums2, k2)); // Output: 3
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    public static int atMost(int[] nums, int k) {
        int i = 0, j = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            count += (j - i + 1);
            j++;
        }

        return count;
    }
}
