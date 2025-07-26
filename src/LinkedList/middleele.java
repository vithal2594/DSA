package LinkedList;

public class middleele {
    public static void main(String[] args) {
        SNode head = new SNode(9);
        head.next = new SNode(8);
        head.next.next = new SNode(3);
        head.next.next.next = new SNode(4);
        SNode found=  middleelement(head);
        printlinkedlist(head);
        System.out.println("Value found: " + found.data);

    }

    public static void printlinkedlist(SNode head) {
        SNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static SNode middleelement(SNode head){
        if(head ==null) return null;
        SNode slow = head;
        SNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
