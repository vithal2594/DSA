package stacks.Easy;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class StackMonotonicProblems {

    // 1. Next Greater Element I – LeetCode 496
    public static int[] nextGreaterElementI(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nge = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nge.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nge.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    // 2. Next Greater Element II – LeetCode 503 (circular)
    public static int[] nextGreaterElementII(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                ans[stack.pop()] = num;
            }
            if (i < n) stack.push(i);
        }
        return ans;
    }

    // 3. Next Smaller Element
    public static int[] nextSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }

    // 4. Previous Greater Element (to left)
    public static int[] prevGreater(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }

    // 5. Previous Smaller Element (to left)
    public static int[] prevSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }

    // 6. Nearest Greater to Left / Right – also gives index distance
    public static int[] nearestGreaterRightIndexDiff(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                diff[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) diff[stack.pop()] = -1;
        return diff;
    }

    // 7. Next Greater Frequency Element (frequency-based)
    public static int[] nextGreaterFreq(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : nums) freq.put(v, freq.getOrDefault(v, 0) + 1);
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && freq.get(nums[stack.peek()]) <= freq.get(nums[i])) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i);
        }
        return ans;
    }

    // 8. Next Greater Node in Linked List – LeetCode 1019
    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        int n = vals.size();
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && vals.get(stack.peek()) < vals.get(i)) {
                ans[stack.pop()] = vals.get(i);
            }
            stack.push(i);
        }
        return ans;
    }

    // 🚀 Utility to print arrays
    private static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        // 1
        System.out.print("NGE I: ");
        printArr(nextGreaterElementI(new int[]{4,1,2}, new int[]{1,3,4,2}));
        // 2
        System.out.print("NGE II: ");
        printArr(nextGreaterElementII(new int[]{1,2,1}));
        // 3
        System.out.print("Next Smaller: ");
        printArr(nextSmaller(new int[]{4,8,5,2}));
        // 4
        System.out.print("Prev Greater: ");
        printArr(prevGreater(new int[]{4,8,5,2}));
        // 5
        System.out.print("Prev Smaller: ");
        printArr(prevSmaller(new int[]{4,8,5,2}));
        // 6
        System.out.print("Nearest Greater Right Index Diff: ");
        printArr(nearestGreaterRightIndexDiff(new int[]{4,1,2,5,3}));
        // 7
        System.out.print("Next Greater Frequency: ");
        printArr(nextGreaterFreq(new int[]{1,1,2,3,4,2,1}));
        // 8
        ListNode h = new ListNode(2);
        h.next = new ListNode(1);
        h.next.next = new ListNode(5);
        System.out.print("Next Larger Node in LL: ");
        printArr(nextLargerNodes(h));
    }
}

