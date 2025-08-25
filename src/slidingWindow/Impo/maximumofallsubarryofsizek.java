package slidingWindow.Impo;

import java.util.*;

public class maximumofallsubarryofsizek {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxslidongwndow(nums, k)));
    }
    public static int[] maxslidongwndow(int[] nums,int k){
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (j < n) {
            // Remove smaller elements from the back of deque
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[j]) {
                dq.pollLast();
            }
            dq.offerLast(j);

            // Remove elements out of window from the front
            if (dq.peekFirst() < i) {
                dq.pollFirst();
            }
            // If window size >= k, store max
            if (j - i + 1 >= k) {
                result.add(nums[dq.peekFirst()]);
                i++; // shrink window from the left
            }
            j++;
        }
        // Convert result list to array
        int[] res = new int[result.size()];
        for (int m = 0; m < result.size(); m++) {
            res[m] = result.get(m);
        }
        return res;
    }
}
