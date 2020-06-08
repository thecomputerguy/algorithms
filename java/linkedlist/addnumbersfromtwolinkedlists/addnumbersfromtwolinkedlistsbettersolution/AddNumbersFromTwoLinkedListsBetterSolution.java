package linkedlist.addnumbersfromtwolinkedlists.addnumbersfromtwolinkedlistsbettersolution;

public class AddNumbersFromTwoLinkedListsBetterSolution {
    
    public Node addNumbers(Node l1, Node l2){

        Node dummy = new Node(-1);
        Node l3 = dummy;

        int carry = 0;
        while(l1 != null || l2 != null){
            int firstNumber = (l1 != null) ? l1.data : 0;
            int secondNumber = (l2 != null) ? l2.data : 0;
            int currentSum = firstNumber + secondNumber + carry;

            carry = currentSum / 10;
            int lastDigit = currentSum % 10;
            l3.next = new Node(lastDigit);
            l3 = l3.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry > 0) {
            l3.next = new Node(carry);
            l3 = l3.next;
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
        
        AddNumbersFromTwoLinkedListsBetterSolution add = new AddNumbersFromTwoLinkedListsBetterSolution();
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

        Node result = add.addNumbers(head1, head2);
        add.display(result);
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}