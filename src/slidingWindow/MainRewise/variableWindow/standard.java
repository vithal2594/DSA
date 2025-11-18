package slidingWindow.MainRewise.variableWindow;

import java.util.Arrays;

public class standard {
  public static void main(String[] args) {
      int[] arr={4,2,2,6,1};
	  int k=8;
	  System.out.println(longestSubarraySumLEK(arr,k));
	  System.out.println(longestSubarraySumLEK1(arr,k));
      int[] arr2 = {2,3,1,2,4,3};
      int target2 = 7;
      System.out.println(minSubarrayWithSumGEK(arr2, target2));
      int[] arr3={1,12,-5,-6,50,3};
      int k3=4;
      System.out.println(maxSumSubarrayAtLeastKnegaposvalues(arr3, k3));
      int[] arr4={1,4,2,10,23,3,1,0,20};
      int[]arrr4={1, 4, 2, 10, 23, 3, 1, 0, 20, -30, -5};
      int k4=4;
      System.out.println(minSumSubarrayAtLeastKnegativevalues(arr4, k4));
      System.out.println(minSumSubarrayAtLeastKnegativevalues(arrr4, k4));
      System.out.println(maximumAveragesubarrayofsizeK(arr3, k3));
      int[] arr6 = {1, 2, 3, 4, 5};
      int target6 = 11;
      System.out.println(Arrays.toString(subarraySumClosestToTargetK(arr6, target6)));

  }
    public static int longestSubarraySumLEK(int[] arr, int K) {
        int n = arr.length;
        int i = 0, j = 0;
        int sum = 0;
        int maxLength = 0;
        while (j < n) {
            sum += arr[j];
            if (sum <= K) {
                // valid window, update length
                maxLength = Math.max(maxLength, j - i + 1);
                j++; // expand window
            } else { // sum > K
                // shrink window from left
                sum -= arr[i];
                i++;
                j++; // move window forward
            }
        }
        return maxLength;
    }
    public static int longestSubarraySumLEK1(int[] arr, int k) {
       int i=0;
       int j=0;
       int n=arr.length;
       int sum=0;
       int maxLength=0;
       while(j<n){
           sum+=arr[j];
           while(sum> k && i<=j){
               sum-=arr[i];
               i++;
           }
           maxLength=Math.max(maxLength,j-i+1);
           j++;
       }
       return maxLength;
    }
    public static int minSubarrayWithSumGEK(int[] arr, int K) {
    int n = arr.length;
    int i = 0, j = 0;
    int sum = 0;
    int minLength = Integer.MAX_VALUE;

    while (j < n) {
        sum += arr[j];
        if (sum < K) {
            j++;
        } else if (sum == K) {
            minLength = Math.min(minLength, j - i + 1);
            j++;
        } else if (sum > K) {
            while (sum > K && i <= j) {
                sum -= arr[i];
                i++;
            }
            if (sum >= K) {
                minLength = Math.min(minLength, j - i + 1);
            }
            j++;
        }
    }
    return  minLength;
}  
    public static int maxSumSubarrayAtLeastKnegaposvalues(int[] arr, int k){
        int n=arr.length;
        int i=0;
        int j=0;
        int sum=0;
        int maxsum=Integer.MIN_VALUE;
        while(j<n){
            sum+=arr[j];
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                maxsum=Math.max(sum,maxsum);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return maxsum;
    }
    public static int minSumSubarrayAtLeastKnegativevalues(int[] arr, int k){
        int n=arr.length;
        int i=0;
        int j=0;
        int sum=0;
        int minsum=Integer.MAX_VALUE;
        while(j<n){
            sum+=arr[j];
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                minsum=Math.min(sum,minsum);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return minsum;
    }
    public static double maximumAveragesubarrayofsizeK(int[] arr, int k){
        int n=arr.length;
        int i=0;
        int j=0;
        double sum=0;
        double maxsum=Integer.MIN_VALUE;
        while(j<n){
            sum+=arr[j];
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                maxsum=Math.max(sum/k,maxsum);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return maxsum;
    }
    public static int[] subarraySumClosestToTargetK(int[] arr, int target) {
    int n = arr.length;
    int i = 0;
    int j = 0;
    int sum = 0;
    int minDiff = Integer.MAX_VALUE;
    int start = 0, end = 0;
    while (j < n) {
        sum += arr[j];
        // Always check diff after adding new element
        int diff = Math.abs(sum - target);
        if (diff < minDiff) {
            minDiff = diff;
            start = i;
            end = j;
        }
        if (sum < target) {
            // Need a larger sum → expand window
            j++;
        } else if (sum > target) {
            // Too large → shrink from left
            while (sum > target && i <= j) {
                sum -= arr[i];
                i++;
                // Recheck diff after shrinking
                diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    start = i;
                    end = j;
                }
            }
            j++;
        } else if (sum == target) {
            // Perfect match → return immediately
            start = i;
            end = j;
            break;
        }
    }
    // Build the result subarray
    int[] ans = new int[end - start + 1];
    for (int k = start, idx = 0; k <= end; k++, idx++) {
        ans[idx] = arr[k];
    }
    return ans;
}
    







}
