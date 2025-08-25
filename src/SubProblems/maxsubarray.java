package SubProblems;
// LeetCode Problem 53: https://leetcode.com/problems/maximum-subarray
// Given an integer array nums, find the contiguous subarray (containing at least one number)
// which has the largest sum, and return its sum.
public class maxsubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result);
        int result1 = maxSubArray1(nums);
        System.out.println("Maximum Subarray Sum: " + result1);

    }
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // If currentMax is negative, start new subarray at current element
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    public static int maxSubArray1(int[] nums) {
        int left = 0, right = 0;
        int maxSum = nums[0];
        int currentSum = 0;

        while (right < nums.length) {
            currentSum += nums[right];

            // Update max if current window is better
            maxSum = Math.max(maxSum, currentSum);

            // If sum becomes negative, reset the window
            while (currentSum < 0 && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            right++;
        }

        return maxSum;
    }
}
