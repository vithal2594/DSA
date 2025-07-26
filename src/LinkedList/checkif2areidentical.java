package LinkedList;

public class checkif2areidentical {
    public static void main(String[] args) {
        SNode head1 = new SNode(1);
        head1.next = new SNode(2);
        head1.next.next = new SNode(3);

        SNode head2 = new SNode(1);
        head2.next = new SNode(2);
        head2.next.next = new SNode(3);
        head2.next.next.next = new SNode(4);

        boolean result = areIdentical(head1, head2);
        System.out.println("Are the two lists identical? " + result);
    }
    public static  boolean areIdentical(SNode head1, SNode head2){
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data)
                return false;

            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }
}
