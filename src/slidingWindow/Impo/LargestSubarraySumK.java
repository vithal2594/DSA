package slidingWindow.Impo;
//Given an array nums and an integer k, return the length of the longest subarray that sums to exactly k.
//Input: nums = [1, -1, 5, -2, 3], k = 3
//Output: 4
//Explanation: The subarray [1, -1, 5, -2] sums to 3 and has length 4.

import java.util.HashMap;

public class LargestSubarraySumK {
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(bothnegativepositivemaxSubArrayLen(nums, k)); // Output: 4

        int[] nums1 = {1, 2, 1, 1, 1};
        int k1 = 3;
        System.out.println(largestSubarray(nums1, k1));
    }
    public static int largestSubarray(int[] arr, int k){
        int max = 0, sum = 0, i = 0, j = 0;
        while(j < arr.length){
            sum += arr[j];
            if(sum < k){
                j++;
            }
            else if(sum == k){
                max = Math.max(max, j - i + 1);
                j++;
            }
            else{
                while(sum > k){
                    sum -= arr[i];
                    i++;
                    if(sum == k){
                        max = Math.max(max, j - i + 1);
                    }
                }
                j++;
            }
        }
        return max;
    }
    public static int bothnegativepositivemaxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int prefixSum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (i < n) {
            prefixSum += nums[i];
            if (prefixSum == k) {
                maxLen = i + 1;
            }
            if (map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }
            // Only store the first occurrence to get the longest length
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
            i++;
        }
        return maxLen;
    }
}
//        public static int maxSubArrayLen(int[] nums, int k) {
//            Map<Integer, Integer> prefixMap = new HashMap<>();
//            int sum = 0;
//            int maxLen = 0;
//
//            for (int j = 0; j < nums.length; j++) {
//                sum += nums[j];
//
//                if (sum == k) {
//                    maxLen = j + 1;
//                }
//
//                if (prefixMap.containsKey(sum - k)) {
//                    maxLen = Math.max(maxLen, j - prefixMap.get(sum - k));
//                }
//
//                // Only store the first occurrence of this sum
//                if (!prefixMap.containsKey(sum)) {
//                    prefixMap.put(sum, j);
//                }
//            }
//
//            return maxLen;
//        }
//}
