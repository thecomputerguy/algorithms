package linkedlist.cycledetection;

public class LinkedListCycleDetection {
    private Node head;
    private int size;

    public void insertFirst(int item){

        //Create a new node with given data.
        Node newNode = new Node(item);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    public void insertLast(int item){

        //Create a new node with given data.
        Node newNode = new Node(item);

        if(isEmpty()){

            this.head = newNode;
            this.size++;
            return;
        }

        //Start from head and move to the last node.
        Node current = this.head;
        
        //go through all the nodes till the current.next != null.
        //When current.next == null, we know we have reached the last node.
        while(current.next != null){
            current = current.next;
        }

        current.next = newNode;
        this.size++;
    }

    public void insert(int item, int index){

        //Index with in the bounds of the linkedlist.
        if(index < 0 || index > size - 1){

            throw new IllegalArgumentException("Index out of bounds.");
        }

        if(index == 0){

            Node newNode = new Node(item);
            newNode.next = this.head;
            this.head = newNode;
            size++;
            return;
        }

        Node current = this.head;
        int position = 1;
        while(position < index){

            //By checking the bounds above in the first statement, 
            //we made sure that index will be witin bounds always.
            current = current.next;
            position++;
        }

        //Reached the position to insert.
        Node newNode = new Node(item);
        newNode.next = current.next;
        current.next = newNode;
        this.size++;
    }

    /**
     * Inserts an item after the given node. 
     * If the node is not present in the linkedlist then throws an exception.
     * @param item
     * @param node
     */
    public void insertAfter(int item, Node node){

        if(node == null){

            throw new IllegalArgumentException("Given node cannot be null.");
        }

        if(isEmpty()){

            throw new IllegalStateException("LinkedList is empty! Illegal operation. :P");
        }

        //search for the given node.
        Node current = this.head;
        while(current.data != item && current != null){

            current = current.next;
        }

        if(current == null){

            throw new IllegalArgumentException("Given node does not exist in linkedlist.");
        }

        //If we reach here, then we know that we have found the node after which we want to insert our new node.
        Node newNode = new Node(item);
        newNode.next = current.next;
        current.next = newNode;
        this.size++;
    }

    /**
     * Inserts the node before the given node.
     * @param item
     * @param node
     */
    public void insertBefore(int item, Node node){

        if(node == null){

            throw new IllegalArgumentException("Node is null.");
        }

        if(isEmpty()){

            throw new IllegalStateException("LinkedList is empty!");
        }


        Node current = this.head;
        //Create a new node.
        Node newNode = new Node(item);

        //Given node is head node, so we need to adjust head once we insert new node before head.
        if(node.data == current.data){

            newNode.next = this.head;
            this.head = newNode;
            return;
        }

        while(current.next.data != node.data && current.next.next != null){
            current = current.next;
        }

        //If we have reached here, we have two cases, 
        //either current is the node that we are looking for or the given node doesn't exist.
        if(current.next.data != node.data){

            throw new IllegalArgumentException("Given node doesn't exist in the linkedlist.");
        }

       //If we are here, then current.next node is the node before which we have to insert the new node.
       newNode.next = current.next;
       current.next = newNode;
       this.size++;
    }

    public Node search(int item){

        if(isEmpty()){

            throw new IllegalStateException("LinkedList is empty!");
        }

        Node current = this.head;

        while(current.data != item && current.next != null){

            current = current.next;
        }

        if(current.data != item){

            throw new IllegalArgumentException("Given item doesn't exist in linkedlist.");
        }

        return current;
    }

    public Node removeFirst(){

        if(isEmpty()){

            throw new IllegalStateException("LinkedList is empty!");
        }

        Node current = this.head;
        this.head = this.head.next;
        this.size--;
        return current;
    }

    public Node removeLast(){

        if(isEmpty()){

            throw new IllegalStateException("LinkedList is empty!");
        }

        //Only one element in the LinkedList.
        if(this.head.next == null){

            Node current = this.head;
            this.head = null;
            return current;
        }

        //More than one element in the LinkedList.
        Node current = this.head;
        while(current.next.next != null){

            current = current.next;
        }

        //Reached the last element
        Node temp = current.next;
        current.next = null;
        this.size--;
        return temp;
    }

    public Node remove(int data){

        if(isEmpty()){

            throw new IllegalStateException("LinkedList is empty!");
        }

        if(this.head.data == data){

            Node temp = this.head;
            this.head = this.head.next;
            return temp;
        }

        //search for the node that contains given data.
        Node current = this.head;
        while(current.next != null && current.next.data != data){

            current = current.next;
        }

        //Check If current's next is null. If it is null, then we know the node with given data doesn't exist.
        //Otherwise, point to the next node with a temporary variable and then point current.next to null.
        if(current.next == null){

            throw new IllegalArgumentException("Node with given data doesn't exist.");
        }

        Node temp = current.next;
        current.next = current.next.next;
        this.size--;
        return temp;
    }

    public Node remove(Node node){

        if(isEmpty()){

            throw new IllegalStateException("LinkedList is empty!");
        }

        if(node == null){

            throw new IllegalArgumentException("Node is null.");
        }

        if(this.head.data == node.data){

            Node temp = this.head;
            this.head = this.head.next;
            return temp;
        }

        Node current = this.head;
        while(current.next != null && current.next.data != node.data){

            current = current.next;
        }

        if(current.next == null){

            throw new IllegalArgumentException("Node doesn't exist in the linkedlist.");
        }

        Node temp = current.next;
        current.next = current.next.next;
        this.size--;
        return temp;
    }

    public boolean isEmpty(){

        return this.head == null;
    }

    public void display(){
        
        if(isEmpty()){

            System.out.println("LinkedList is empty!");
            return;
        }

        Node current = this.head;

        System.out.println("Remaining elements in the linkedlist are:");
        while(current != null){

            System.out.println(current.data);
            current = current.next;
        }
    }

    public boolean containsCycle(){
        
        if(this.head == null){

            return false;
        }

        Node slow = this.head;
        Node fast = this.head.next;

        while(fast != null && fast.next != null && slow != null){

            if(slow == fast){

                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public static void main(String[] args) {
        
        System.out.println("Creating LinkedList...");
        LinkedListCycleDetection list = new LinkedListCycleDetection();
        System.out.println("Created LinkedList.");
        System.out.println("Inserting elements in the LinkedList.");
        list.insertLast(10);
        System.out.println(String.format("Inserted %s at the end", 10));
        list.display();
        list.insertLast(20);
        System.out.println(String.format("Inserted %s at the end", 20));
        list.display();
        list.insertFirst(50);
        System.out.println(String.format("Inserted %s in the beginning", 50));
        list.display();
        list.insert(30, 2);
        System.out.println(String.format("Inserted %s at index %s", 30, 2));
        list.display();

        System.out.println();
        System.out.println();
        System.out.println("Contains cycle: " + list.containsCycle());
        System.out.println();
        System.out.println();

        System.out.println("Remove elements from list.");
        System.out.println(String.format("Removed %s", list.remove(30).data));
        list.display();
        System.out.println(String.format("Removed %s", list.removeFirst().data));
        list.display();
        System.out.println(String.format("Removed %s", list.removeLast().data));
        list.display();
        System.out.println(String.format("Removed %s", list.remove(new Node(10)).data));
        list.display();
    }
}

class Node{
    
    int data;
    Node next;
    
    public Node(int data){

        this.data = data;
    } 
}