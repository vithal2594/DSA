package BinarySearch.Easy;

public class AdvancedBinarySearchProblems {
    // 1. Find Square Root (Floating Point Precision)
    public static double squareRoot(double n, int precision) {
        double low = 0, high = n, mid = 0;
        while (high - low > 1e-6) {
            mid = (low + high) / 2;
            if (mid * mid < n)
                low = mid;
            else
                high = mid;
        }
        return Math.round(mid * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    // 2. Nth Root of a Number using Binary Search
    public static double nthRoot(int n, int m, int precision) {
        double low = 1, high = m;
        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            if (Math.pow(mid, n) < m) low = mid;
            else high = mid;
        }
        return Math.round(low * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    // 3. Divide Two Integers without Using Division
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean negative = (dividend < 0) ^ (divisor < 0);
        long dvd = Math.abs((long) dividend), dvs = Math.abs((long) divisor), res = 0;

        while (dvd >= dvs) {
            long temp = dvs, multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            res += multiple;
        }

        return negative ? -(int) res : (int) res;
    }

    // 4. Cube Root using Binary Search
    public static double cubeRoot(double n, int precision) {
        double low = 0, high = n, mid;
        while (high - low > 1e-6) {
            mid = (low + high) / 2;
            if (mid * mid * mid < n)
                low = mid;
            else
                high = mid;
        }
        return Math.round(low * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    // 5. Allocate Books Problem
    public static int allocateBooks(int[] pages, int students) {
        int low = 0, high = 0;
        for (int page : pages) {
            high += page;
            low = Math.max(low, page);
        }

        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(pages, students, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean isPossible(int[] pages, int students, int limit) {
        int count = 1, sum = 0;
        for (int page : pages) {
            if (sum + page > limit) {
                count++;
                sum = page;
            } else {
                sum += page;
            }
        }
        return count <= students;
    }

    // 6. Maximum Length of Ribbon Cuts
    public static int maxRibbonLength(int[] ribbons, int k) {
        int low = 1, high = 0;
        for (int ribbon : ribbons) high = Math.max(high, ribbon);

        int res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canCut(ribbons, k, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private static boolean canCut(int[] ribbons, int k, int length) {
        int count = 0;
        for (int ribbon : ribbons) count += ribbon / length;
        return count >= k;
    }

    // 7. Maximum Distance Between Gas Stations
    public static double maxDistanceGasStations(int[] stations, int k) {
        double low = 0, high = 0;
        for (int i = 1; i < stations.length; i++)
            high = Math.max(high, stations[i] - stations[i - 1]);

        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            if (canPlace(stations, k, mid)) high = mid;
            else low = mid;
        }
        return low;
    }

    private static boolean canPlace(int[] stations, int k, double dist) {
        int count = 0;
        for (int i = 1; i < stations.length; i++) {
            count += (int) ((stations[i] - stations[i - 1]) / dist);
        }
        return count <= k;
    }

    // 8. Split Array Largest Sum
    public static int splitArray(int[] nums, int m) {
        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isValidSplit(nums, m, mid)) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    private static boolean isValidSplit(int[] nums, int m, int maxSum) {
        int count = 1, sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > maxSum) {
                count++;
                sum = num;
            }
        }
        return count <= m;
    }

    // 9. Find the Smallest Positive Number Missing from an Array
    public static int missingPositive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    // 10. Maximum Number of Removable Characters (Leetcode 1898)
    public static int maxRemovals(String s, String p, int[] removable) {
        int low = 0, high = removable.length, res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isSubsequence(s, p, removable, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private static boolean isSubsequence(String s, String p, int[] removable, int k) {
        boolean[] removed = new boolean[s.length()];
        for (int i = 0; i < k; i++) removed[removable[i]] = true;

        int j = 0;
        for (int i = 0; i < s.length() && j < p.length(); i++) {
            if (!removed[i] && s.charAt(i) == p.charAt(j)) j++;
        }
        return j == p.length();
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("Square Root of 10: " + squareRoot(10, 6));
        System.out.println("Cube Root of 27: " + cubeRoot(27, 6));
        System.out.println("5th Root of 243: " + nthRoot(5, 243, 6));
        System.out.println("Divide 10 by 3: " + divide(10, 3));

        int[] pages = {12, 34, 67, 90};
        System.out.println("Allocate Books: " + allocateBooks(pages, 2));

        int[] ribbons = {9, 7, 5};
        System.out.println("Max Ribbon Length for 4 cuts: " + maxRibbonLength(ribbons, 4));

        int[] stations = {1, 2, 3, 4, 5, 6};
        System.out.println("Max Distance Between Gas Stations: " + maxDistanceGasStations(stations, 2));

        int[] nums = {7, 2, 5, 10, 8};
        System.out.println("Split Array Largest Sum: " + splitArray(nums, 2));

        int[] arr = {3, 4, -1, 1};
        System.out.println("Missing Positive Number: " + missingPositive(arr));

        String s = "abcacb", p = "ab";
        int[] removable = {3, 1, 0};
        System.out.println("Max Removals: " + maxRemovals(s, p, removable));
    }
}
