package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class removedubfromunsort {
    public static void main(String[] args) {
        SNode head = new SNode(9);
        head.next = new SNode(8);
        head.next.next = new SNode(3);
        head.next.next.next = new SNode(8);

        head = removeDuplicatesunsorted(head);
        printlinkedlist(head);
    }

    public static void printlinkedlist(SNode head) {
        SNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public static SNode removeDuplicatesunsorted(SNode head){
        Set<Integer> seen = new HashSet<>();
        SNode curr = head;
        seen.add(curr.data);
        while(curr.next != null){
            if(seen.contains(curr.next.data)){
                curr.next = curr.next.next;
            }else {
                seen.add(curr.next.data);
                curr=curr.next;
            }
        }
        return head;
    }
}
