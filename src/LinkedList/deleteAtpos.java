package LinkedList;

public class deleteAtpos {
    public static void main(String[] args) {
        SNode head = new SNode(9);
        head.next = new SNode(8);
        head.next.next = new SNode(3);
        head.next.next.next = new SNode(4);

        head = deleteAtpos1(head, 1);  // Deleting node at index 1
        printlinkedlist(head);
    }

    public static void printlinkedlist(SNode head) {
        SNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static SNode deleteAtpos1(SNode head, int pos){
        if (head == null) return null;
        if (pos == 0) return head.next;

        SNode temp = head;
        for(int i = 0; temp != null && i < pos - 1; i++){
            temp = temp.next;
        }

        if (temp == null || temp.next == null) return head;
        temp.next = temp.next.next;
        return head;
    }
}

