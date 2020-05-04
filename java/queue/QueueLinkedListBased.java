package queue;

import java.util.LinkedList;

public class QueueLinkedListBased {
    
    private LinkedList<Integer> container = new LinkedList<>();
    
    public boolean isEmpty(){

        return container.isEmpty();
    }

    public void enqueue(Integer item){


        container.add(item);
    }

    public Integer dequeue(){

        if(container.isEmpty()){

            throw new IllegalStateException("Queue is empty!");
        }

        return container.remove(0);
    }

    public Integer peekNew(){

        if(container.isEmpty()){

            throw new IllegalStateException("Queue is empty!");
        }

        return container.get(container.size() - 1);
    }

    public Integer peekOld(){

        if(container.isEmpty()){
            throw new IllegalStateException("Queue is empty!");
        }

        return container.get(0);
    }

    public static void main(String[] args) {
 
        System.out.println("Creating LinkedList based queue.");
        QueueLinkedListBased queue = new QueueLinkedListBased();
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