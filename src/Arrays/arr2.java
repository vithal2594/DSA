package Arrays;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class arr2 {
    public static int[] swapvalue(int a, int b){
        int temp = a;
        a = b;
        b = temp;

        return new int[] {a,b};
    }

    public static Vector<Integer> reverseArray(int arr[]){
         Vector<Integer>ans = new Vector<>();
         for(int i=arr.length-1; i>=0; i--){
            ans.add(arr[i]);
         }
         return ans;
    }

    public static void reversearr(int arr[]){
       int i=0, j=arr.length-1;
       while(i<j){
        swapvalue1(arr,i, j);
        i++;
        j--;
       }
    }

    public static void swapvalue1(int arr[] ,int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void rotate(int arr[],int i, int j){
        while(i < j){
            int temp= arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }

    public static void reveresebyK(int arr[] ,int k){
        int n=arr.length;
        k%=n;
        // rotate(arr, 0, n-1);
        // rotate(arr,0,k-1);
        // rotate(arr,k,n-1);

        rotate(arr, 0, n-k-1);
        rotate(arr, n-k, n-1);
        rotate(arr, 0, n-1);
    }

    public static boolean isPresent(int arr[],int searched){
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int num:arr){
            mp.put(num, mp.getOrDefault(num, 0 )+1);
        }
        return mp.containsKey(searched);

     }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     System.out.println("enter the number size of array");
     int size = sc.nextInt();
     int arr[] = new int[size];
     for(int i=0; i<size; i++){
         arr[i]=sc.nextInt();
     }
     
     System.out.println("enter the number to be searched:");
     int searched=sc.nextInt();

     boolean result =isPresent(arr,searched);
     if(result){
        System.out.println(searched + " is present in the array.");
    } else {
        System.out.println(searched + " is not present in the array.");
    }
    //  for(int i=0; i<size; i++){
    //      System.out.println(arr[i]);
    //  }
    //  System.out.println("Enter the number to rotate by numbers");
    //  int k=sc.nextInt();
    //  System.out.println("Before rotating value"+Arrays.toString(arr));
    //  reveresebyK(arr,k);
    //  System.out.println("After rotating values: " + Arrays.toString(arr));
    //  sc.nextLine();
     // System.out.println("after reversed array"+reverseArray(arr));
     //  reversearr(arr);
     //  System.out.println("after reversed array: " + java.util.Arrays.toString(arr));
     //    int a=sc.nextInt();
     //    int b=sc.nextInt();
     //    System.out.println("Before Swapping value"+a+ "and " + b);
     //    int[] result = swapvalue(a, b);
     //    System.out.println("After Swapping values: " + result[0] + " and " + result[1]);
        sc.close();
     }
}
