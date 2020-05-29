package linkedlist.linkedlistmidpoint;

public class LinkedListMidPoint {

    public Node findMidPoint(Node head){
        if(head == null) return head;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    
    public static void main(String[] args) {
        System.out.println("Linked list mid point solution.");
        LinkedListMidPoint solver = new LinkedListMidPoint();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        Node midPoint = solver.findMidPoint(head);
        System.out.println("Mid point is " + midPoint.data);
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}