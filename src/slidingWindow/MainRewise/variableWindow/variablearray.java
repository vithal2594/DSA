package slidingWindow.MainRewise.variableWindow;

public class variablearray {
  public static void main(String[] args) {
      int[] arr={4,2,2,6,1};
	  int k=8;
	  System.out.println(longestSubarraySumLEK(arr,k));
	  System.out.println(longestSubarraySumLEK1(arr,k));
      int[] arr2 = {2,3,1,2,4,3};
      int target2 = 7;
      System.out.println(minSubarrayWithSumGEK(arr2, target2)); // Output: 2
 	  int[] arr3={10,5,2,7,1,9};
	  int k3=15;
	  System.out.println(longestsubarraywithsumexactlyK(arr3,k3));
      int[] arr4 = {10, 5, 2, 6};
      int k4 = 100;
      System.out.println(countSubarraysWithProductLessThanK(arr4, k4));
      int[] arr5 = {1, 2, -3, 4, 5, 6, -1, 2};
      System.out.println(longestsubarraywithPositivevalues(arr5));
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
    public static int longestsubarraywithsumexactlyK(int[] arr, int k) {
        int i=0;
        int j=0;
        int n=arr.length;
        int sum=0;
        int maxlength=0;
        while(j<n){
            sum+=arr[j];
            if(sum<k){
                j++;
            }else if(sum == k){
                maxlength=Math.max(maxlength,j-i+1);
                j++;
            }else if(sum > k){
                while(sum > k && i<=j){
                    sum-=arr[i];
                    i++;
                }
                if(sum == k){
                    maxlength=Math.max(maxlength,j-i+1);
                }
                j++;
            }
        }
        return maxlength;
    }
    public static int countSubarraysWithProductLessThanK(int[] arr, int k) {
        int n=arr.length;
        int i=0;
        int j=0;
        int count=0;
        int product=1;
        
        while(j<n){
            product*=arr[j];
            while(product>=k){
                product/=arr[i];
                i++;
            }
            count+=(j-i+1);
            j++;
        }
        return count;
    }
    public static int longestsubarraywithPositivevalues(int[] arr){
        int i=0;
        int j=0;
        int count=0;
        int maxcount=Integer.MIN_VALUE;
        int n=arr.length;
        while(j<n){
            if(arr[j]> 0){
                count++;
                maxcount=Math.max(maxcount,count);
            }else{
                count=0;
            }
            j++;
        }
        return maxcount;
    }
    
    
}
