package BinarySearchTrees.Easy;

import BinarySearchTrees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTOperations {
    public static void main(String[] args) {
        TreeNode root = null;
        int[] values = {50, 30, 70, 20, 40, 60, 80};

        // Insert nodes
        for (int val : values) {
            root = insert(root, val);
        }

        // Search
        int key = 60;
        TreeNode searchResult = search(root, key);
        System.out.println("Search " + key + ": " + (searchResult != null ? "Found" : "Not Found"));

        // Inorder
        System.out.print("Inorder Recursive: ");
        inorderRecursive(root);
        System.out.println();

        System.out.print("Inorder Iterative: ");
        inorderIterative(root);
        System.out.println();

        // Preorder
        System.out.print("Preorder Recursive: ");
        preorderRecursive(root);
        System.out.println();

        System.out.print("Preorder Iterative: ");
        preorderIterative(root);
        System.out.println();

        // Postorder
        System.out.print("Postorder Recursive: ");
        postorderRecursive(root);
        System.out.println();

        System.out.print("Postorder Iterative: ");
        postorderIterative(root);
        System.out.println();

        // Level Order
        System.out.print("Level Order (BFS): ");
        levelOrder(root);
        System.out.println();

        // Height
        System.out.println("Height of BST: " + height(root));

        // Total Nodes
        System.out.println("Total Nodes in BST: " + countNodes(root));

        // Leaf Nodes
        System.out.println("Leaf Nodes in BST: " + countLeafNodes(root));
    }

    // BST Insert
    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);
        if (key < root.val) root.left = insert(root.left, key);
        else if (key > root.val) root.right = insert(root.right, key);
        return root;
    }

    // Search
    public static TreeNode search(TreeNode root, int key) {
        if (root == null || root.val == key) return root;
        if (key < root.val) return search(root.left, key);
        return search(root.right, key);
    }

    // Inorder Recursive
    public static void inorderRecursive(TreeNode root) {
        if (root == null) return;
        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }

    // Inorder Iterative
    public static void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    // Preorder Recursive
    public static void preorderRecursive(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    // Preorder Iterative
    public static void preorderIterative(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    // Postorder Recursive
    public static void postorderRecursive(TreeNode root) {
        if (root == null) return;
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.val + " ");
    }

    // Postorder Iterative
    public static void postorderIterative(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    // Level Order (BFS)
    public static void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }

    // Height
    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Count All Nodes
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Count Leaf Nodes
    public static int countLeafNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }
}
