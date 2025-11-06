package Arrayss.interview;
import java.util.Arrays;
import java.util.stream.IntStream;

public class mergeandKthelement {
    public static void main(String[] args) {
    int[] arr1 = {2, 3, 5, 8};
    int[] arr2 = {10, 12, 14, 16, 18, 20};
    int k = 5;

    System.out.println("The " + k + "th element is: " + kthelementfrom2sortedarra(arr1, arr2, k));

    int[] merged = merge2sortedarray(arr1, arr2);

    System.out.println("Merged Array: " + Arrays.toString(merged));

        int[] arr3 = {5, 2, 9, 1};
        int[] arr4 = {8, 2, 3, 5};

        merge2unsortedarray(arr3, arr4);
        merge2unsortedarray(arr1, arr2);


    }
public static int kthelementfrom2sortedarra(int[] arr1, int[] arr2, int k){
    int n1=arr1.length;
    int n2=arr2.length;
    int i=0;
    int j=0;
    int count=0;

    while(i<n1 && j < n2){
        int val;
        if(arr1[i] < arr2[j] ){
            val=arr1[i++];
        }else{
            val=arr2[j++];
        }
        count++;
        if(count == k) return val;
    }
    while(i < n1){
        count++;
        if(count == k) return arr1[i];
        i++;
    }
    while(j < n2){
        count++;
        if(count == k) return arr2[j];
        j++;
    }
    return -1;
  }
  public static int[] merge2sortedarray(int[] arr1, int[] arr2){
        int n1=arr1.length;
        int n2=arr2.length;
        int i=0;
        int j=0;
        int []merged= new int [n1+n2];
        int k=0;
        while(i< n1 && j < n2){
            if(arr1[i] <= arr2[j]){
                merged[k++]=arr1[i++];
            }else{
                merged[k++]=arr2[j++];
            }
        }
        while(i<n1){
            merged[k++]=arr1[i++];
        }
      while ((j < n2)) {

          merged[k++]=arr2[j++];
      }
      return merged;
  }
    public static void merge2unsortedarray(int[] arr1, int[] arr2){
        int[] result = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).sorted().toArray();
        System.out.println("Merged + Sorted (with duplicates): " + Arrays.toString(result));

    }

}
