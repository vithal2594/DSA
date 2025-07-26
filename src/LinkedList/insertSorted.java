package LinkedList;

public class insertSorted {
    public static void main(String[] args) {
        SNode head = new SNode(10);
        head.next = new SNode(20);
        head.next.next = new SNode(30);

        int newData = 25;
        head = insertSorted(head, newData);

        printList(head);
    }
    public static void printList(SNode head) {
        SNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static SNode insertSorted(SNode head, int data) {
        SNode newNode = new SNode(data);

        // Case 1: Insert at beginning or in empty list
        if (head == null || data < head.data) {
            newNode.next = head;
            return newNode;
        }

        // Traverse to find insert position
        SNode curr = head;
        while (curr.next != null && curr.next.data < data) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }
}
