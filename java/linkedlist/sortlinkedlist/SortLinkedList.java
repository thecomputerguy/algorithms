package linkedlist.sortlinkedlist;

public class SortLinkedList {

    public Node sortList(Node head){

        if(head == null || head.next == null) return head;
        
        Node leftEnd = head;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            leftEnd = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        leftEnd.next = null;
        Node leftSorted = sortList(head);
        Node rightSorted = sortList(slow);

        return merge(leftSorted, rightSorted);
    }

    private Node merge(Node leftSorted, Node rightSorted){
        Node sortedList = new Node(0);
        Node current = sortedList;

        while(leftSorted != null && rightSorted != null){
            if(leftSorted.data < rightSorted.data){
                current.next = leftSorted;
                current = current.next;
                leftSorted = leftSorted.next;
            }else{
                current.next = rightSorted;
                current = current.next;
                rightSorted = rightSorted.next;
            }
        }

        if(leftSorted != null) current.next = leftSorted;
        if(rightSorted != null) current.next = rightSorted;
        return sortedList.next;
    }
    
    public static void main(String[] args) {
        SortLinkedList sortLinkedList = new SortLinkedList();
        System.out.println("Sort linked list in o(nlogn) and constant space.");
        
        Node head = new Node(6);
        head.next = new Node(5);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        Node sortedList = sortLinkedList.sortList(head);
        Node current = sortedList;
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