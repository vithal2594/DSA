package LinkedList;

//package LinkedList;

import java.util.*;

//class Node {
//    int data;
//    Node next;
//    Node(int d) { data = d; next = null; }
//}

class RandomNode {
    int data;
    RandomNode next, random;
    RandomNode(int d) { data = d; }
}

class MultiNode {
    int data;
    MultiNode next, child;
    MultiNode(int d) { data = d; }
}

class BottomNode {
    int data;
    BottomNode next, bottom;
    BottomNode(int d) { data = d; }
}

public class LinkedListProblemsPart4 {

    // 31. Reverse Nodes in K-Group
    public static Node reverseKGroup(Node head, int k) {
        Node curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count-- > 0) {
                Node tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }

    // 32. Detect and Remove Loop
    public static void detectAndRemoveLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                removeLoop(head, slow);
                return;
            }
        }
    }

    private static void removeLoop(Node head, Node loopNode) {
        Node ptr1 = head;
        Node ptr2;
        while (true) {
            ptr2 = loopNode;
            while (ptr2.next != loopNode && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }
            if (ptr2.next == ptr1) break;
            ptr1 = ptr1.next;
        }
        ptr2.next = null;
    }

    // 33. Add Two Numbers
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0), p = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.data; l1 = l1.next; }
            if (l2 != null) { sum += l2.data; l2 = l2.next; }
            p.next = new Node(sum % 10);
            carry = sum / 10;
            p = p.next;
        }
        return dummy.next;
    }

    // 34. Flatten Multilevel Linked List
    public static MultiNode flattenList(MultiNode head) {
        if (head == null) return null;
        MultiNode temp = head;
        while (temp != null) {
            if (temp.child != null) {
                MultiNode next = temp.next;
                MultiNode child = flattenList(temp.child);
                temp.next = child;
                temp.child = null;
                MultiNode tail = temp;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = next;
            }
            temp = temp.next;
        }
        return head;
    }

    // 35. Clone Linked List with Random Pointers
    public static RandomNode cloneRandomList(RandomNode head) {
        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode curr = head;
        while (curr != null) {
            map.put(curr, new RandomNode(curr.data));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    // 36. Rotate Right
    public static Node rotateRight(Node head, int k) {
        if (head == null || k == 0) return head;
        Node oldTail = head;
        int length = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }
        oldTail.next = head;
        k %= length;
        Node newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        Node newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    // 37. Merge Sort Linked List
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node mid = getMid(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;
        return merge(mergeSort(left), mergeSort(right));
    }

    private static Node getMid(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node merge(Node a, Node b) {
        Node dummy = new Node(0), curr = dummy;
        while (a != null && b != null) {
            if (a.data < b.data) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        curr.next = (a != null) ? a : b;
        return dummy.next;
    }

    // 38. Get Intersection Node
    public static Node getIntersectionNode(Node headA, Node headB) {
        Node a = headA, b = headB;
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }

    // 39. Palindrome Check
    public static boolean isPalindromeOptimized(Node head) {
        if (head == null || head.next == null) return true;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node rev = reverseList(slow);
        Node copyRev = rev;
        while (rev != null) {
            if (head.data != rev.data) return false;
            head = head.next;
            rev = rev.next;
        }
        reverseList(copyRev);
        return true;
    }

    private static Node reverseList(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // 40. Flatten Bottom List
    public static BottomNode flatten(BottomNode root) {
        if (root == null || root.next == null) return root;
        root.next = flatten(root.next);
        root = mergeBottom(root, root.next);
        return root;
    }

    private static BottomNode mergeBottom(BottomNode a, BottomNode b) {
        BottomNode dummy = new BottomNode(0), tail = dummy;
        while (a != null && b != null) {
            if (a.data < b.data) {
                tail.bottom = a;
                a = a.bottom;
            } else {
                tail.bottom = b;
                b = b.bottom;
            }
            tail = tail.bottom;
        }
        tail.bottom = (a != null) ? a : b;
        return dummy.bottom;
    }

    // === MAIN ===
    public static void main(String[] args) {

        System.out.println("31. Reverse in K Group:");
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        printList(reverseKGroup(head, 2));

        System.out.println("\n32. Detect and Remove Loop:");
        Node loop = new Node(1);
        loop.next = new Node(2);
        loop.next.next = new Node(3);
        loop.next.next.next = loop; // Creates loop
        detectAndRemoveLoop(loop);
        printList(loop); // Should terminate

        System.out.println("\n33. Add Two Numbers:");
        Node l1 = new Node(2); l1.next = new Node(4); l1.next.next = new Node(3);
        Node l2 = new Node(5); l2.next = new Node(6); l2.next.next = new Node(4);
        printList(addTwoNumbers(l1, l2));

        System.out.println("\n34. Flatten Multilevel Linked List:");
        MultiNode m1 = new MultiNode(1);
        m1.child = new MultiNode(2);
        m1.child.next = new MultiNode(3);
        MultiNode flat = flattenList(m1);
        while (flat != null) {
            System.out.print(flat.data + " -> ");
            flat = flat.next;
        }
        System.out.println("null");

        System.out.println("\n35. Clone Random Linked List:");
        RandomNode r1 = new RandomNode(1);
        RandomNode r2 = new RandomNode(2);
        r1.next = r2;
        r1.random = r2;
        r2.random = r2;
        RandomNode cloned = cloneRandomList(r1);
        while (cloned != null) {
            System.out.print(cloned.data + "(" + (cloned.random != null ? cloned.random.data : "null") + ") -> ");
            cloned = cloned.next;
        }
        System.out.println("null");

        System.out.println("\n36. Rotate Linked List Right by 2:");
        Node rotate = new Node(10);
        rotate.next = new Node(20);
        rotate.next.next = new Node(30);
        rotate.next.next.next = new Node(40);
        rotate.next.next.next.next = new Node(50);
        printList(rotateRight(rotate, 2));

        System.out.println("\n37. Sort Linked List:");
        Node unsorted = new Node(4);
        unsorted.next = new Node(2);
        unsorted.next.next = new Node(1);
        unsorted.next.next.next = new Node(3);
        printList(mergeSort(unsorted));

        System.out.println("\n38. Get Intersection Point:");
        Node a1 = new Node(1);
        a1.next = new Node(2);
        Node common = new Node(8);
        a1.next.next = common;
        common.next = new Node(10);
        Node b1 = new Node(5);
        b1.next = common;
        Node intersect = getIntersectionNode(a1, b1);
        System.out.println("Intersection at: " + (intersect != null ? intersect.data : "null"));

        System.out.println("\n39. Is Palindrome:");
        Node pal = new Node(1);
        pal.next = new Node(2);
        pal.next.next = new Node(2);
        pal.next.next.next = new Node(1);
        System.out.println("Palindrome? " + isPalindromeOptimized(pal));

        System.out.println("\n40. Flatten Bottom List:");
        BottomNode b = new BottomNode(5);
        b.bottom = new BottomNode(7);
        b.bottom.bottom = new BottomNode(8);
        b.bottom.bottom.bottom = new BottomNode(30);
        BottomNode b2 = new BottomNode(10);
        b2.bottom = new BottomNode(20);
        b.next = b2;
        BottomNode flatBottom = flatten(b);
        while (flatBottom != null) {
            System.out.print(flatBottom.data + " -> ");
            flatBottom = flatBottom.bottom;
        }
        System.out.println("null");
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}

