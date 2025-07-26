package LinkedList;

public class insertAtend {
    public static void main(String[] args) {
        SNode head = new SNode(9);
        head.next = new SNode(8);
        head.next.next = new SNode(3);
        head.next.next.next = new SNode(4);
        head = insetAtend(head, 1);
        printlinkedlist(head);
    }
    public static void printlinkedlist(SNode head) {
        SNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
    public static SNode insetAtend(SNode head, int val){
        SNode newNode = new SNode(val);
        if (head == null) return newNode;
        SNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
       temp.next = newNode;
        return  head;
    }

}
