package BinarySearch.Easy;

public class AdvancedBinarySearch {
    // 1. Peak Element in an Array (any peak)
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // 2. Find Local Minimum in Unsorted Array
    public static int findLocalMinimum(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        if (arr[0] < arr[1]) return 0;
        if (arr[n - 1] < arr[n - 2]) return n - 1;
        int left = 1, right = n - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) return mid;
            else if (arr[mid - 1] < arr[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    // 3. Search in Bitonic Array
    public static int searchInBitonic(int[] arr, int target) {
        int peak = findPeakElement(arr);
        int idx = ascendingBinarySearch(arr, 0, peak, target);
        if (idx != -1) return idx;
        return descendingBinarySearch(arr, peak + 1, arr.length - 1, target);
    }

    private static int ascendingBinarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    private static int descendingBinarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // 4. Unique Element in Sorted Array
    public static int singleNonDuplicate(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) mid--;
            if (arr[mid] == arr[mid + 1]) left = mid + 2;
            else right = mid;
        }
        return arr[left];
    }

    // 5. Find Element in Infinite Sorted Array
    public static int findInInfiniteArray(int[] arr, int target) {
        int left = 0, right = 1;
        while (right < arr.length && arr[right] < target) {
            left = right;
            right *= 2;
        }
        right = Math.min(right, arr.length - 1);
        return ascendingBinarySearch(arr, left, right, target);
    }

    // 6. Find Pivot Index in Rotated Sorted Array
    public static int findPivotIndex(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // 7. Search in 2D Matrix (Leetcode 74)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = matrix[mid / n][mid % n];
            if (value == target) return true;
            else if (value < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    // 8. Search in Row-wise and Column-wise Sorted Matrix
    public static boolean searchInSortedMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }

    // 9. First and Last Position of Element in Sorted Array
    public static int[] firstAndLastPosition(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);
        return new int[]{first, last};
    }

    public static int firstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }

    // 10. Minimum Element in Rotated Sorted Array
    public static int findMinElement(int[] arr) {
        return arr[findPivotIndex(arr)];
    }

    // === MAIN to test all ===
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int[] sortedDup = {1, 1, 2, 2, 3, 3, 4, 8, 8};
        int[] infinite = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50};
        int[] rotated = {5, 6, 7, 1, 2, 3, 4};
        int[][] matrix = {
                {1, 3, 5},
                {7, 9, 11},
                {13, 15, 17}
        };

        System.out.println("Peak Index: " + findPeakElement(arr));
        System.out.println("Local Minimum Index: " + findLocalMinimum(arr));
        System.out.println("Search 4 in Bitonic: " + searchInBitonic(arr, 4));
        System.out.println("Unique Element: " + singleNonDuplicate(sortedDup));
        System.out.println("Find 30 in Infinite Array: " + findInInfiniteArray(infinite, 30));
        System.out.println("Pivot Index in Rotated: " + findPivotIndex(rotated));
        System.out.println("Search 9 in 2D Matrix: " + searchMatrix(matrix, 9));
        System.out.println("Search 11 in Row-Col Sorted: " + searchInSortedMatrix(matrix, 11));
        int[] fl = firstAndLastPosition(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println("First and Last Position of 8: [" + fl[0] + ", " + fl[1] + "]");
        System.out.println("Min Element in Rotated: " + findMinElement(rotated));
    }

}
