package slidingWindow.easy;
import java.util.*;
public class variablesize {
    public static void main(String[] args) {
        System.out.println("Minimum Size Subarray Sum: " + minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println("Longest Substring Without Repeating Characters: " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Longest Substring with K Distinct Characters: " + longestKSubstrDistinctChars("eceba", 2));
        System.out.println("Permutation in String: " + checkInclusion("ab", "eidbaooo"));
        System.out.println("Minimum Window Substring: " + minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("Longest Repeating Character Replacement: " + characterReplacement("AABABBA", 1));
        System.out.println("Longest Substring with At Most K Repeating Characters: " + longestSubstringWithKRepeats("aaabbcc", 2));
        System.out.println("Number of Substrings Containing All Three Characters: " + numberOfSubstrings("abcabc"));
        System.out.println("Longest Subarray with Sum <= K: " + longestSubarraySumLessThanEqualK(new int[]{1,2,3,4,5}, 7));
        System.out.println("Max Consecutive Ones III: " + longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println("Maximum Erasure Value: " + maximumUniqueSubarray(new int[]{4,2,4,5,6}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static int longestKSubstrDistinctChars(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, max = -1;
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (map.size() < k) j++;
            else if (map.size() == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                while (map.size() > k) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return max;
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (char c : s1.toCharArray()) s1Count[c - 'a']++;
        for (int i = 0; i < s2.length(); i++) {
            s2Count[s2.charAt(i) - 'a']++;
            if (i >= s1.length()) s2Count[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(s1Count, s2Count)) return true;
        }
        return false;
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int left = 0, minLen = Integer.MAX_VALUE, count = 0, start = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) count++;
            }
            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char ch = s.charAt(left);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if (map.get(ch) > 0) count--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0, left = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left++) - 'A']--;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static int longestSubstringWithKRepeats(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, max = 0;
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }

    public static int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int res = 0, i = 0;
        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                res += s.length() - j;
                count[s.charAt(i++) - 'a']--;
            }
        }
        return res;
    }

    public static int longestSubarraySumLessThanEqualK(int[] nums, int k) {
        int i = 0, j = 0, sum = 0, maxLen = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum > k) sum -= nums[i++];
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }

    public static int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, max = 0, zeroCount = 0;
        while (j < nums.length) {
            if (nums[j] == 0) zeroCount++;
            while (zeroCount > k) {
                if (nums[i] == 0) zeroCount--;
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }

    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0, sum = 0, max = 0;
        while (j < nums.length) {
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i++];
            }
            set.add(nums[j]);
            sum += nums[j];
            max = Math.max(max, sum);
            j++;
        }
        return max;
    }
}
