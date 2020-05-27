package linkedlist.oddevenlinkedlist;

public class OddEvenLinkedList {

    public Node buildOddEvenLinkedList(Node head){

        if(head == null) return head;

        Node odd = head;
        Node oddHead = odd;
        Node even = head.next;
        Node evenHead = even;
        
        //build two lists.
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        //odd even lists are built. Now append even list to the end of odd;
        odd.next = evenHead;
        return oddHead;
    }
    
    public void print(Node head){
        if(head == null) return;
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        OddEvenLinkedList oddEven = new OddEvenLinkedList();

        System.out.println("Odd even linked list solution.");
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        System.out.println("Before creating odd even list.");
        oddEven.print(head);
        Node oddEvenList = oddEven.buildOddEvenLinkedList(head);
        System.out.println("After creating odd even list.");
        oddEven.print(oddEvenList);
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }

}