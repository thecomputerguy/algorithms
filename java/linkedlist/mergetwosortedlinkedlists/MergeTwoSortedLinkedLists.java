package linkedlist.mergetwosortedlinkedlists;

public class MergeTwoSortedLinkedLists {

    
    public Node merge(Node head1, Node head2){

        if(head1 == null) return head2;
        if(head2 == null) return head1;

        Node current1 = head1;
        Node current2 = head2;
        Node result = new Node(0);
        Node resultHead = result;

        while(current1 != null && current2 != null){
            if(current1.data <= current2.data){
                result.next = current1;
                result = result.next;
                current1 = current1.next;
            }else{
                result.next = current2;
                result = result.next;
                current2 = current2.next;
            }
        }

        if(current1 != null){
            result.next = current1;
        }else if(current2 != null){
            result.next = current2;
        }

        return resultHead.next;
    }

    public static void main(String[] args) {
        System.out.println("Merge two sorted linked lists solution.");
        MergeTwoSortedLinkedLists merger = new MergeTwoSortedLinkedLists();
        
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        
        
        Node head2 = new Node(7);
        head2.next = new Node(8);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(10);
        head2.next.next.next.next = new Node(11);
        head2.next.next.next.next.next = new Node(12);

        Node headOfMergedLists = merger.merge(head1, head2);

        Node current = headOfMergedLists;

        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
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