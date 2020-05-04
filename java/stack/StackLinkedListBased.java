package stack;

import java.util.LinkedList;
import java.util.List;

public class StackLinkedListBased {
    
    private List<Integer> container = new LinkedList<Integer>();
    
    public boolean isEmtpy(){

        return container.isEmpty();
    }

    public void push(Integer item){

        container.add(item);
    }

    public Integer pop(){

        if(container.isEmpty()){

            throw new IllegalStateException("Stack is empty.");
        }

        return container.remove(container.size() - 1);
    }

    public Integer peek(){

        if(container.isEmpty()){

            throw new IllegalStateException("Stack is empty!");
        }
        return container.get(container.size() - 1);
    }


    public static void main(String[] args) {
 
        System.out.println("Creating stack.");
        StackLinkedListBased stack = new StackLinkedListBased();
        
        System.out.println("Pushing elements to the top of stack.");
        stack.push(10);
        System.out.println(String.format("pushed %s", stack.peek()));
        stack.push(20);
        System.out.println(String.format("pushed %s", stack.peek()));
        stack.push(50);
        System.out.println(String.format("pushed %s", stack.peek()));
        stack.push(40);
        System.out.println(String.format("pushed %s", stack.peek()));
        stack.push(30);
        System.out.println(String.format("pushed %s", stack.peek()));
        
        System.out.println("Popping elements off the stack.");
        System.out.println(String.format("popping %s", stack.pop()));
        System.out.println(String.format("Now at top %s", stack.peek())); 
        System.out.println(String.format("popping %s", stack.pop()));
        System.out.println(String.format("Now at top %s", stack.peek()));
        System.out.println(String.format("popping %s", stack.pop()));
        System.out.println(String.format("Now at top %s", stack.peek()));
        System.out.println(String.format("popping %s", stack.pop()));
        System.out.println(String.format("Now at top %s", stack.peek()));
            
    }
}