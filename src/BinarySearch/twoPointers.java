package Prac.BinarySearch;

import java.util.Scanner;

public class twoPointers {


    public static void printArray(int arr[]){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int arr[], int i, int j){
        int temp=arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortzerosandones(int arr[]){
        int i=0;
        int j=arr.length-1;
        while(i < j){
            if(arr[i] == 1 && arr[j] == 0){
                swap(arr, i, j);
                i++;
                j--;
            }
            if(arr[i] == 0){
                i++;
            }
            if(arr[j] == 1){
                j--;
            }
        }
    }

    public static void sortevenandodd(int arr[]){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            if(arr[i] % 2 ==1 && arr[j] % 2 == 0){
                swap(arr,i,j);
                i++;
                j--;
            }
            if(arr[i] %2 == 0){
                i++;
            }
            if(arr[j] % 2 == 1){
                j--;
            }
        }
    }

    public static void sortandsquare(int arr[]){
        int i=0;
        int j=arr.length-1;
        int k=arr.length-1;
        while(i <= j){
           int left = arr[i] * arr[i];
           int right = arr[j] * arr[j];

           if(left > right){
               arr[k] = left;
               i++;
           }
           else{
               arr[k] = right;
               j--;
           }
           k--;
        }
    }

    public static int[] prefixsum(int arr[]){
        for(int i=1; i<arr.length; i++){
            arr[i]=arr[i]+arr[i-1];
        }
        return arr;
    }
    public static int totalsum(int arr[]){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }

    public static boolean equalsumpartition(int arr[]){
        int sum=totalsum(arr);
        int leftsum=0;
        for(int i=0; i<arr.length; i++){
            leftsum=leftsum+arr[i];
            int rightsum=sum-leftsum;
            if(leftsum == rightsum){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
       Scanner sc = new  Scanner(System.in);
       System.out.println("Enter the size of array");
       int size = sc.nextInt();
       int arr[] = new int[size];
       for(int i=0; i<size; i++){
           arr[i] = sc.nextInt();
       }
      System.out.println("Euqal partion possible : " + equalsumpartition(arr));
    //    sortzerosandones(arr);
    //    sortevenandodd(arr);
    // sortandsquare(arr);
    //    prefixsum(arr);
    //    printArray(arr);
       sc.close();
    }
}
