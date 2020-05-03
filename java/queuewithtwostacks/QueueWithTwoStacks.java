package queuewithtwostacks;

import java.util.Stack;

public class QueueWithTwoStacks {
    
    Stack<Integer> newItems = new Stack<Integer>();
    Stack<Integer> oldItems = new Stack<Integer>();

    public void enqueue(Integer value){

    }

    public Integer dequeue(){

        return null;
    }

    public Integer peek(){

        return null;
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        System.out.println("Building queue.");
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(10);
        queue.enqueue(50);
        queue.enqueue(45);
        System.out.println("Removed : " + queue.dequeue());
        System.out.println("Removed : " + queue.dequeue());
        System.out.println("peeked : " + queue.peek());
        System.out.println("Removed : " + queue.dequeue());
        System.out.println("peeked : " + queue.peek());
    }
}