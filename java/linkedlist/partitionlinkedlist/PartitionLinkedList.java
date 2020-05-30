package linkedlist.partitionlinkedlist;

public class PartitionLinkedList{

    public Node partition(Node head, int x){

        if(head == null) return head;

        Node beforeHead = new Node(0);
        Node afterHead = new Node(0);
        Node before = beforeHead;
        Node after = afterHead;
        Node current = head;

        while(current != null){

            if(current.data < x){
                before.next = current;
                before = before.next;
            }else{
                after.next = current;
                after = after.next;
            }
            current = current.next;
        }
        
        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }

    public void display(Node head){
        
        if(head == null) return;

        Node current = head;

        while(current != null){ 
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        PartitionLinkedList partitionLinkedList = new PartitionLinkedList();
        
        Node head = new Node(6);
        head.next = new Node(5);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        Node partitionedHead = partitionLinkedList.partition(head, 3);        
        partitionLinkedList.display(partitionedHead);
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}