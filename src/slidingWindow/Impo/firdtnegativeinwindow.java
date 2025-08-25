package slidingWindow.Impo;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class firdtnegativeinwindow {
    public static void main(String[] args){
        int[] arr = {12, -1, -7, 8, 15, 30, 16, 28};
        int k = 3;
        List<Integer> result = firstnegativeinwndo(arr, k);
        System.out.println(result); // Output: [-1, -1, -7, 0, 0, 0]
    }
    public static List<Integer> firstnegativeinwndo(int[]nums, int k){
        int n=nums.length;
        int i=0;
        int j=0;
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        while(j < n){
            if(nums[j] < 0) dq.add(nums[j]);
            if(j-i+1 < k) {
                j++;
            }else if(j-i+1 == k){
                if(dq.isEmpty()){
                    ans.add(0);
                }else {
                    ans.add(dq.peek());
                }
                if(!dq.isEmpty() && nums[i] == dq.peek()){
                    dq.poll();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
