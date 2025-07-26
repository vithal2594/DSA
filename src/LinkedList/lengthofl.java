package LinkedList;
//
//class Node1{
//    int data;
//    Node next;
//    Node1(int data){
//        this.data=data;
//        this.next=null;
//    }
//}

public class lengthofl {
    public static int getSinglyLength(SNode head){
        int count=0;
        while(head != null){
            count++;
            head= head.next;
        }
        return  count;
    }

    public static void main(String[] args){
        SNode head1 = new SNode(1);
        head1.next = new SNode(2);
        head1.next.next = new SNode(3);

        System.out.println("Singly Length: " + getSinglyLength(head1));
    }
}
