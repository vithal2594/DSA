package LinkedList;

    public class LinkedListBatch3 {
        public static void main(String[] args) {
            Node head = new Node(1);
            head.next = new Node(4);
            head.next.next = new Node(3);
            head.next.next.next = new Node(2);
            head.next.next.next.next = new Node(5);

            System.out.println("Original List:");
            printList(head);

            System.out.println("\n21. Pairwise Swap:");
            printList(pairwiseSwap(head));

            System.out.println("\n22. Segregate Even and Odd:");
            head = segregateEvenOdd(head);
            printList(head);

            System.out.println("\n23. Move Last to Front:");
            head = moveLastToFront(head);
            printList(head);
            System.out.println("\n24. Get Intersection Point:");

            // Creating intersection
            Node head1 = new Node(1);
            head1.next = new Node(2);
            Node common = new Node(8);
            head1.next.next = common;
            common.next = new Node(10);

            Node head2 = new Node(5);
            head2.next = common;

            System.out.println("Intersection at node with value: " + getIntersection(head1, head2));

            System.out.println("\n25. Check Circular Linked List:");
            Node circular = new Node(1);
            circular.next = new Node(2);
            circular.next.next = new Node(3);
            circular.next.next.next = circular; // Loop created
            System.out.println("Is circular: " + isCircular(circular));

            System.out.println("\n27. Count Nodes in Loop:");
            Node loopHead = new Node(1);
            loopHead.next = new Node(2);
            loopHead.next.next = new Node(3);
            loopHead.next.next.next = new Node(4);
            loopHead.next.next.next.next = loopHead.next; // Create loop at node with value 2
            System.out.println("Loop count: " + countNodesInLoop(loopHead));

            System.out.println("\n28. Split Circular Linked List:");
            Node circ = new Node(1);
            circ.next = new Node(2);
            circ.next.next = new Node(3);
            circ.next.next.next = new Node(4);
            circ.next.next.next.next = new Node(5);
            circ.next.next.next.next.next = circ; // Make it circular

            Node[] halves = new Node[2];
            splitCircularList(circ, halves);

            System.out.print("First half: ");
            Node temp = halves[0];
            if (temp != null) {
                do {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                } while (temp != halves[0]);
            }

            System.out.print("\nSecond half: ");
            temp = halves[1];
            if (temp != null) {
                do {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                } while (temp != halves[1]);
            }
            System.out.println();
            System.out.println("\n29. Frequency of 2:");
            System.out.println(frequency(head, 2));

            System.out.println("\n30. Max Value:");
            System.out.println(findMax(head));

            System.out.println("\n26. Convert Binary to Decimal:");
            Node binHead = new Node(1);
            binHead.next = new Node(0);
            binHead.next.next = new Node(1);
            System.out.println(getDecimalValue(binHead));
        }
        static void printList(Node head) {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println();
        }
        // 21. Pairwise Swap Elements of Linked List
        static Node pairwiseSwap(Node head) {
            Node temp = head;
            while (temp != null && temp.next != null) {
                int t = temp.data;
                temp.data = temp.next.data;
                temp.next.data = t;
                temp = temp.next.next;
            }
            return head;
        }

        // 22. Segregate Even and Odd Nodes (Maintain Order)
        static Node segregateEvenOdd(Node head) {
            Node evenStart = null, evenEnd = null;
            Node oddStart = null, oddEnd = null;
            Node curr = head;

            while (curr != null) {
                int val = curr.data;
                if (val % 2 == 0) {
                    if (evenStart == null) {
                        evenStart = curr;
                        evenEnd = evenStart;
                    } else {
                        evenEnd.next = curr;
                        evenEnd = evenEnd.next;
                    }
                } else {
                    if (oddStart == null) {
                        oddStart = curr;
                        oddEnd = oddStart;
                    } else {
                        oddEnd.next = curr;
                        oddEnd = oddEnd.next;
                    }
                }
                curr = curr.next;
            }

            if (evenStart == null || oddStart == null) return head;

            evenEnd.next = oddStart;
            oddEnd.next = null;
            return evenStart;
        }

        // 23. Move Last Node to Front
        static Node moveLastToFront(Node head) {
            if (head == null || head.next == null) return head;

            Node secondLast = null, last = head;
            while (last.next != null) {
                secondLast = last;
                last = last.next;
            }

            secondLast.next = null;
            last.next = head;
            return last;
        }

        // 24. Get Intersection Point of Two Linked Lists
        static int getIntersection(Node head1, Node head2) {
            int len1 = getLength(head1);
            int len2 = getLength(head2);

            if (len1 > len2) {
                while (len1-- > len2) head1 = head1.next;
            } else {
                while (len2-- > len1) head2 = head2.next;
            }

            while (head1 != null && head2 != null) {
                if (head1 == head2) return head1.data;
                head1 = head1.next;
                head2 = head2.next;
            }

            return -1;
        }

        static int getLength(Node head) {
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        }

        // 25. Check Circular Linked List
        static boolean isCircular(Node head) {
            if (head == null) return true;
            Node temp = head.next;
            while (temp != null && temp != head) {
                temp = temp.next;
            }
            return temp == head;
        }

        // 26. Convert Binary Number in Linked List to Integer
        static int getDecimalValue(Node head) {
            int num = 0;
            while (head != null) {
                num = num * 2 + head.data;
                head = head.next;
            }
            return num;
        }

        // 27. Count Nodes in Loop
        static int countNodesInLoop(Node head) {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return countLoopNodes(slow);
            }
            return 0;
        }

        static int countLoopNodes(Node node) {
            int count = 1;
            Node temp = node;
            while (temp.next != node) {
                count++;
                temp = temp.next;
            }
            return count;
        }

        // 28. Split Circular Linked List into Two Halves
        static void splitCircularList(Node head, Node[] result) {
            if (head == null || head.next == head) {
                result[0] = head;
                result[1] = null;
                return;
            }

            Node slow = head, fast = head;
            while (fast.next != head && fast.next.next != head) {
                fast = fast.next.next;
                slow = slow.next;
            }

            Node head1 = head;
            Node head2 = slow.next;

            slow.next = head1;

            Node temp = head2;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head2;

            result[0] = head1;
            result[1] = head2;
        }

        // 29. Find Frequency of Given Element
        static int frequency(Node head, int key) {
            int count = 0;
            while (head != null) {
                if (head.data == key) count++;
                head = head.next;
            }
            return count;
        }

        // 30. Find Maximum Value in Linked List
        static int findMax(Node head) {
            if (head == null) return Integer.MIN_VALUE;
            int maxVal = head.data;
            while (head != null) {
                if (head.data > maxVal) maxVal = head.data;
                head = head.next;
            }
            return maxVal;
        }
    }

