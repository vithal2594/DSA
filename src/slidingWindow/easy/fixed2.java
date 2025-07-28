package slidingWindow.easy;
import java.util.*;

public class fixed2 {
    public static void main(String[] args) {
        System.out.println("1. Longest Subarray of 1s After Deleting One Element: " + longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println("2. Minimum Difference in Window Size K: " + minDifferenceWindow(new int[]{1, 5, 9, 12}, 2));
        System.out.println("3. K Closest Points to Origin: " + kClosest(new int[][]{{1, 3}, {-2, 2}}, 1));
        System.out.println("4. K Pairs with Smallest Sums: " + kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println("5. K Closest Elements: " + findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println("6. Maximum Average Subarray I: " + findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println("7. Max Frequency after K Increments: " + maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println("8. Prefix Common Array: " + Arrays.toString(findThePrefixCommonArray(new int[]{1, 3, 2}, new int[]{2, 1, 3})));
        System.out.println("9. Max Consecutive Coin Values: " + getMaximumConsecutive(new int[]{1, 1, 1, 4}));
    }

    public static int longestSubarray(int[] nums) {
        int i = 0, j = 0, max = 0, zeroCount = 0;
        while (j < nums.length) {
            if (nums[j] == 0) zeroCount++;
            while (zeroCount > 1) {
                if (nums[i++] == 0) zeroCount--;
            }
            max = Math.max(max, j - i);
            j++;
        }
        return max;
    }

    public static int minDifferenceWindow(int[] nums, int k) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }
        return minDiff;
    }

    public static List<int[]> kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
                Integer.compare(distance(b), distance(a)));
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }

    private static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]]));
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            res.add(Arrays.asList(nums1[top[0]], nums2[top[1]]));
            if (top[1] + 1 < nums2.length) pq.offer(new int[]{top[0], top[1] + 1});
        }
        return res;
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) left = mid + 1;
            else right = mid;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) res.add(arr[i]);
        return res;
    }

    public static double findMaxAverage(int[] nums, int k) {
        int i = 0, j = 0;
        double sum = 0, max = Double.NEGATIVE_INFINITY;
        while (j < nums.length) {
            sum += nums[j];
            if (j - i + 1 == k) {
                max = Math.max(max, sum / k);
                sum -= nums[i++];
            }
            j++;
        }
        return max;
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 0;
        long total = 0, res = 0;
        while (j < nums.length) {
            total += nums[j];
            while ((long) nums[j] * (j - i + 1) - total > k) total -= nums[i++];
            res = Math.max(res, j - i + 1);
            j++;
        }
        return (int) res;
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> seenA = new HashSet<>();
        Set<Integer> seenB = new HashSet<>();
        int[] res = new int[A.length];
        int common = 0;
        for (int i = 0; i < A.length; i++) {
            seenA.add(A[i]);
            seenB.add(B[i]);
            if (seenA.contains(B[i])) common++;
            if (seenB.contains(A[i])) common++;
            if (A[i] == B[i]) common--; // avoid double counting
            res[i] = common;
        }
        return res;
    }

    public static int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int res = 1;
        for (int coin : coins) {
            if (coin > res) break;
            res += coin;
        }
        return res;
    }
}
