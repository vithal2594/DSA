package BinarySearchTrees.Easy;
import BinarySearchTrees.TreeNode;

import java.util.*;

public class BinaryTreeProblems {

    // -----------------------------
    // 1. Construct Tree from Preorder + Inorder (LC 105)
    // -----------------------------
    int preorderIndex;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap.clear();
        for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);
        return buildPreIn(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildPreIn(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inorderMap.get(rootVal);
        root.left = buildPreIn(preorder, inStart, inIndex - 1);
        root.right = buildPreIn(preorder, inIndex + 1, inEnd);
        return root;
    }

    // -----------------------------
    // 2. Construct Tree from Postorder + Inorder (LC 106)
    // -----------------------------
    int postIndex;
    Map<Integer, Integer> inorderMap2 = new HashMap<>();

    public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        inorderMap2.clear();
        for (int i = 0; i < inorder.length; i++) inorderMap2.put(inorder[i], i);
        return buildPostIn(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildPostIn(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inorderMap2.get(rootVal);
        root.right = buildPostIn(postorder, inIndex + 1, inEnd);
        root.left = buildPostIn(postorder, inStart, inIndex - 1);
        return root;
    }

    // -----------------------------
    // 3. Construct Tree from Preorder + Postorder (LC 889)
    // -----------------------------
    int preIndex;
    Map<Integer, Integer> postorderMap = new HashMap<>();

    public TreeNode buildTreePrePost(int[] preorder, int[] postorder) {
        preIndex = 0;
        postorderMap.clear();
        for (int i = 0; i < postorder.length; i++) postorderMap.put(postorder[i], i);
        return buildPrePost(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildPrePost(int[] preorder, int[] postorder, int postStart, int postEnd) {
        if (preIndex >= preorder.length || postStart > postEnd) return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (postStart == postEnd) return root;
        int leftVal = preorder[preIndex];
        int leftIndex = postorderMap.get(leftVal);
        root.left = buildPrePost(preorder, postorder, postStart, leftIndex);
        root.right = buildPrePost(preorder, postorder, leftIndex + 1, postEnd - 1);
        return root;
    }

    // -----------------------------
    // 4. Morris Traversals
    // -----------------------------

    // Inorder
    public List<Integer> morrisInorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) pre = pre.right;
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    // Preorder
    public List<Integer> morrisPreorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) pre = pre.right;
                if (pre.right == null) {
                    result.add(curr.val); // visit before going left
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    // Postorder (using Morris + dummy root)
    public List<Integer> morrisPostorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        TreeNode curr = dummy;
        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) pre = pre.right;
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    addReverse(curr.left, pre, result);
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    // Helper for postorder
    private void addReverse(TreeNode from, TreeNode to, List<Integer> res) {
        reverse(from, to);
        TreeNode curr = to;
        while (true) {
            res.add(curr.val);
            if (curr == from) break;
            curr = curr.right;
        }
        reverse(to, from);
    }

    private void reverse(TreeNode from, TreeNode to) {
        if (from == to) return;
        TreeNode x = from, y = from.right, z;
        while (true) {
            z = y.right;
            y.right = x;
            x = y;
            y = z;
            if (x == to) break;
        }
    }

    // -----------------------------
    // 5. Serialize & Deserialize Binary Tree (LC 297)
    // -----------------------------
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) sb.append("null,");
            else {
                sb.append(node.val).append(",");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < vals.length) {
            TreeNode node = q.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                q.add(node.left);
            }
            i++;
            if (i < vals.length && !vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                q.add(node.right);
            }
            i++;
        }
        return root;
    }

    // -----------------------------
    // 6. Flatten Binary Tree to Linked List (LC 114)
    // -----------------------------
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode pre = curr.left;
                while (pre.right != null) pre = pre.right;
                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    // -----------------------------
    // Helper: Inorder Traversal
    // -----------------------------
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // -----------------------------
    // Main for Demo
    // -----------------------------
    public static void main(String[] args) {
        BinaryTreeProblems obj = new BinaryTreeProblems();

        // Construct (Pre+In)
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = obj.buildTreePreIn(preorder, inorder);

        System.out.print("Inorder (Recursive): ");
        obj.printInorder(root);
        System.out.println();

        // Morris Traversals
        System.out.println("Morris Inorder: " + obj.morrisInorder(root));
        System.out.println("Morris Preorder: " + obj.morrisPreorder(root));
        System.out.println("Morris Postorder: " + obj.morrisPostorder(root));

        // Serialize & Deserialize
        String ser = obj.serialize(root);
        System.out.println("Serialized: " + ser);
        TreeNode deser = obj.deserialize(ser);
        System.out.print("Inorder (Deserialized): ");
        obj.printInorder(deser);
        System.out.println();

        // Flatten Tree
        obj.flatten(root);
        System.out.print("Flattened: ");
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }
}

