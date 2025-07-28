package BinarySearchTrees.Easy;
import BinarySearchTrees.TreeNode;

import java.util.*;

public class BSTOperations2 {
    public static void main(String[] args) {
        // Create BST
        TreeNode root = null;
        root = insert(root, 20);
        root = insert(root, 10);
        root = insert(root, 30);
        root = insert(root, 5);
        root = insert(root, 15);
        root = insert(root, 25);
        root = insert(root, 35);

        System.out.println("Inorder Traversal:");
        inorder(root);
        System.out.println();

        System.out.println("Is Valid BST: " + isValidBST(root));
        System.out.println("Min Value: " + findMin(root).val);
        System.out.println("Max Value: " + findMax(root).val);

        TreeNode successor = inorderSuccessor(root, root.left); // successor of 10
        System.out.println("Inorder Successor of 10: " + (successor != null ? successor.val : "null"));

        TreeNode predecessor = inorderPredecessor(root, root.right); // predecessor of 30
        System.out.println("Inorder Predecessor of 30: " + (predecessor != null ? predecessor.val : "null"));

        TreeNode lca = lowestCommonAncestor(root, root.left.right, root.right.left); // LCA of 15 and 25
        System.out.println("LCA of 15 and 25: " + lca.val);

        TreeNode root2 = cloneTree(root);
        System.out.println("Are Trees Identical: " + isIdentical(root, root2));

        int[] sortedArr = {-10, -3, 0, 5, 9};
        TreeNode bstFromArray = sortedArrayToBST(sortedArr);
        System.out.println("BST from Sorted Array:");
        inorder(bstFromArray);

        TreeNode linkedListHead = bstToSortedLinkedList(root);
        System.out.println("\nBST to Sorted Linked List:");
        printLinkedList(linkedListHead);

        TreeNode dllHead = bstToDLL(root);
        System.out.println("\nBST to Doubly Linked List (Forward):");
        printDLL(dllHead);
    }

    // BST Insertion
    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);
        if (key < root.val) root.left = insert(root.left, key);
        else root.right = insert(root.right, key);
        return root;
    }

    // ✅ Inorder Traversal
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // ✅ Validate BST
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    // ✅ Find Min Value Node
    public static TreeNode findMin(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }

    // ✅ Find Max Value Node
    public static TreeNode findMax(TreeNode root) {
        while (root.right != null) root = root.right;
        return root;
    }

    // ✅ Inorder Successor
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (p.val < root.val) {
                successor = root;
                root = root.left;
            } else root = root.right;
        }
        return successor;
    }

    // ✅ Inorder Predecessor
    public static TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode predecessor = null;
        while (root != null) {
            if (p.val > root.val) {
                predecessor = root;
                root = root.right;
            } else root = root.left;
        }
        return predecessor;
    }

    // ✅ Lowest Common Ancestor (LCA)
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    // ✅ Check if two BSTs are identical
    public static boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }

    // Helper to clone a tree
    public static TreeNode cloneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = cloneTree(root.left);
        newNode.right = cloneTree(root.right);
        return newNode;
    }

    // ✅ Convert Sorted Array to BST
    public static TreeNode sortedArrayToBST(int[] arr) {
        return arrayToBST(arr, 0, arr.length - 1);
    }

    private static TreeNode arrayToBST(int[] arr, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = arrayToBST(arr, left, mid - 1);
        node.right = arrayToBST(arr, mid + 1, right);
        return node;
    }

    // ✅ Convert BST to Sorted Linked List (Right-Skewed Tree)
    public static TreeNode bstToSortedLinkedList(TreeNode root) {
        return bstToList(root, new TreeNode(-1)).right;
    }

    private static TreeNode bstToList(TreeNode root, TreeNode prev) {
        if (root == null) return prev;
        prev = bstToList(root.left, prev);
        prev.right = root;
        root.left = null;
        prev = root;
        return bstToList(root.right, prev);
    }

    public static void printLinkedList(TreeNode head) {
        TreeNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " → ");
            curr = curr.right;
        }
        System.out.println("null");
    }

    // ✅ Convert BST to Doubly Linked List
    static TreeNode prevDLL = null, headDLL = null;

    public static TreeNode bstToDLL(TreeNode root) {
        convertToDLL(root);
        return headDLL;
    }

    private static void convertToDLL(TreeNode root) {
        if (root == null) return;

        convertToDLL(root.left);

        if (prevDLL == null) headDLL = root;
        else {
            prevDLL.right = root;
            root.left = prevDLL;
        }
        prevDLL = root;

        convertToDLL(root.right);
    }

    public static void printDLL(TreeNode head) {
        TreeNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ⇄ ");
            curr = curr.right;
        }
        System.out.println("null");
    }
}