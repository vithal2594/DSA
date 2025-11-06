package slidingWindow.easy;

public class minsumsubarray {
    public static void main(String[] args){
        int[] arr = {2, 5, 1, 8, 2, 9, 1};
        int k = 3;
        int result = minsubsubarraya(arr, k);
        System.out.println("minimum sum of subarray of size " + k + " is: " + result);
    }
    public static int minsubsubarraya(int[] arr, int k){
        int i=0,j=0;
        int sum=0;
        int minsum=Integer.MAX_VALUE;

        while(j< arr.length){
            sum+=arr[j];
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                minsum =Math.min(minsum,sum);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return minsum;
    }
}
