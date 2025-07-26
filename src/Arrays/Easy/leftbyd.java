package Arrays.Easy;

import java.util.Arrays;

public class leftbyd {
    public static void leftRotateByD(int[] arr, int d) {
        int n = arr.length;
        if (n == 0 || d % n == 0) return;
        d = d % n; // Handle d > n

        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 3;
        System.out.println("Original array: " + Arrays.toString(arr));
        leftRotateByD(arr, d);
        System.out.println("Array after left rotation by " + d + " positions: " + Arrays.toString(arr));
    }
}