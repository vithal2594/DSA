package Arrayss.Easy;

public class move0 {
    public static void main(String[] args){
        int [] arr ={0,1,2,3,4,0,1,3,0};
        movezeroend(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void movezeroend(int[] nums){
        int j=0;
        for(int i=0;i<nums.length; i++){
            if(nums[i] !=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
