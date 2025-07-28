package slidingWindow.easy;
import java.util.*;

public class VariableSizeWindow3 {
    public static void main(String[] args) {
        System.out.println("1. Longest Substring After At Most One Deletion: " + longestSubstringAfterOneDeletion("abcab"));
        System.out.println("2. Min Ops to Make Array Continuous: " + minOperationsToMakeContinuous(new int[]{1, 2, 3, 5}));
        System.out.println("3. Longest Ordered Vowel Substring: " + longestVowelOrderedSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
        System.out.println("4. Count of Subarrays With All Unique: " + countSubarraysWithUniqueElements(new int[]{1, 2, 1, 3, 4}));
        System.out.println("5. Longest Balanced Binary String: " + longestBalancedSubstring("0011"));
        System.out.println("6. Good Substrings of Length 3: " + countGoodSubstrings("xyzzaz"));
        System.out.println("7. Max Subarray Sum Circular: " + maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println("8. Min Recolors to Get K Black Blocks: " + minRecolors("WBBWWBBWBW", 7));
        System.out.println("9. Subarrays With Median K: " + countSubarraysWithMedianK(new int[]{3, 2, 1, 4, 5}, 4));
        System.out.println("10. Min Ops to Make Array K-Increasing: " + minOperationsKIncreasing(new int[]{5, 4, 3, 2, 1}, 1));
    }

    public static int longestSubstringAfterOneDeletion(String s) {
        int i = 0, j = 0, maxLen = 0, del = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                del++;
            }
            set.add(s.charAt(j));
            while (del > 1) {
                if (s.charAt(i) == s.charAt(j)) del--;
                set.remove(s.charAt(i++));
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }

    public static int minOperationsToMakeContinuous(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int[] arr = set.stream().sorted().mapToInt(x -> x).toArray();
        int n = nums.length, res = n;
        for (int i = 0, j = 0; j < arr.length; j++) {
            while (arr[j] - arr[i] >= n) i++;
            res = Math.min(res, n - (j - i + 1));
        }
        return res;
    }

    public static int longestVowelOrderedSubstring(String s) {
        String vowels = "aeiou";
        int i = 0, maxLen = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'a') {
                int j = i;
                int idx = 0;
                while (j < s.length() && idx < 5 && s.charAt(j) == vowels.charAt(idx)) {
                    while (j < s.length() && s.charAt(j) == vowels.charAt(idx)) j++;
                    idx++;
                }
                if (idx == 5) maxLen = Math.max(maxLen, j - i);
            }
            i++;
        }
        return maxLen;
    }

    public static int countSubarraysWithUniqueElements(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        int i = 0, j = 0, count = 0;
        while (j < arr.length) {
            freq.put(arr[j], freq.getOrDefault(arr[j], 0) + 1);
            while (freq.get(arr[j]) > 1) {
                freq.put(arr[i], freq.get(arr[i]) - 1);
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }

    public static int longestBalancedSubstring(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int count0 = 0, count1 = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '0') count0++;
                else count1++;
                if (count0 == count1) maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    public static int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i + 1) != s.charAt(i + 2)) {
                count++;
            }
        }
        return count;
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = nums[0], minSum = nums[0], curMax = 0, curMin = 0;
        for (int n : nums) {
            curMax = Math.max(curMax + n, n);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + n, n);
            minSum = Math.min(minSum, curMin);
            total += n;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    public static int minRecolors(String blocks, int k) {
        int minOps = Integer.MAX_VALUE, i = 0, countW = 0;
        while (i < k) if (blocks.charAt(i++) == 'W') countW++;
        minOps = countW;
        for (int j = i; j < blocks.length(); j++) {
            if (blocks.charAt(j) == 'W') countW++;
            if (blocks.charAt(j - k) == 'W') countW--;
            minOps = Math.min(minOps, countW);
        }
        return minOps;
    }

    public static int countSubarraysWithMedianK(int[] nums, int k) {
        int n = nums.length, idx = -1;
        for (int i = 0; i < n; i++) if (nums[i] == k) idx = i;
        Map<Integer, Integer> map = new HashMap<>();
        int bal = 0, res = 0;
        map.put(0, 1);
        for (int i = idx - 1; i >= 0; i--) {
            bal += nums[i] < k ? 1 : -1;
            map.put(bal, map.getOrDefault(bal, 0) + 1);
        }
        bal = 0;
        for (int i = idx; i < n; i++) {
            bal += nums[i] > k ? 1 : -1;
            res += map.getOrDefault(-bal, 0) + map.getOrDefault(1 - bal, 0);
        }
        return res;
    }

    public static int minOperationsKIncreasing(int[] arr, int k) {
        int n = arr.length, res = 0;
        for (int i = 0; i < k; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < n; j += k) temp.add(arr[j]);
            res += temp.size() - lengthOfLIS(temp);
        }
        return res;
    }

    private static int lengthOfLIS(List<Integer> nums) {
        List<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            int i = Collections.binarySearch(dp, num);
            if (i < 0) i = -(i + 1);
            if (i == dp.size()) dp.add(num);
            else dp.set(i, num);
        }
        return dp.size();
    }
}
