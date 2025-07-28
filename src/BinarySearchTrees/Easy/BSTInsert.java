package BinarySearchTrees.Easy;

import BinarySearchTrees.TreeNode;

public class BSTInsert {
    public static void main(String[] args){
        TreeNode root = null;
        root =insert(root,10);
        root =insert(root,80);
        root =insert(root,50);
        root =insert(root,60);
        System.out.print("Inorder Traversal of BST: ");
        inoreder(root);
    }
    public static TreeNode insert(TreeNode root, int val){
        if(root  == null){
            return new TreeNode(val);
        }
        if(val < root.val){
            root.left = insert(root.left,val);
        }else if(val > root.val){
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inoreder(TreeNode root){
        if(root == null) return;
        inoreder(root.left);
        System.out.println(root.val + " ");
        inoreder((root.right));
    }
}
