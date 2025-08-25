package slidingWindow.Impo;

public class maxcons3 {
    public static void main(String[] args){
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;
        System.out.println(maxconsones(nums1, k1)); // Output: 6
    }
    public static int maxconsones(int[] nums , int k){
        int i=0;
        int j=0;
        int zeros=0;
        int maxle=0;
        int n=nums.length;

        while(j < n){
           if(nums[j] == 0) zeros++;
           while(zeros > k){
               if(nums[i] == 0){
                   zeros--;
               }
               i++;
           }
           maxle = Math.max(maxle,j-i+1);
           j++;
        }
        return maxle;
    }
}
