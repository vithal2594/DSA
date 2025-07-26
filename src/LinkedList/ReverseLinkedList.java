package LinkedList;

// Definition for singly-linked list node
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLinkedList {

    // Iterative method
    public static Node reverseIterative(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next; // Save next
            curr.next = prev;      // Reverse link
            prev = curr;           // Move prev and curr forward
            curr = next;
        }
        return prev; // New head
    }

    // Recursive method
    public static Node reverseRecursive(Node head) {
        // Base case: empty list or last node
        if (head == null || head.next == null) return head;

        Node rest = reverseRecursive(head.next); // Reverse rest
        head.next.next = head; // Make next node point to current
        head.next = null;      // Break old link
        return rest;           // Return new head
    }

    // Utility to print list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Sample usage
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.print("Original: ");
        printList(head);

        // Reverse iteratively
        head = reverseIterative(head);
        System.out.print("Reversed Iteratively: ");
        printList(head);

        // Reverse again using recursion to get original back
        head = reverseRecursive(head);
        System.out.print("Reversed Recursively: ");
        printList(head);
    }
}
