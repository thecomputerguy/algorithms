package queuewithtwostacks;

import java.util.Stack;

public class QueueWithTwoStacks {
    
    Stack<Integer> newItems = new Stack<Integer>();
    Stack<Integer> oldItems = new Stack<Integer>();

    public void enqueue(Integer item){

        //Check if the item received is null. If it is null, then simply return.
        if(item == null){
            return;
        }
        oldItems.push(item);
    }

    public Integer dequeue(){

        shiftItems();
        return newItems.pop();
    }

    private void shiftItems(){
        
        if(newItems.isEmpty()){
            if(oldItems.isEmpty()){
                throw new IllegalStateException("Can't dequeue from an empty queue.");
            }
            while(!oldItems.isEmpty()){
                newItems.push(oldItems.pop());
            }
        }
    }

    public Integer peek(){

        shiftItems();
        return newItems.peek();
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