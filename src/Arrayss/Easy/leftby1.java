package Arrayss.Easy;

import java.util.Arrays;

public class leftby1 {
    public static void main(String[] args){
        int [] arr ={1,2,3,4,5};
        System.out.println("Original array: " + Arrays.toString(arr));
        leftrotby1(arr);
        System.out.println("Array after left rotation by one: " + Arrays.toString(arr));
    }
    public static void leftrotby1(int[] arr){
        int f=arr[0];
        for(int i=0; i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = f;
    }
}
