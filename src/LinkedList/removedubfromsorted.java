package LinkedList;

public class removedubfromsorted {
    public static void main(String[] args) {
        SNode head = new SNode(9);
        head.next = new SNode(8);
        head.next.next = new SNode(8);
        head.next.next.next = new SNode(4);

        head = removeDuplicates(head);
        printlinkedlist(head);
    }

    public static void printlinkedlist(SNode head) {
        SNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public static SNode removeDuplicates(SNode head){
        SNode current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else{
                current=current.next;
            }
        }
        return head;
    }
}
