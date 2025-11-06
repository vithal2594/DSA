package Arrayss.Easy;

public class missingnumb {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Missing number (Summation): " + missingNumber(arr)); // Output: 3
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length+1;
        int sum = (n * (n + 1)) / 2;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
        }
        return sum - sum2;
    }
}
