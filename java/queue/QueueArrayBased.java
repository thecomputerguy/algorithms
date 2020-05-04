package queue;

public class QueueArrayBased {
    
    private int size;
    private int capacity;
    private int front;
    private int rear = -1;
    private Integer[] container = null;

    public QueueArrayBased(int capacity){

        this.size = 0;
        this.capacity = capacity;
        this.container = new Integer[capacity];
    }

    public boolean isEmpty(){

        return this.size == 0;
    }

    public boolean isFull(){

        return this.size == this.capacity;
    }

    public void enqueue(Integer item){

        if(isFull()){

            throw new IllegalStateException("Queue is full!");
        }
        
        this.size++;
        this.rear++;
        this.container[this.rear] = item;
    }

    public Integer dequeue(){

        if(isEmpty()){

            throw new IllegalStateException("Queue is empty!");
        }

        this.size--;
        return this.container[this.front++];
    }

    public Integer peekOld(){

        if(isEmpty()){

            throw new IllegalStateException("Queue is empty!");
        }

        return this.container[this.front];
    }

    public Integer peekNew(){

        if(isEmpty()){

            throw new IllegalStateException("Queue is empty!");
        }

        return this.container[this.rear];
    }

    public static void main(String[] args) {
        
        System.out.println("Creating LinkedList based queue.");
        QueueArrayBased queue = new QueueArrayBased(10);
        System.out.println("Enqueue elements.");
        queue.enqueue(10);
        System.out.println(String.format("enqueued %s", queue.peekNew()));
        queue.enqueue(20);
        System.out.println(String.format("enqueued %s", queue.peekNew()));
        queue.enqueue(30);
        System.out.println(String.format("enqueued %s", queue.peekNew()));
        queue.enqueue(40);
        System.out.println(String.format("enqueued %s", queue.peekNew()));


        System.out.println("Dequeue elements.");
        System.out.println(String.format("dequeued %s", queue.dequeue()));
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
        System.out.println(String.format("dequeued %s", queue.dequeue()));
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
        System.out.println(String.format("dequeued %s", queue.dequeue()));
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
    }


}