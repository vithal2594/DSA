package stacks.easy1;

import java.util.Stack;
import java.util.Arrays;

public class nextandprev {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        int[] arr = {4, 8, 5, 2, 25};
        int[] result1 = nge(arr);
        int[] result2 = nse(arr);
        int[] result3 = pge(arr);
        int[] result4 = pse(arr);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
        System.out.println(Arrays.toString(result4));

    }

    public static int[] nge(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                int index = st.pop();
                result[index] = arr[i];
            }
            st.push(i);
        }
        return result;
    }

    public static int[] nse(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int index = st.pop();
                result[index] = arr[i];
            }
            st.push(i);
        }
        return result;
    }

    public static int[] pge(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                int index = st.pop();
                result[index] = arr[i];
            }
            st.push(i);
        }
        return result;
    }

    public static int[] pse(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int index = st.pop();
                result[index] = arr[i];
            }
            st.push(i);
        }
        return result;
    }
}
