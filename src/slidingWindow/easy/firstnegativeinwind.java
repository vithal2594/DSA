package slidingWindow.easy;

import java.util.ArrayList;
import java.util.List;

public class firstnegativeinwind {
    public static List<Integer> firstNegativeInSubArray(int[] arr, int k) {
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();  // To store final answers
        List<Integer> st = new ArrayList<>();      // To track negatives in window

        while (j < arr.length) {
            // If the current element is negative, add to tracking list
            if (arr[j] < 0) {
                st.add(arr[j]);
            }
            // Expand the window until it reaches size k
            if (j - i + 1 < k) {
                j++;
            }
            // Once window size is k
            else if (j - i + 1 == k) {
                // If no negative numbers in the window, add 0
                if (st.isEmpty()) {
                    result.add(0);
                } else {
                    // Add the first negative number to result
                    result.add(st.get(0));
                    // If the element going out is the same as the first in list, remove it
                    if (arr[i] == st.get(0)) {
                        st.remove(0);
                    }
                }
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        List<Integer> output = firstNegativeInSubArray(arr, k);
        System.out.println("First negative numbers in each window of size " + k + ":");
        for (int num : output) {
            System.out.print(num + " ");
        }
    }
}
