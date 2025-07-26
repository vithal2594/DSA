package LinkedList;

public class deletefirst {
    public static void main(String[] args) {
        SNode head = new SNode(9);
        head.next = new SNode(8);
        head.next.next = new SNode(3);
        head.next.next.next = new SNode(4);

        head = deleteAtfirst(head);  // Deleting node at index 1
        printlinkedlist(head);
    }

    public static void printlinkedlist(SNode head) {
        SNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public static SNode deleteAtfirst(SNode head){
        if(head == null) return null;
        return  head.next;
    }
}
