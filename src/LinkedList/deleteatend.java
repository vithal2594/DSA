package LinkedList;

public class deleteatend {
    public static void main(String[] args) {
        SNode head = new SNode(9);
        head.next = new SNode(8);
        head.next.next = new SNode(3);
        head.next.next.next = new SNode(4);

        head = deleteAtend(head);  // Deleting node at index 1
        printlinkedlist(head);
    }

    public static void printlinkedlist(SNode head) {
        SNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public static SNode deleteAtend(SNode head){
       if(head == null || head.next == null ) return null;
       SNode temp = head;
       while(temp.next.next != null){
           temp= temp.next;
       }
       temp.next=null;
       return head;
    }
}
