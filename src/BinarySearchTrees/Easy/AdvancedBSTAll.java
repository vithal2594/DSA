package BinarySearchTrees.Easy;
import BinarySearchTrees.TreeNode;

import java.util.*;

public class AdvancedBSTAll {
        static int index;
        // 1. Convert BST to Min Heap
        public static void bstToMinHeap(TreeNode root) {
            List<Integer> inorder = new ArrayList<>();
            storeInorder(root, inorder);
            index = 0;
            bstToMinHeapUtil(root, inorder);
        }

        private static void storeInorder(TreeNode root, List<Integer> list) {
            if (root == null) return;
            storeInorder(root.left, list);
            list.add(root.val);
            storeInorder(root.right, list);
        }

        private static void bstToMinHeapUtil(TreeNode root, List<Integer> list) {
            if (root == null) return;
            root.val = list.get(index++);
            bstToMinHeapUtil(root.left, list);
            bstToMinHeapUtil(root.right, list);
        }

        // 2. Convert BST to Max Heap
        public static void bstToMaxHeap(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            storeInorder(root, list);
            Collections.reverse(list);
            index = 0;
            bstToMaxHeapUtil(root, list);
        }

        private static void bstToMaxHeapUtil(TreeNode root, List<Integer> list) {
            if (root == null) return;
            root.val = list.get(index++);
            bstToMaxHeapUtil(root.right, list);
            bstToMaxHeapUtil(root.left, list);
        }

        // 3. Flatten BST to Sorted Linked List (In-place)
        static TreeNode prev = null;

        public static void flattenBST(TreeNode root) {
            if (root == null) return;
            flattenBST(root.right);
            flattenBST(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }

        // 4. BST Iterator (In-order with O(h) space)
        static class BSTIterator {
            Stack<TreeNode> stack = new Stack<>();

            public BSTIterator(TreeNode root) {
                pushLeft(root);
            }

            private void pushLeft(TreeNode node) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            public boolean hasNext() {
                return !stack.isEmpty();
            }

            public int next() {
                TreeNode node = stack.pop();
                pushLeft(node.right);
                return node.val;
            }
        }

        // 5. Serialize and Deserialize BST
        public static String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preorderSerialize(root, sb);
            return sb.toString().trim();
        }

        private static void preorderSerialize(TreeNode node, StringBuilder sb) {
            if (node == null) return;
            sb.append(node.val).append(" ");
            preorderSerialize(node.left, sb);
            preorderSerialize(node.right, sb);
        }

        static int deserIndex = 0;

        public static TreeNode deserialize(String data) {
            String[] tokens = data.split(" ");
            int[] arr = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
            deserIndex = 0;
            return deserializeUtil(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private static TreeNode deserializeUtil(int[] arr, int min, int max) {
            if (deserIndex >= arr.length || arr[deserIndex] < min || arr[deserIndex] > max)
                return null;
            TreeNode root = new TreeNode(arr[deserIndex++]);
            root.left = deserializeUtil(arr, min, root.val);
            root.right = deserializeUtil(arr, root.val, max);
            return root;
        }

        // 6. Dead End in BST
        public static boolean hasDeadEnd(TreeNode root) {
            return checkDeadEnd(root, 1, Integer.MAX_VALUE);
        }

        private static boolean checkDeadEnd(TreeNode node, int min, int max) {
            if (node == null) return false;
            if (min == max) return true;
            return checkDeadEnd(node.left, min, node.val - 1) || checkDeadEnd(node.right, node.val + 1, max);
        }

        // 7. Largest BST in Binary Tree
        static class Info {
            boolean isBST;
            int size, min, max;

            Info(boolean is, int size, int min, int max) {
                this.isBST = is;
                this.size = size;
                this.min = min;
                this.max = max;
            }
        }

        static int maxBSTSize = 0;

        public static int largestBST(TreeNode root) {
            maxBSTSize = 0;
            findLargestBST(root);
            return maxBSTSize;
        }

        private static Info findLargestBST(TreeNode root) {
            if (root == null) return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
            Info left = findLargestBST(root.left);
            Info right = findLargestBST(root.right);
            if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
                int size = 1 + left.size + right.size;
                maxBSTSize = Math.max(maxBSTSize, size);
                return new Info(true, size, Math.min(root.val, left.min), Math.max(root.val, right.max));
            }
            return new Info(false, 0, 0, 0);
        }

        // 8. Balance an Unbalanced BST
        public static TreeNode balanceBST(TreeNode root) {
            List<Integer> inorder = new ArrayList<>();
            storeInorder(root, inorder);
            return buildBalanced(inorder, 0, inorder.size() - 1);
        }

        private static TreeNode buildBalanced(List<Integer> list, int l, int r) {
            if (l > r) return null;
            int m = (l + r) / 2;
            TreeNode root = new TreeNode(list.get(m));
            root.left = buildBalanced(list, l, m - 1);
            root.right = buildBalanced(list, m + 1, r);
            return root;
        }

        // 9. BST to Binary Tree with Same Structure and Sums
        static int bstSum = 0;

        public static void bstToSumTree(TreeNode root) {
            bstSum = 0;
            convertToSumTree(root);
        }

        private static void convertToSumTree(TreeNode node) {
            if (node == null) return;
            convertToSumTree(node.left);
            bstSum += node.val;
            node.val = bstSum;
            convertToSumTree(node.right);
        }

        // 10. AVL Tree Basic
        static class AVLNode {
            int val, height;
            AVLNode left, right;

            AVLNode(int val) {
                this.val = val;
                height = 1;
            }
        }

        public static AVLNode insertAVL(AVLNode node, int key) {
            if (node == null) return new AVLNode(key);
            if (key < node.val) node.left = insertAVL(node.left, key);
            else node.right = insertAVL(node.right, key);

            node.height = 1 + Math.max(height(node.left), height(node.right));
            int balance = getBalance(node);

            // Rotations
            if (balance > 1 && key < node.left.val) return rightRotate(node);
            if (balance < -1 && key > node.right.val) return leftRotate(node);
            if (balance > 1 && key > node.left.val) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
            if (balance < -1 && key < node.right.val) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
            return node;
        }

        private static int height(AVLNode node) {
            return node == null ? 0 : node.height;
        }

        private static int getBalance(AVLNode node) {
            return node == null ? 0 : height(node.left) - height(node.right);
        }

        private static AVLNode rightRotate(AVLNode y) {
            AVLNode x = y.left;
            AVLNode T2 = x.right;
            x.right = y;
            y.left = T2;
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            return x;
        }

        private static AVLNode leftRotate(AVLNode x) {
            AVLNode y = x.right;
            AVLNode T2 = y.left;
            y.left = x;
            x.right = T2;
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            return y;
        }

        // Utility: Print Inorder
        public static void printInorder(TreeNode root) {
            if (root == null) return;
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }

        public static void main(String[] args) {
            TreeNode bst = null;
            for (int val : new int[]{10, 5, 1, 7, 40, 50}) {
                bst = insert(bst, val);
            }

            System.out.println("Original BST:");
            printInorder(bst);
            System.out.println();

            System.out.println("\nConvert to Min Heap:");
            bstToMinHeap(bst);
            printInorder(bst);
            System.out.println();

            bst = insert(null, 10);
            insert(bst, 5);
            insert(bst, 15);
            System.out.println("\nConvert to Max Heap:");
            bstToMaxHeap(bst);
            printInorder(bst);
            System.out.println();

            System.out.println("\nFlatten to Sorted List:");
            flattenBST(bst);
            printInorder(bst);
            System.out.println();

            System.out.println("\nBST Iterator:");
            BSTIterator it = new BSTIterator(bst);
            while (it.hasNext()) System.out.print(it.next() + " ");
            System.out.println();

            System.out.println("\nSerialize & Deserialize:");
            String ser = serialize(bst);
            TreeNode des = deserialize(ser);
            printInorder(des);
            System.out.println();

            System.out.println("\nHas Dead End: " + hasDeadEnd(bst));

            System.out.println("\nLargest BST Size: " + largestBST(bst));

            System.out.println("\nBalance BST:");
            TreeNode unbalanced = new TreeNode(1);
            unbalanced.right = new TreeNode(2);
            unbalanced.right.right = new TreeNode(3);
            TreeNode balanced = balanceBST(unbalanced);
            printInorder(balanced);
            System.out.println();

            System.out.println("\nBST to Cumulative Sum Tree:");
            bstToSumTree(bst);
            printInorder(bst);
            System.out.println();

            System.out.println("\nAVL Tree Insert:");
            AVLNode avl = null;
            for (int i : new int[]{10, 20, 30, 40, 50}) avl = insertAVL(avl, i);
            System.out.println("AVL Tree Height: " + avl.height);
        }

        // Helper Insert for TreeNode
        private static TreeNode insert(TreeNode root, int key) {
            if (root == null) return new TreeNode(key);
            if (key < root.val) root.left = insert(root.left, key);
            else root.right = insert(root.right, key);
            return root;
        }
    }