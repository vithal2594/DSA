package LinkedList;
public class DetectAndFindCycle {
    public static void main(String[] args) {
        // Create a linked list with cycle
        SNode head = new SNode(3);
        SNode second = new SNode(2);
        SNode third = new SNode(0);
        SNode fourth = new SNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Cycle here

        SNode cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle detected at node with value: " + cycleStart.data);
        } else {
            System.out.println("No cycle in the linked list.");
        }
    }

    public static SNode detectCycle(SNode head) {
        SNode slow = head;
        SNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                // Step 2: Find cycle start
                SNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry; // start of cycle
            }
        }

        return null; // no cycle
    }
}
