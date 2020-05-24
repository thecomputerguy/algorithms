package linkedlist.reverselinkedlist;

import java.util.Scanner;

public class ReverseLinkedList {

    public Node reverse(Node head){

        if(head == null || head.next == null){
            return head;
        }

        
        Node current = head;
        //Reverse the list here.
        Node prev = null;
        while(current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
    
    public static void main(String[] args) {
        
        ReverseLinkedList reverse = new ReverseLinkedList();
        System.out.println("Enter the number of elements you wish to add in the linkedlist.");
        try(Scanner scan = new Scanner(System.in)){
            int num = scan.nextInt();
            if(num <= 0){
                System.out.println("You should have atleast 1 node in the list.");
                return;
            }
            int i = 1;
            System.out.println("Enter the first element:");
            int firstItem = scan.nextInt();
            Node head = new Node(firstItem);
            Node current = head;

            while(i < num){
                //Building the linkedlist to pass to reverse method.
                System.out.println("Enter next element:");
                int next = scan.nextInt();
                Node node = new Node(next);
                current.next = node;
                current = node;
                i++;
            }

            Node reversedList = reverse.reverse(head);
            Node pointer = reversedList;
            while(pointer != null){
                System.out.print(" " + pointer.data + " -> ");
                pointer = pointer.next;
            }
        }
    }
}

class Node{
     int data;
     Node next;

     public Node(int data){
        this.data = data;
     }
}