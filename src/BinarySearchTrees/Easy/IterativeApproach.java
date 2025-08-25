package BinarySearchTrees.Easy;

import BinarySearchTrees.TreeNode;

import java.util.*;

public class IterativeApproach {

//    public class TreeViews {
//        static class TreeNode {
//            int val;
//            TreeNode left, right;
//            TreeNode(int val) { this.val = val; }
//        }

        // 1️⃣ Vertical Order Traversal
        public static List<List<Integer>> verticalOrder(TreeNode root) {
            TreeMap<Integer, List<int[]>> map = new TreeMap<>(); // col -> [row, val]
            Queue<Object[]> q = new LinkedList<>(); // {node, row, col}
            q.offer(new Object[]{root, 0, 0});

            while (!q.isEmpty()) {
                Object[] arr = q.poll();
                TreeNode node = (TreeNode) arr[0];
                int row = (int) arr[1];
                int col = (int) arr[2];

                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(new int[]{row, node.val});

                if (node.left != null) q.offer(new Object[]{node.left, row + 1, col - 1});
                if (node.right != null) q.offer(new Object[]{node.right, row + 1, col + 1});
            }

            List<List<Integer>> result = new ArrayList<>();
            for (List<int[]> list : map.values()) {
                Collections.sort(list, (a, b) -> {
                    if (a[0] == b[0]) return a[1] - b[1];
                    return a[0] - b[0];
                });
                List<Integer> colVals = new ArrayList<>();
                for (int[] p : list) colVals.add(p[1]);
                result.add(colVals);
            }
            return result;
        }

        // 2️⃣ Top View
        public static List<Integer> topView(TreeNode root) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            Queue<Object[]> q = new LinkedList<>();
            q.offer(new Object[]{root, 0});
            while (!q.isEmpty()) {
                Object[] arr = q.poll();
                TreeNode node = (TreeNode) arr[0];
                int col = (int) arr[1];
                map.putIfAbsent(col, node.val);
                if (node.left != null) q.offer(new Object[]{node.left, col - 1});
                if (node.right != null) q.offer(new Object[]{node.right, col + 1});
            }
            return new ArrayList<>(map.values());
        }

        // 3️⃣ Bottom View
        public static List<Integer> bottomView(TreeNode root) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            Queue<Object[]> q = new LinkedList<>();
            q.offer(new Object[]{root, 0});
            while (!q.isEmpty()) {
                Object[] arr = q.poll();
                TreeNode node = (TreeNode) arr[0];
                int col = (int) arr[1];
                map.put(col, node.val);
                if (node.left != null) q.offer(new Object[]{node.left, col - 1});
                if (node.right != null) q.offer(new Object[]{node.right, col + 1});
            }
            return new ArrayList<>(map.values());
        }

        // 4️⃣ Right View
        public static List<Integer> rightView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (i == size - 1) res.add(node.val);
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
            }
            return res;
        }

        // 5️⃣ Left View
        public static List<Integer> leftView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (i == 0) res.add(node.val);
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
            }
            return res;
        }

        // 6️⃣ Level Order Traversal
        public static List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    level.add(node.val);
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
                res.add(level);
            }
            return res;
        }

        // 7️⃣ Preorder Traversal
        public static void preorder(TreeNode root, List<Integer> res) {
            if (root == null) return;
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }

        // 8️⃣ Inorder Traversal
        public static void inorder(TreeNode root, List<Integer> res) {
            if (root == null) return;
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }

        // 9️⃣ Postorder Traversal
        public static void postorder(TreeNode root, List<Integer> res) {
            if (root == null) return;
            postorder(root.left, res);
            postorder(root.right, res);
            res.add(root.val);
        }
    // 🔹 Iterative Preorder Traversal (Root → Left → Right)
    public static List<Integer> preorderIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            // Push right first so left is processed first
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    // 🔹 Iterative Inorder Traversal (Left → Root → Right)
    public static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // Process node
            curr = stack.pop();
            res.add(curr.val);

            // Visit right subtree
            curr = curr.right;
        }
        return res;
    }

    // 🔹 Iterative Postorder Traversal (Left → Right → Root)
    public static List<Integer> postorderIterative(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.addFirst(node.val); // Add root first, reverse later

            // Push left first so right is processed first
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }

        // 🔟 MAIN METHOD FOR TESTING
        public static void main(String[] args) {
        /*
                3
               / \
              9   20
                 /  \
                15   7
        */
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);

            System.out.println("Vertical Order: " + verticalOrder(root));
            System.out.println("Top View: " + topView(root));
            System.out.println("Bottom View: " + bottomView(root));
            System.out.println("Right View: " + rightView(root));
            System.out.println("Left View: " + leftView(root));
            System.out.println("Level Order: " + levelOrder(root));
            System.out.println("Iterative Preorder: " + preorderIterative(root));
            System.out.println("Iterative Inorder: " + inorderIterative(root));
            System.out.println("Iterative Postorder: " + postorderIterative(root));
            List<Integer> pre = new ArrayList<>();
            preorder(root, pre);
            System.out.println("Preorder: " + pre);

            List<Integer> in = new ArrayList<>();
            inorder(root, in);
            System.out.println("Inorder: " + in);

            List<Integer> post = new ArrayList<>();
            postorder(root, post);
            System.out.println("Postorder: " + post);
        }
    }
