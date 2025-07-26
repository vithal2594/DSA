package LinkedList;

public class detectloop {
    public static void main(String[] args) {
        SNode head = new SNode(9);
        head.next = new SNode(8);
        head.next.next = new SNode(3);
        head.next.next.next = new SNode(4);
//        head.next.next.next.next = head.next;
        boolean found = hascycle(head);  // Deleting node at index 1
//        printlinkedlist(head);
        System.out.println("is it cycle :" + found);
    }

    public static void printlinkedlist(SNode head) {
        SNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public static boolean hascycle(SNode head){
        SNode slow=head;
        SNode fast = head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
