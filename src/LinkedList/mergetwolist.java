package LinkedList;

public class mergetwolist {
    public static void main(String[] args) {
        // First sorted list: 1 → 3 → 5
        SNode head1 = new SNode(1);
        head1.next = new SNode(3);
        head1.next.next = new SNode(5);

        // Second sorted list: 2 → 4 → 6
        SNode head2 = new SNode(2);
        head2.next = new SNode(4);
        head2.next.next = new SNode(6);

        SNode merged = mergetwo(head1, head2);
        printList(merged);
    }
    public static void printList(SNode head) {
        SNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static SNode mergetwo(SNode l1, SNode l2){
        SNode dummy = new SNode(-1);
        SNode curr = dummy;

        while (l1 != null  && l2 != null){
            if(l1.data < l2.data){
                curr.next=l1;
                l1=l1.next;
            }else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        curr.next = (l1 != null)? l1:l2;
        return dummy.next;
    }
}
