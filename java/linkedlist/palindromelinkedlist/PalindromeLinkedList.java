package linkedlist.palindromelinkedlist;

import java.util.Scanner;

public class PalindromeLinkedList {

    public boolean isPalindrome(Node head){
        if(head == null) return false;

        //traverse the linked list with slow and fast pointer.
        Node slow = head;
        Node fast = head;
        Node start = head;
        //Move the fast pointer to the end of the list.
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse the second half of the linkedlist.
        Node mid = slow;
        Node reverseStart = reverse(slow);
        while(start != null && start != mid && reverseStart != null){

            if(start.data != reverseStart.data){
                return false;
            }
            start = start.next;
            reverseStart = reverseStart.next;
        }
        return true;
    }

    private Node reverse(Node start){
        
        Node prev = null;
        Node current = start;
        while(current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }   


    
    public static void main(String[] args) {
        PalindromeLinkedList palindrome = new PalindromeLinkedList();

        try(Scanner scan = new Scanner(System.in)){

            System.out.println("Enter the number of elements you wish to add to a linkedlist.");
            int num = scan.nextInt();
            int i = 1;
            System.out.println("Enter the first element in the node:");
            char first = scan.next().charAt(0);
            Node head = new Node(first);
            Node current = head;
            while(i < num){
                //Build the linkedlist.
                System.out.println("Enter the next element:");  
                char next = scan.next().charAt(0);
                Node node = new Node(next);
                current.next = node;
                i++;
            }

            System.out.println("palindrome: " + palindrome.isPalindrome(head));
        }
    }
}

class Node{
    char data;
    Node next;
    public Node(char data){
        this.data = data;
    }
}