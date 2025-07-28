package BinarySearchTrees.Easy;
import BinarySearchTrees.TreeNode;

import java.util.*;

public class AdvancedBSTProblems {
    // 1. Insert into BST (Iterative)
    public static TreeNode insertIterative(TreeNode root, int key) {
        TreeNode node = new TreeNode(key);
        if (root == null) return node;
        TreeNode current = root;
        while (true) {
            if (key < current.val) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }
        return root;
    }

    // 2. Delete Min Node
    public static TreeNode deleteMin(TreeNode root) {
        if (root == null) return null;
        if (root.left == null) return root.right;
        TreeNode parent = null, curr = root;
        while (curr.left != null) {
            parent = curr;
            curr = curr.left;
        }
        parent.left = curr.right;
        return root;
    }

    // 3. Delete Max Node
    public static TreeNode deleteMax(TreeNode root) {
        if (root == null) return null;
        if (root.right == null) return root.left;
        TreeNode parent = null, curr = root;
        while (curr.right != null) {
            parent = curr;
            curr = curr.right;
        }
        parent.right = curr.left;
        return root;
    }

    // 4. Trim BST to range [L, R]
    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    // 5. Convert BST to Greater Sum Tree (Leetcode 1038)
    static int sum = 0;
    public static TreeNode bstToGst(TreeNode root) {
        sum = 0;
        reverseInorderGst(root);
        return root;
    }

    private static void reverseInorderGst(TreeNode root) {
        if (root == null) return;
        reverseInorderGst(root.right);
        sum += root.val;
        root.val = sum;
        reverseInorderGst(root.left);
    }

    // 6. Recover BST with 2 swapped nodes (Leetcode 99)
    static TreeNode first, second, prev;
    public static void recoverBST(TreeNode root) {
        first = second = prev = null;
        recoverInorder(root);
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private static void recoverInorder(TreeNode root) {
        if (root == null) return;
        recoverInorder(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        recoverInorder(root.right);
    }

    // 7. Merge Two BSTs
    public static TreeNode mergeBSTs(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        List<Integer> merged = mergeLists(list1, list2);
        return sortedArrayToBST(merged, 0, merged.size() - 1);
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private static List<Integer> mergeLists(List<Integer> a, List<Integer> b) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) merged.add(a.get(i++));
            else merged.add(b.get(j++));
        }
        while (i < a.size()) merged.add(a.get(i++));
        while (j < b.size()) merged.add(b.get(j++));
        return merged;
    }

    private static TreeNode sortedArrayToBST(List<Integer> arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr.get(mid));
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);
        return node;
    }

    // 8. Construct BST from Preorder
    static int idx = 0;
    public static TreeNode bstFromPreorder(int[] preorder, int bound) {
        if (idx == preorder.length || preorder[idx] > bound) return null;
        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, bound);
        return root;
    }

    // 9. Construct BST from Postorder
    static int postIdx;
    public static TreeNode bstFromPostorder(int[] postorder, int lower, int upper) {
        if (postIdx < 0 || postorder[postIdx] < lower || postorder[postIdx] > upper)
            return null;
        TreeNode root = new TreeNode(postorder[postIdx--]);
        root.right = bstFromPostorder(postorder, root.val, upper);
        root.left = bstFromPostorder(postorder, lower, root.val);
        return root;
    }

    // 10. Construct BST from Level Order
    public static TreeNode bstFromLevelOrder(int[] arr) {
        if (arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            insertIterative(root, arr[i]);
        }
        return root;
    }

    // Print Inorder for checking
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        System.out.println("---- Insert Iteratively ----");
        TreeNode root = null;
        for (int val : new int[]{10, 5, 15, 3, 7, 12, 18}) {
            root = insertIterative(root, val);
        }
        printInorder(root);
        System.out.println();

        System.out.println("---- Delete Min Node ----");
        root = deleteMin(root);
        printInorder(root);
        System.out.println();

        System.out.println("---- Delete Max Node ----");
        root = deleteMax(root);
        printInorder(root);
        System.out.println();

        System.out.println("---- Trim BST [6, 13] ----");
        TreeNode trimmed = trimBST(root, 6, 13);
        printInorder(trimmed);
        System.out.println();

        System.out.println("---- BST to Greater Sum Tree ----");
        TreeNode gstRoot = bstToGst(insertIterative(null, 4));
        gstRoot = insertIterative(gstRoot, 1);
        gstRoot = insertIterative(gstRoot, 6);
        bstToGst(gstRoot);
        printInorder(gstRoot);
        System.out.println();

        System.out.println("---- Recover BST ----");
        TreeNode wrong = new TreeNode(3);
        wrong.left = new TreeNode(1);
        wrong.right = new TreeNode(4);
        wrong.right.left = new TreeNode(2); // 2 and 3 are swapped
        recoverBST(wrong);
        printInorder(wrong);
        System.out.println();

        System.out.println("---- Merge Two BSTs ----");
        TreeNode bst1 = insertIterative(null, 1);
        bst1 = insertIterative(bst1, 3);
        TreeNode bst2 = insertIterative(null, 2);
        bst2 = insertIterative(bst2, 4);
        TreeNode merged = mergeBSTs(bst1, bst2);
        printInorder(merged);
        System.out.println();

        System.out.println("---- BST from Preorder ----");
        int[] pre = {8, 5, 1, 7, 10, 12};
        idx = 0;
        TreeNode fromPre = bstFromPreorder(pre, Integer.MAX_VALUE);
        printInorder(fromPre);
        System.out.println();

        System.out.println("---- BST from Postorder ----");
        int[] post = {1, 7, 5, 12, 10, 8};
        postIdx = post.length - 1;
        TreeNode fromPost = bstFromPostorder(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
        printInorder(fromPost);
        System.out.println();

        System.out.println("---- BST from Level Order ----");
        int[] level = {10, 5, 15, 3, 7, 12, 18};
        TreeNode fromLevel = bstFromLevelOrder(level);
        printInorder(fromLevel);
        System.out.println();
    }
}
