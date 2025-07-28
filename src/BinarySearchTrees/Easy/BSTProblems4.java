package BinarySearchTrees.Easy;
import BinarySearchTrees.TreeNode;

import java.util.*;

public class BSTProblems4 {
    // Insert Node
    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);
        if (key < root.val) root.left = insert(root.left, key);
        else root.right = insert(root.right, key);
        return root;
    }

    // Floor: Largest value <= key
    public static int floor(TreeNode root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.val == key) return root.val;
            if (key < root.val) root = root.left;
            else {
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
    }

    // Ceil: Smallest value >= key
    public static int ceil(TreeNode root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.val == key) return root.val;
            if (key > root.val) root = root.right;
            else {
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }

    // Kth smallest (inorder traversal)
    static int count = 0;
    static int result = -1;
    public static int kthSmallest(TreeNode root, int k) {
        count = 0; result = -1;
        inorderKthSmallest(root, k);
        return result;
    }

    private static void inorderKthSmallest(TreeNode root, int k) {
        if (root == null) return;
        inorderKthSmallest(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inorderKthSmallest(root.right, k);
    }

    // Kth largest (reverse inorder)
    static int count2 = 0;
    static int result2 = -1;
    public static int kthLargest(TreeNode root, int k) {
        count2 = 0; result2 = -1;
        reverseInorder(root, k);
        return result2;
    }

    private static void reverseInorder(TreeNode root, int k) {
        if (root == null) return;
        reverseInorder(root.right, k);
        count2++;
        if (count2 == k) {
            result2 = root.val;
            return;
        }
        reverseInorder(root.left, k);
    }

    // Closest value to target
    public static int closest(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - closest)) {
                closest = root.val;
            }
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }

    // Range sum of BST
    public static int rangeSum(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSum(root.right, low, high);
        if (root.val > high) return rangeSum(root.left, low, high);
        return root.val + rangeSum(root.left, low, high) + rangeSum(root.right, low, high);
    }

    // Count nodes in range [L, R]
    public static int countInRange(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return countInRange(root.right, low, high);
        if (root.val > high) return countInRange(root.left, low, high);
        return 1 + countInRange(root.left, low, high) + countInRange(root.right, low, high);
    }

    // Two Sum IV (Leetcode 653)
    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private static boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    // Find modes (most frequent values)
    static Map<Integer, Integer> freqMap;
    public static List<Integer> findModes(TreeNode root) {
        freqMap = new HashMap<>();
        getFrequencies(root);
        int maxFreq = Collections.max(freqMap.values());
        List<Integer> modes = new ArrayList<>();
        for (int key : freqMap.keySet()) {
            if (freqMap.get(key) == maxFreq)
                modes.add(key);
        }
        return modes;
    }

    private static void getFrequencies(TreeNode root) {
        if (root == null) return;
        freqMap.put(root.val, freqMap.getOrDefault(root.val, 0) + 1);
        getFrequencies(root.left);
        getFrequencies(root.right);
    }

    // Inorder Print
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // MAIN METHOD
    public static void main(String[] args) {
        TreeNode root = null;
        int[] values = {20, 10, 30, 5, 15, 25, 35, 15, 25};  // Duplicate values to show mode

        for (int val : values) {
            root = insert(root, val);
        }

        System.out.print("Inorder Traversal: ");
        inorder(root); System.out.println();

        System.out.println("Floor of 12: " + floor(root, 12));           // 10
        System.out.println("Ceil of 12: " + ceil(root, 12));             // 15
        System.out.println("3rd Smallest: " + kthSmallest(root, 3));     // 15
        System.out.println("2nd Largest: " + kthLargest(root, 2));       // 30
        System.out.println("Closest to 17: " + closest(root, 17));       // 15
        System.out.println("Range Sum [10, 30]: " + rangeSum(root, 10, 30)); // 170
        System.out.println("Count in Range [10, 30]: " + countInRange(root, 10, 30)); // 7
        System.out.println("Pair with Sum 40 Exists? " + findTarget(root, 40)); // true (15+25)
        System.out.println("Modes in BST: " + findModes(root)); // [15, 25]
    }
}
