package Arrayss.Easy;
import java.util.*;

public class removedub {
    public static void main(String[] args){
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};
        System.out.println("Original array: " + Arrays.toString(arr));
        int n = removedup(arr);
        System.out.print("Array after removing duplicates: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static int removedup(int[] arr){
        int j=0;
        for(int i=1; i<arr.length;i++){
            if(arr[i] != arr[j]){
                j++;
                arr[j] = arr[i];
            }
        }
        return j+1;
    }
}
