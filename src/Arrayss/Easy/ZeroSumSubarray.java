package Arrayss.Easy;
import java.util.HashSet;

public class ZeroSumSubarray {

    public static boolean hasZeroSumSubarray(int[] arr) {
        // Create a HashSet to store prefix sums
        HashSet<Integer> prefixSums = new HashSet<>();

        // Initialize current sum
        int currentSum = 0;

        // Add 0 to the set to handle subarrays starting from index 0
        prefixSums.add(0);

        // Iterate through the array
        for (int element : arr) {
            currentSum += element;

            // If the current sum is already in the set, a zero-sum subarray exists
            if (prefixSums.contains(currentSum)) {
                return true;
            }

            // Add the current sum to the set
            prefixSums.add(currentSum);
        }

        // No zero-sum subarray found
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, -3, 1, 6}; // Example: 2 + (-3) + 1 = 0
        int[] arr2 = {1, 2, 3, 4, 5};  // No zero-sum subarray
        int[] arr3 = {1, 0, 3};      // Example: 0 itself is a zero-sum subarray

        System.out.println("Array 1 has zero-sum subarray: " + hasZeroSumSubarray(arr1));
        System.out.println("Array 2 has zero-sum subarray: " + hasZeroSumSubarray(arr2));
        System.out.println("Array 3 has zero-sum subarray: " + hasZeroSumSubarray(arr3));
    }
}
