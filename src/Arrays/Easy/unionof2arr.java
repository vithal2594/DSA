package Arrays.Easy;

import java.util.*;

public class unionof2arr {
    public static void main(String[] args) {
        Integer[] arr1 = {12, 13, 5, 16, 9, 19};
        Integer[] arr2 = {16, 2, 60, 9, 8, 5};
        union(arr1, arr2);
    }
    public static void union(Integer[] arr1, Integer[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        //add first array to set
        set.addAll(Arrays.asList(arr1));

        //add second array to set
        set.addAll(Arrays.asList(arr2));

        //convert to array from set
        Integer[] union = {};
        union = set.toArray(union);

        //print the result
        System.out.println("Union of two arrays is: " + Arrays.toString(union));
    }
}
