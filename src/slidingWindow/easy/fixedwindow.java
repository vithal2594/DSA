package slidingWindow.easy;

import java.util.*;

public class fixedwindow {
    public static void main(String[] args) {
        // Call each function with test cases
        System.out.println("Max Sum Subarray of Size K: " + maxSumSubarray(new int[]{1,2,3,4,5}, 3));
        System.out.println("First Negatives: " + firstNegativeInWindow(new int[]{12, -1, -7, 8, -15, 30, 16, 28}, 3));
        System.out.println("Average of Subarrays: " + averageOfSubarrays(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5));
        System.out.println("Sliding Window Maximum: " + slidingWindowMaximum(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        System.out.println("Max Vowels: " + maxVowels("abciiidef", 3));
        System.out.println("Anagram Occurrences: " + countAnagramOccurrences("forxxorfxdofr", "for"));
        System.out.println("All Anagrams: " + findAllAnagrams("cbaebabacd", "abc"));
        System.out.println("K-length Substrings No Repeat: " + kLengthSubstringsNoRepeat("havefunonleetcode", 5));
        System.out.println("Max Points from Cards: " + maxPointsFromCards(new int[]{1,2,3,4,5,6,1}, 3));
        System.out.println("Min Swaps to Bring K Together: " + minSwaps(new int[]{2,1,5,6,3}, 3));
        System.out.println("Count Binary Substrings: " + countBinarySubstrings("00110011"));
        System.out.println("Product < K: " + subarraysWithProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println("Max Sum Circular Subarray of Size K: " + maxCircularSum(new int[]{5,2,1,6}, 2));
    }

    public static int maxSumSubarray(int[] arr, int k) {
        int i = 0, j = 0, sum = 0, max = Integer.MIN_VALUE;
        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 < k) j++;
            else if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum -= arr[i];
                i++; j++;
            }
        }
        return max;
    }

    public static List<Integer> firstNegativeInWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        List<Integer> negatives = new ArrayList<>();

        while (j < arr.length) {
            if (arr[j] < 0) negatives.add(arr[j]);
            if (j - i + 1 < k) j++;
            else {
                result.add(negatives.isEmpty() ? 0 : negatives.get(0));
                if (!negatives.isEmpty() && arr[i] == negatives.get(0)) negatives.remove(0);
                i++; j++;
            }
        }
        return result;
    }

    public static List<Double> averageOfSubarrays(int[] arr, int k) {
        List<Double> res = new ArrayList<>();
        int i = 0, j = 0;
        double sum = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 < k) j++;
            else {
                res.add(sum / k);
                sum -= arr[i];
                i++; j++;
            }
        }
        return res;
    }

    public static List<Integer> slidingWindowMaximum(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (j < nums.length) {
            while (!list.isEmpty() && list.get(list.size() - 1) < nums[j]) {
                list.remove(list.size() - 1);
            }
            list.add(nums[j]);
            if (j - i + 1 < k) j++;
            else {
                result.add(list.get(0));
                if (nums[i] == list.get(0)) list.remove(0);
                i++; j++;
            }
        }
        return result;
    }

    public static int maxVowels(String s, int k) {
        int max = 0, count = 0, i = 0, j = 0;
        Set<Character> vowels = Set.of('a','e','i','o','u');
        while (j < s.length()) {
            if (vowels.contains(s.charAt(j))) count++;
            if (j - i + 1 < k) j++;
            else {
                max = Math.max(max, count);
                if (vowels.contains(s.charAt(i))) count--;
                i++; j++;
            }
        }
        return max;
    }

    public static List<Integer> countAnagramOccurrences(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] patFreq = new int[26];
        int[] winFreq = new int[26];

        for (char c : p.toCharArray()) patFreq[c - 'a']++;

        int i = 0, j = 0;
        while (j < s.length()) {
            winFreq[s.charAt(j) - 'a']++;
            if (j - i + 1 < p.length()) j++;
            else {
                if (Arrays.equals(patFreq, winFreq)) result.add(i);
                winFreq[s.charAt(i) - 'a']--;
                i++; j++;
            }
        }
        return result;
    }

    public static List<Integer> findAllAnagrams(String s, String p) {
        return countAnagramOccurrences(s, p);
    }

    public static int kLengthSubstringsNoRepeat(String s, int k) {
        int i = 0, j = 0, count = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            if (j - i + 1 == k) {
                count++;
                set.remove(s.charAt(i));
                i++;
            }
            j++;
        }
        return count;
    }

    public static int maxPointsFromCards(int[] cards, int k) {
        int total = 0;
        for (int i = 0; i < k; i++) total += cards[i];
        int max = total, n = cards.length;
        for (int i = 0; i < k; i++) {
            total = total - cards[k - 1 - i] + cards[n - 1 - i];
            max = Math.max(max, total);
        }
        return max;
    }

    public static int minSwaps(int[] arr, int k) {
        int good = 0;
        for (int num : arr) if (num <= k) good++;

        int bad = 0;
        for (int i = 0; i < good; i++) if (arr[i] > k) bad++;

        int minSwaps = bad;
        for (int i = 0, j = good; j < arr.length; j++, i++) {
            if (arr[i] > k) bad--;
            if (arr[j] > k) bad++;
            minSwaps = Math.min(minSwaps, bad);
        }
        return minSwaps;
    }

    public static int countBinarySubstrings(String s) {
        int prev = 0, curr = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) curr++;
            else {
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        return count + Math.min(prev, curr);
    }

    public static int subarraysWithProductLessThanK(int[] arr, int k) {
        if (k <= 1) return 0;
        int prod = 1, i = 0, count = 0;
        for (int j = 0; j < arr.length; j++) {
            prod *= arr[j];
            while (prod >= k) prod /= arr[i++];
            count += j - i + 1;
        }
        return count;
    }

    public static int maxCircularSum(int[] arr, int k) {
        int n = arr.length;
        int[] newArr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) newArr[i] = arr[i % n];

        int sum = 0, max = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while (j < k + n - 1) {
            sum += newArr[j];
            if (j - i + 1 < k) j++;
            else {
                max = Math.max(max, sum);
                sum -= newArr[i++];
                j++;
            }
        }
        return max;
    }
}
