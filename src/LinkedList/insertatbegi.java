package LinkedList;

public class insertatbegi {
    public static void main(String[] args) {
        SNode head = new SNode(9);
        head.next = new SNode(8);
        head.next.next = new SNode(3);
        head.next.next.next = new SNode(4);
        head = insertAtbegi1(head, 1);
        printlinkedlist(head);
    }

    public static SNode insertAtbegi1(SNode head, int value) {
        SNode newNode = new SNode(value);
        newNode.next = head;
        return newNode;
    }

    public static void printlinkedlist(SNode head) {
        SNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
}
