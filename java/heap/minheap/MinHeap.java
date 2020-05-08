package heap.minheap;

public class MinHeap {

    int[] container = null;
    int size;
    int capacity;

    public MinHeap(int capacity){

        this.capacity = capacity;
        this.container = new int[this.capacity];
    }

    public void add(int item){

        if(isFull()){

            resize();
        }
        
        //Add the element to the container.
        this.container[this.size] = item;

        //Swim to the appropriate position. 
        swim(this.size);
        
        //Increment the size.
        this.size++;
    }

    public int remove(int item){

        //If emtpy, then throw an exception.
        if(isEmpty()){

            throw new IllegalStateException("Heap is empty!");
        }

        //search the element in the heap.
        //If the element is in the heap, then replace the element with the last element.
        //And decrement the size by one, so that we are not considering the last element in the heap.
        //Fix the heap above and below by simply using swim and sink methods. 
        //If the element is not in the heap, then throw an exception and terminate the flow.
        int itemIndex = search(item);
        if(itemIndex == -1){

            throw new IllegalArgumentException("Element is not in the heap!");
        }

        //Replace the element from the itemIndex with the last element in the heap.
        this.container[itemIndex] = this.container[this.size-1];
        this.size--;
        sink(itemIndex);
        swim(itemIndex);

        return item;
    }

    /**
     * if the item is in the array, then return index of the item. Otherwise, return -1
     * @param item
     * @return index
     */
    public int search(int item){
        //Sticking to linear search for now. Later if i find something better then i will update the method.
        if(isEmpty()){

            return -1;
        }

        int i = 0;
        while(i < this.size/2){

            if(this.container[i] == item){
                return i;
            }else if(this.container[2*i+1] == item){

                return 2*i+1;
            }else if(this.container[2*i+2] == item){

                return 2*i+2;
            }

            i++;
        }

        return -1;
    }

    /**
     * Displays all the elements in the heap using below format.
     * Parent
     *  /   \
     * left right
     */
    public void display(){

        if(isEmpty()){

            throw new IllegalStateException("Heap is empty!");
        }

        int i = 0;
        while(i < this.size/2){

            int leftChildIndex = getLeftChildIndex(i);
            int rightChildIndex = getRightChildIndex(i);
            int parent = this.container[i];

            int leftChild = Integer.MAX_VALUE;
            if(leftChildIndex > -1){
                leftChild = this.container[leftChildIndex];
            }

            int rightChild = Integer.MAX_VALUE;
            if(rightChildIndex > -1){

                rightChild = this.container[rightChildIndex];
            }

            System.out.println(String.format("Parent: %s , Left child: %s , Right child: %s ", parent, leftChild == Integer.MAX_VALUE ? "" : leftChild, rightChild == Integer.MAX_VALUE ? "" : rightChild));
            i++;
        }

    }

    /**
     * Moves the item down from it's current position if the item is not at its correct position.
     * start at the given index and swap the item with the smaller child untill the element is in it's correct position.
     * @param itemIndex
     */
    private void sink(int itemIndex){

        int smallerChildIndex = getLeftChildIndex(itemIndex); 
        
        if(smallerChildIndex < 0){

            return;
        }

        if(getLeftChildIndex(itemIndex) < getRightChildIndex(itemIndex) && this.container[smallerChildIndex] > this.container[getRightChildIndex(itemIndex)]){

            smallerChildIndex = getRightChildIndex(itemIndex);
        }

        if(this.container[smallerChildIndex] < this.container[itemIndex]){

            swap(itemIndex, smallerChildIndex);
            sink(smallerChildIndex);
        }

        return;
    }

    private void swim(int itemIndex){

        ensureWithInBounds(itemIndex);
        while(true){

            int parentIndex = getParentIndex(itemIndex);
            
            if(parentIndex < 0){
                
                return;
            }else if(parentIndex == 0 && this.container[parentIndex] <= this.container[itemIndex]){

                return;
            }
            else if(parentIndex == 0 && this.container[parentIndex] > this.container[itemIndex]){

                swap(itemIndex, parentIndex);
                return;
            }else if(this.container[parentIndex] > this.container[itemIndex]){

                swap(itemIndex, parentIndex);
                itemIndex = parentIndex;
            }

            return;
        }

    }

    private void swap(int itemIndex, int smallerChildIndex){

        int item = this.container[itemIndex];
        this.container[itemIndex] = this.container[smallerChildIndex];
        this.container[smallerChildIndex] = item;
    }

    private boolean isEmpty(){

        return size == 0;
    }

    private boolean isFull(){

        return size == capacity;
    }

    /**
     * Doubles the size of the container.
     */
    private void resize(){

        //Double the size.
        this.capacity = this.capacity*2;
        int[] temp = new int[this.capacity];
        copyElements(this.container, temp);
        this.container = temp;
        temp = null;
    }

    /**
     * given the index, it returns the index of the parent.
     * @param index
     * @return index of the parent
     */
    private int getParentIndex(int index){

        ensureWithInBounds(index);

        return (index-1)/2;
    }

    private int getLeftChildIndex(int index){

        ensureWithInBounds(index);

        if(2*index+1 >= this.size){

            return -1;
        }

        return 2*index+1;
    }

    private int getRightChildIndex(int index){

        ensureWithInBounds(index);

        if(2*index+2 >= this.size){

            return -1;
        }

        return 2*index+2;
    }

    private void ensureWithInBounds(int index){

        
        if(index < 0 && index >= this.size){
            
            throw new IllegalArgumentException("Index out of bounds!");
        }
    }

    private void copyElements(int[] source, int[] target){

        int i = 0;
        while(i < source.length){

            System.out.println("Copied " + source[i]);
            target[i] = source[i];
            i++;
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println("Creating min heap.");
        MinHeap heap = new MinHeap(5);
        System.out.println("Adding elements to heap");
        heap.add(10);
        System.out.println("Added 10");
        heap.add(20);
        System.out.println("Added 20");
        heap.add(30);
        System.out.println("Added 30");
        heap.add(25);
        System.out.println("Added 25");
        heap.add(50);
        System.out.println("Added 50");

        System.out.println("Elements in the heap are");
        heap.display();

        System.out.println("Remove elements from the heap.");
        System.out.println("Removing 20");
        heap.remove(20);

        System.out.println("Elements in the heap are");
        heap.display();

        System.out.println("Removing 10");
        heap.remove(10);

        System.out.println("Elements in the heap are");
        heap.display();

        System.out.println("Removing 50");
        heap.remove(50);

        System.out.println("Elements in the heap are");
        heap.display();

    }
}