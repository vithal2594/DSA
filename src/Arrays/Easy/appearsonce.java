package Arrays.Easy;

public class appearsonce {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("Single non-duplicate element: " + singleNonDuplicate(nums));
    }
    public static int singleNonDuplicate(int[] nums) {
        int res=0;
        for (int num : nums) {
            res = res ^ num;
        }
        return  res;
//        int res=0;
//        for(int num:nums){
//            res^=num;
//        }
//        return res;
    }
}
