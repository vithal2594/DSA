package BinarySearch.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvancedBinarySearch1 {
    public static int countRotations(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[high]) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    // 2. Median of Two Sorted Arrays
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length, y = nums2.length;
        int low = 0, high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                if ((x + y) % 2 == 0)
                    return ((double) Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                else
                    return Math.max(maxX, maxY);
            } else if (maxX > minY) high = partitionX - 1;
            else low = partitionX + 1;
        }
        throw new IllegalArgumentException();
    }

    // 3. Find K Closest Elements to X
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) left = mid + 1;
            else right = mid;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) result.add(arr[i]);
        return result;
    }

    // 4. Kth Smallest Element in Sorted Matrix
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int[] row : matrix) {
                count += upperBound(row, mid);
            }
            if (count < k) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private static int upperBound(int[] row, int x) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (row[mid] <= x) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    // 5. Count Occurrences of a Number in Sorted Matrix
    public static int countOccurrences(int[][] matrix, int target) {
        int count = 0;
        for (int[] row : matrix) {
            int left = 0, right = row.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (row[mid] == target) {
                    int i = mid;
                    while (i >= 0 && row[i] == target) { count++; i--; }
                    i = mid + 1;
                    while (i < row.length && row[i] == target) { count++; i++; }
                    break;
                } else if (row[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return count;
    }

    // 6. Search Insert Position
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    // 7. Find Peak Element II (2D Array)
    public static int[] findPeakGrid(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int left = 0, right = cols - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int maxRow = 0;
            for (int i = 1; i < rows; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) maxRow = i;
            }
            boolean leftIsBig = mid - 1 >= 0 && mat[maxRow][mid - 1] > mat[maxRow][mid];
            boolean rightIsBig = mid + 1 < cols && mat[maxRow][mid + 1] > mat[maxRow][mid];

            if (!leftIsBig && !rightIsBig) return new int[]{maxRow, mid};
            else if (rightIsBig) left = mid + 1;
            else right = mid - 1;
        }
        return new int[]{-1, -1};
    }

    // 8. Check if Array is Sorted and Rotated
    public static boolean checkSortedAndRotated(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int next = (i + 1) % nums.length;
            if (nums[i] > nums[next]) count++;
        }
        return count <= 1;
    }

    // 9. Maximum in Bitonic Array
    public static int findMaximumInBitonic(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < arr[mid + 1]) low = mid + 1;
            else high = mid;
        }
        return arr[low];
    }

    // 10. Find Position of an Element in Infinite Sorted Array
    public static int searchInfiniteArray(int[] arr, int target) {
        int low = 0, high = 1;
        while (high < arr.length && arr[high] < target) {
            low = high;
            high *= 2;
            if (high >= arr.length) high = arr.length - 1;
        }
        return binarySearch(arr, low, high, target);
    }

    private static int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] rotated = {4, 5, 6, 1, 2, 3};
        System.out.println("Rotations: " + countRotations(rotated));

        int[] a = {1, 3}, b = {2};
        System.out.println("Median: " + findMedianSortedArrays(a, b));

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Closest Elements: " + findClosestElements(arr, 4, 3));

        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println("Kth Smallest: " + kthSmallest(matrix, 8));

        System.out.println("Occurrences of 13: " + countOccurrences(matrix, 13));

        System.out.println("Insert Pos: " + searchInsert(arr, 6));

        int[][] mat = {{10, 20, 15}, {21, 30, 14}, {7, 16, 32}};
        System.out.println("Peak in Grid: " + Arrays.toString(findPeakGrid(mat)));

        int[] nums = {3, 4, 5, 1, 2};
        System.out.println("Is Sorted and Rotated: " + checkSortedAndRotated(nums));

        int[] bitonic = {1, 3, 8, 12, 4, 2};
        System.out.println("Max in Bitonic: " + findMaximumInBitonic(bitonic));

        int[] infinite = new int[1000];
        for (int i = 0; i < infinite.length; i++) infinite[i] = i * 2;
        System.out.println("Found in Infinite Array at: " + searchInfiniteArray(infinite, 16));
    }
}
