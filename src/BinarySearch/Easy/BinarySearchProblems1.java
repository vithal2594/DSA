package BinarySearch.Easy;

public class BinarySearchProblems1 {
    // 1. Binary Search on a Sorted Array
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // 2. First Occurrence
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

    // 3. Last Occurrence
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

    // 4. Count of a Number in Sorted Array
    public static int countOccurrences(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        if (first == -1) return 0;
        int last = lastOccurrence(arr, target);
        return last - first + 1;
    }

    // 5. Search in a Rotated Sorted Array
    public static int searchInRotated(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;

            if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (arr[mid] < target && target <= arr[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    // 6. Search in a Rotated Sorted Array with Duplicates
    public static boolean searchWithDuplicates(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;

            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++;
                right--;
            } else if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (arr[mid] < target && target <= arr[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }

    // 7. Find Index of Minimum in Rotated Sorted Array
    public static int findMinIndex(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // 8. Floor of a Number
    public static int floor(int[] arr, int target) {
        int left = 0, right = arr.length - 1, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                res = arr[mid];
                left = mid + 1;
            } else right = mid - 1;
        }
        return res;
    }

    // 9. Ceil of a Number
    public static int ceil(int[] arr, int target) {
        int left = 0, right = arr.length - 1, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                res = arr[mid];
                right = mid - 1;
            } else left = mid + 1;
        }
        return res;
    }

    // 10. Square Root of a Number using Binary Search (floor value)
    public static int squareRoot(int n) {
        if (n < 2) return n;
        int left = 1, right = n / 2, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid;
            if (sq == n) return mid;
            if (sq < n) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    // === MAIN method to test all ===
    public static void main(String[] args) {
        int[] sorted = {1, 2, 4, 4, 4, 5, 6, 7, 9};
        int[] rotated = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("Binary Search for 5: " + binarySearch(sorted, 5));
        System.out.println("First occurrence of 4: " + firstOccurrence(sorted, 4));
        System.out.println("Last occurrence of 4: " + lastOccurrence(sorted, 4));
        System.out.println("Count of 4: " + countOccurrences(sorted, 4));
        System.out.println("Search 0 in rotated: " + searchInRotated(rotated, 0));
        System.out.println("Search 3 in rotated with duplicates: " + searchWithDuplicates(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println("Index of min in rotated: " + findMinIndex(rotated));
        System.out.println("Floor of 8: " + floor(sorted, 8));
        System.out.println("Ceil of 8: " + ceil(sorted, 8));
        System.out.println("Square root of 26: " + squareRoot(26));
    }
}
