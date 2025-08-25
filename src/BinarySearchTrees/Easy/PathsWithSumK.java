package BinarySearchTrees.Easy;

import BinarySearchTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Print all the paths in a binary tree whose sum is k, where a path may start and end at any node.
public class PathsWithSumK {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(2);

        int k = 5;
        printKSumPaths(root, k);
    }

    public static void printKSumPaths(TreeNode root, int k) {
        List<Integer> path = new ArrayList<>();
        helper(root, k, path);
    }

    private static void helper(TreeNode node, int k, List<Integer> path) {
        if (node == null) return;

        // Add current node to the path
        path.add(node.val);

        // Traverse left and right
        helper(node.left, k, path);
        helper(node.right, k, path);

        // Check for paths with sum = k (starting anywhere in the path)
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) {
                // Print the path
                for (int j = i; j < path.size(); j++) {
                    System.out.print(path.get(j) + " ");
                }
                System.out.println();
            }
        }

        // Backtrack: remove current node
        path.remove(path.size() - 1);
    }
}
