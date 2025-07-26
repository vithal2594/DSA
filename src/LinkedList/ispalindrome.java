package LinkedList;

import java.util.Stack;

public class ispalindrome {
    public static void main(String[] args) {
        SNode head = new SNode(9);
        head.next = new SNode(8);
        head.next.next = new SNode(3);
        head.next.next.next = new SNode(4);

        boolean found = ispalindrome(head);  // Deleting node at index 1
        printlinkedlist(head);
        System.out.println("is it palindrome :" + found);
    }

    public static void printlinkedlist(SNode head) {
        SNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public static boolean ispalindrome(SNode head){
        Stack<Integer> st = new Stack<>();
        SNode temp = head;
        while(temp != null){
           st.add(temp.data);
           temp=temp.next;
        }
        while (head != null) {
            if(head.data != st.pop()) return false;
            head = head.next;
        }
        return true;
    }
}
