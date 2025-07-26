package LinkedList;

// Node for Doubly Linked List
class DNode1 {
    int data;
    DNode next, prev;

    DNode1(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class ReverseDoublyLinkedList {

    // Reverse a doubly linked list iteratively
    public static DNode reverse(DNode head) {
        DNode curr = head;
        DNode temp = null;

        // Swap next and prev for all nodes
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev; // Move to next node (which is prev now)
        }

        // Return new head (last non-null node)
        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

    // Utility to print the list
    public static void printList(DNode head) {
        DNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create doubly linked list: 1 <-> 2 <-> 3 <-> 4
        DNode head = new DNode(1);
        head.next = new DNode(2);
        head.next.prev = head;
        head.next.next = new DNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new DNode(4);
        head.next.next.next.prev = head.next.next;

        System.out.print("Original: ");
        printList(head);

        // Reverse it
        head = reverse(head);
        System.out.print("Reversed: ");
        printList(head);
    }
}
