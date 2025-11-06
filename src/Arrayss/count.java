package Arrayss;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class count {
    public static void main(String[] args) {
        System.out.println("enter the number size of array");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];

        for(int i=0; i<size; i++){
            arr[i]=sc.nextInt();
        }
        // System.out.println("Enter the number to be searched");
        //  int x=sc.nextInt();
        //  sc.close();

        //  System.out.println("after modifying "+ smallandlarge(arr));

        // System.out.println("enter the number of target sum");
        // int target = sc.nextInt();
        // System.out.println("total count of sum is " + doublesum(arr,target));

        // System.out.println("enter the number of target sum");
        // int target = sc.nextInt();
        // System.out.println("total count of sum is " + triplesum(arr,target));

        // System.out.println("unique number is " + findunique(arr));
        //  System.out.println(" largest element is " +largest(arr));
        //  System.out.println(" second largest element is " +seclargest(arr));
        System.out.println(" repeating value is " +repeatingvalue(arr));
        sc.close();
    }
    
    public static int countoccurence(int arr[], int x){
        int count=0;
        int n=arr.length;
        for(int i=0; i<n; i++){
            if(arr[i] == x){
                count++;
            }
        }
        return count;
    }
    public static int lastOccurence(int arr[], int s){
        int n=arr.length;
        for(int i=n-1; i>=0; i--){
            if(arr[i] == s){
                return i;
            }
        }
        return -1;
    }
    public static int strictlygreater(int arr[], int nu){
        int n=arr.length;
        int count=0;
        for(int i=0; i<n; i++){
            if(arr[i] > nu){
                count++;
            }
        }
        return count;
    }
    public static boolean issorted(int arr[]){
        int n=arr.length;
        for(int i=1; i<n; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }
    public static Vector<Integer> smallandlarge(int arr[]){
        int n=arr.length;
        Arrays.sort(arr);
        Vector<Integer> v = new Vector<Integer>(2);
        v.add(arr[0]);
        v.add(arr[n-1]);
        return v;
    }

    public static int doublesum(int arr[], int target){
        int count=0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
               if(arr[i]+arr[j] == target){
                count++;
               }
            }
        }
        return count;
    }

    public static int triplesum(int arr[], int target){
        int count=0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    if(arr[i] + arr[j]+ arr[k] == target){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int findunique(int arr[]){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] == arr[j]){
                    arr[i] = -1;
                    arr[j] = -1;
                }
            }
        }
            int ans=-1;
            for(int k=0; k<arr.length; k++){
               if(arr[k] > 0){
                ans=arr[k];
               
            }
        }
        return ans;
    }

    
    public static int largest(int arr[]){
        int maxi=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > maxi){
                maxi=arr[i];
            }
        }
        return maxi;
    }
    public static int seclargest(int arr[]){
        int maxi=largest(arr);
        for(int i=0; i<arr.length; i++){
            if(arr[i] == maxi){
                arr[i] = Integer.MIN_VALUE;
            }
        }
        int secmaxi = largest(arr);
        return secmaxi;
    }

    public static int repeatingvalue(int arr[]){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] == arr[i]){
                    return arr[i];
                }
            }
        }
        return -1;
    }
}
