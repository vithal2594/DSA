package BinarySearchTrees.Easy;

import BinarySearchTrees.TreeNode;

public class DeleteNodeBST {
    public static void main(String[] args){
        TreeNode root = null;

    }
    public static TreeNode insert(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
        if(val < root.val)
             root.left = insert(root.left, val);
        else if(val > root.val)
            root.right = insert(root.right, val);
        return root;
    }

}
