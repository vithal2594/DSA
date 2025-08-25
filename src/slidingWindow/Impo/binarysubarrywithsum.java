package slidingWindow.Impo;
//Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
//A subarray is a contiguous part of the array.
//        Example 1:
//Input: nums = [1,0,1,0,1], goal = 2
//Output: 4
//Explanation: The 4 subarrays are bolded and underlined below:
//        [1,0,1,0,1]
//        [1,0,1,0,1]
//        [1,0,1,0,1]
//        [1,0,1,0,1]
//Example 2:
//Input: nums = [0,0,0,0,0], goal = 0
//Output: 15
public class binarysubarrywithsum {
    public static void main(String[] args){
        int[] nums1 = {1, 0, 1, 0, 1};
        int goal1 = 2;
        System.out.println(subarrayofk(nums1, goal1)); // Output: 4

        int[] nums2 = {0, 0, 0, 0, 0};
        int goal2 = 0;
        System.out.println(subarrayofk(nums2, goal2)); // Output: 15
    }

    public static int subarrayofk(int[] nums, int goal){
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public static int atMost(int[] nums, int k){
        if (k < 0) return 0;  // important fix

        int i = 0;
        int j = 0;
        int n = nums.length;
        int count = 0;
        int sum = 0;

        while (j < n){
            sum += nums[j];

            while (sum > k){
                sum -= nums[i];
                i++;
            }

            count += j - i + 1;
            j++;
        }

        return count;
    }
}