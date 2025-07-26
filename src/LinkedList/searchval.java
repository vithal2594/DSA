package LinkedList;

public class searchval {
    public static void main(String[] args) {
        SNode head = new SNode(9);
        head.next = new SNode(8);
        head.next.next = new SNode(3);
        head.next.next.next = new SNode(4);
      boolean found=  searchva(head,12);
        System.out.println("Value found: " + found);
//        printlinkedlist(head);
    }

    public static void printlinkedlist(SNode head) {
        SNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public static boolean searchva(SNode head,int val){
        while(head != null){
            if(head.data == val) return true;
            head=head.next;
        }
        return  false;
    }
}
