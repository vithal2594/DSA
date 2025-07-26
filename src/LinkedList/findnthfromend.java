package LinkedList;

public class findnthfromend {
    public static void main(String[] args) {
        SNode head = new SNode(9);
        head.next = new SNode(8);
        head.next.next = new SNode(3);
        head.next.next.next = new SNode(4);

        SNode found = getNthFromEnd(head,2);  // Deleting node at index 1
        printlinkedlist(head);
        System.out.println("is it nth node :" + found.data);
    }

    public static void printlinkedlist(SNode head) {
        SNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public static SNode getNthFromEnd(SNode head, int n){
      int length=0;
      SNode temp = head;
      while (temp != null){
          length++;
          temp= temp.next;
      }
       if(length < n) return null;
       temp = head;
       for(int i=0; i<length - n; i++){
           temp=temp.next;
       }
       return temp;
    }
}
