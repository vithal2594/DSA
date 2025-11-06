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
    

    
}
