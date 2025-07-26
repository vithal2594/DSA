package LinkedList;

import java.util.Stack;

public class printinreverse {
    public static void main(String[] args) {
        SNode head = new SNode(9);
        head.next = new SNode(8);
        head.next.next = new SNode(3);
        head.next.next.next = new SNode(4);
        printlinkedlist(head);
         printReverse(head);
         System.out.println();
        printReversest(head);// Deleting node at index 1
//        printlinkedlist(head);
    }

    public static void printlinkedlist(SNode head) {
        SNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public static void printReverse(SNode head){
        if (head == null) return ;
        printReverse(head.next);
        System.out.print(head.data + " ");
    }
    public static void printReversest(SNode head) {
        Stack<Integer> stack = new Stack<>();
        SNode current = head;
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
