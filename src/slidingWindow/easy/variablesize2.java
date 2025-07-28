package slidingWindow.easy;
import java.util.*;
public class variablesize2 {
    // Longest Substring with At Most Two Distinct Characters
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0, j = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while (map.size() > 2) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }

    // Count Substrings With Exactly K Distinct Characters
    public static int substrCountWithExactlyKDistinct(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    private static int atMostKDistinct(String s, int k) {
        int i = 0, j = 0, count = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }

    // Longest Continuous Subarray with Absolute Diff <= Limit
    public static int longestSubarrayAbsDiffLimit(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int i = 0, j = 0, maxLen = 0;

        while (j < nums.length) {
            while (!maxDeque.isEmpty() && nums[j] > maxDeque.peekLast()) maxDeque.pollLast();
            while (!minDeque.isEmpty() && nums[j] < minDeque.peekLast()) minDeque.pollLast();
            maxDeque.addLast(nums[j]);
            minDeque.addLast(nums[j]);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (nums[i] == maxDeque.peekFirst()) maxDeque.pollFirst();
                if (nums[i] == minDeque.peekFirst()) minDeque.pollFirst();
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }

    // Minimum Operations to Reduce X to 0
    public static int minOperationsToReduceX(int[] nums, int x) {
        int total = Arrays.stream(nums).sum();
        int target = total - x;
        if (target < 0) return -1;
        int sum = 0, i = 0, maxLen = -1;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum > target) {
                sum -= nums[i++];
            }
            if (sum == target) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }

    public static void main(String[] args) {
        // Call all the new functions here:
        System.out.println("Longest substring with at most 2 distinct: " + lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println("Substrings with exactly K distinct characters: " + substrCountWithExactlyKDistinct("pqpqs", 2));
        System.out.println("Longest subarray with abs diff <= limit: " + longestSubarrayAbsDiffLimit(new int[]{10,1,2,4,7,2}, 5));
        System.out.println("Minimum operations to reduce X to 0: " + minOperationsToReduceX(new int[]{1,1,4,2,3}, 5));
    }
}
