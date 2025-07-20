package Prac.LinkedList;

import java.util.Scanner;

public class basic {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class DNode{
        int data;
        DNode next,prev;
        DNode(int data){
            this.data=data;
        }

    static void displayr(Node head){
        // Node temp=head;
        // while(temp!= null){
        //     System.out.print(temp.data +" -> ");
        //     temp = temp.next;
        // }
        // System.out.println("null");
        if(head == null) return;
        displayr(head.next);
        System.out.print(head.data+"->");
    }

    static void display(Node head){
    //     Node temp=head;
    //     while(temp!= null){
    //         temp = temp.next;
    //         System.out.print(temp.data +" -> ");
    //     }
    //     System.out.println("null");
    if(head == null) return;
    System.out.print(head.data+"->");
    display(head.next);
    
    }


    public static void constructoroflinkedlist(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        if(n<=0){
            System.out.println("Empty list.");
            return;
        }
        System.out.println("Enter elements: ");
        int val =sc.nextInt();
        Node head =new Node(val);
        Node tail=head;
        for(int i=1; i<n; i++){
            val=sc.nextInt();
            tail.next=new Node(val);
            tail = tail.next;
        }
        System.out.println("Constructed Linked List:");
        display(head);
        sc.close();
        }
        public static void lengthofli(Node head){
            Node temp=head;
            int count=0;
            while(temp != null){
                count++;
                temp=temp.next;
            }
            System.out.println("Length of the linked list is: " +count);
        }

        
       public static void main(String[] args){
        Node head = new Node(10);
        head.next=new Node(20);
        head.next.next = new Node(30);
        // displayr(head);
        lengthofli(head);
        System.out.println();
        // constructoroflinkedlist();
        display(head);
       }
    }
}
