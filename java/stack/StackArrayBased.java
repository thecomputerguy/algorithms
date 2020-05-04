package stack;

public class StackArrayBased {

    private int capacity;
    private int size;
    private int top;
    private int[] container = null;

    StackArrayBased(int capacity){

        this.capacity = capacity;
        this.container = new int[this.capacity];
        this.size = 0;
        this.top = -1;
    }

    public boolean isEmpty(){

        return this.size == 0;
    }

    public boolean isFull(){

        return size == capacity; 
    }

    public int pop(){

        if(isEmpty()){

            throw new IllegalStateException("Stack is empty.");
        }
        this.size--;
        return container[this.top--];
    }

    public void push(int item){

        if(isFull()){

            throw new IllegalStateException("Stack is full.");
        }
        this.size++;
        this.container[++this.top] = item;
    }

    public int peek(){

        if(isEmpty()){

            throw new IllegalStateException("Stack is empty!");
        }
        return this.container[this.top];
    }

    public static void main(String[] args) {
        System.out.println("Creating stack.");
        int initialCapacity = 10;
        StackArrayBased stack = new StackArrayBased(initialCapacity);
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