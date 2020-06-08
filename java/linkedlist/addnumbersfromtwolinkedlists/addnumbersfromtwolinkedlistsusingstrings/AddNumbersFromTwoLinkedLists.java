package linkedlist.addnumbersfromtwolinkedlists.addnumbersfromtwolinkedlistsusingstrings;

public class AddNumbersFromTwoLinkedLists {
    
    public Node addUsingStrings(Node node1, Node node2){

        if(node1 == null) return node2;
        if(node2 == null) return node1;

        Node current1 = node1;
        Node current2 = node2;
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();

        extractValue(first, second, current1, current2);

        int firstNumber = Integer.valueOf(first.toString());
        int secondNumber = Integer.valueOf(second.toString());
        int thirdNumber = firstNumber + secondNumber;
        return reverseAndBuildLinkedList(thirdNumber);
    }

    private void extractValue(StringBuilder first, StringBuilder second, Node current1, Node current2){

        while(current1 != null && current2 != null){
            first.insert(0, current1.data);
            second.insert(0, current2.data);
            current1 = current1.next;
            current2 = current2.next;
        }

    }

    private Node reverseAndBuildLinkedList(int thirdNumber){

        System.out.println("Third Number is " + thirdNumber);
        Node dummy = new Node(-1);
        Node current = dummy;
        while(thirdNumber != 0){

            int digit = thirdNumber % 10;
            current.next = new Node(digit);
            current = current.next;
            thirdNumber = thirdNumber / 10;
        }
        return dummy.next;
    }
    
    public void display(Node node){
        if(node == null) return;

        Node current = node;
        while(current != null){

            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        
        AddNumbersFromTwoLinkedLists addNumbers = new AddNumbersFromTwoLinkedLists();
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

        Node result  = addNumbers.addUsingStrings(head1, head2);
        addNumbers.display(result); 
    }
}

class Node{

    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}