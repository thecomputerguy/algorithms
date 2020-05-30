package linkedlist.swapadjacentnodes;

public class SwapAdjacentNodes {
    
    public Node swapNodes(Node head){

        //Need atleast two nodes to swap. This check makes sure that we have atleast two nodes to swap,
        if(head == null || head.next == null) return head;
        Node temp = new Node(0);
        temp.next = head;
        Node current = temp;
               
        while(current.next != null && current.next.next != null){
            
            Node first = current.next;
            Node second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }

        return temp.next;
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
        SwapAdjacentNodes adjacentNodes = new SwapAdjacentNodes();
        System.out.println("Swap adjacent nodes in a linked list solution.");

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Node swappedNodesHead = adjacentNodes.swapNodes(head);
        adjacentNodes.display(swappedNodesHead);
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}