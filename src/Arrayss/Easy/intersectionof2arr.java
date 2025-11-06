package Arrayss.Easy;

import java.util.HashSet;

public class intersectionof2arr {
    public static void main(String[] args) {
        int[] arr1 = {12, 13, 5, 16, 9, 19};
        int[] arr2 = {16, 2, 60, 9, 8, 5};
        intersection(arr1, arr2);
    }
    public static void intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            if (set.contains(num)) {
                System.out.print(num + " ");
            }
        }

    }
}
