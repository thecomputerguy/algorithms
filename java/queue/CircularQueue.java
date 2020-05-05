package queue;

public class CircularQueue {

    int capacity, size = 0;
    int front, rear = -1;
    int[] container = null;

    public CircularQueue(int capacity){

        this.capacity = capacity;
        this.container = new int[capacity];
    }

    public void enqueue(int item){

        //First we check if the queue is full.
        //If it is then throw an exception. Otherwise, add new element in the rear.
        if(isFull()){

            throw new IllegalStateException("Queue is full!");
        }

        if(isEmpty()){

            //rear and front is initially at position -1
            rear++;
            front++;
            size++;

            container[rear] = item;
            return;
        }

        if(rear == capacity-1 && front != 0){

            rear = 0;
            container[rear] = item;
            size++;
            return;
        }

        container[++rear] = item;
        size++;

    }

    public int dequeue(){

        if(isEmpty()){

            throw new IllegalStateException("Queue is empty!");
        }

        if(rear == front){

            int item  = container[rear];
            front = rear = -1;
            size--;
            return item;
        }

        if(front == capacity-1){

            int item = container[front];
            front = 0;
            size--;
            return item;
        }

        int item = container[front++];
        size--;
        return item;
    }

    public boolean isEmpty(){

        return front == -1 && rear == -1;
    }

    public boolean isFull(){

        if((front == 0 && rear == capacity-1) || rear == (front-1 % capacity-1)){

            return true;
        }

        return false;
    }

    public void display(){

        if(isEmpty()){
            
            throw new IllegalStateException("Queue is empty!");
        }

        if(front <= rear){

            for(int i = front; i <= rear; i++){

                System.out.println(container[i]);
            }
        }else{

            for(int i = front; i < capacity; i++){

                System.out.println(container[i]);
            }

            for(int j = 0; j <= rear; j++){

                System.out.println(container[j]);
            }
        }

    }

    public int peekNew(){

        if(isEmpty()){

            throw new IllegalStateException("Queue is empty!");
        }

        return container[rear];
    }

    public int peekOld(){

        if(isEmpty()){

            throw new IllegalStateException("Queue is empty!");
        }

        return container[front];
    }

    public static void main(String[] args) {
        
        System.out.println("Creating an instance of circular queue!");
        CircularQueue queue = new CircularQueue(10);
        
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
        System.out.println(String.format("dequeued %s", queue.dequeue()));
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
    }
}