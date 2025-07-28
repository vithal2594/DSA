package slidingWindow.easy;

public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8, 2, 9, 1};
        int k = 3;
        int result = maxSumSubarray(arr, k);
        System.out.println("Maximum sum of subarray of size " + k + " is: " + result);
    }
    public static int maxSumSubarray(int[] arr, int k) {
        int i = 0, j = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        while (j < arr.length) {
            sum += arr[j];

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }
}
