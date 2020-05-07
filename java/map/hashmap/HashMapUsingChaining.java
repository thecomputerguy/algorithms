package map.hashmap;
import java.util.LinkedList;

public class HashMapUsingChaining {
    
    private LinkedList<Node>[] container = null;
    private int capacity;
    private float loadFactor = 0.75F;
    private int size;

    @SuppressWarnings("unchecked")
    public HashMapUsingChaining(int initialCapacity){
        
        this.capacity = initialCapacity;
        this.container = (LinkedList<Node>[]) new LinkedList[this.capacity];
    }

    public HashMapUsingChaining(LinkedList<Node>[] container, int capacity, float loadFactor) {
        
        this.container = container;
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }

    public void put(String key, int value){

        if(key == null || key.isEmpty()){

            throw new IllegalArgumentException("Key is null or empty!");
        }

        int threshold = (int) (this.capacity * this.loadFactor);
        if(size >= threshold){
            resize();
        }

        //Get the index in the container to put the value there
        int index = hash(key);
        LinkedList<Node> link = this.container[index];
        
        //If the link at the given index is null then create a new linkedlist and add to that index.
        if(link == null){
            LinkedList<Node> linkedList = new LinkedList<>();
            linkedList.add(new Node(key, value));
            this.container[index] = linkedList;
            this.size++;
            return;
        }

        int i = 0;
        Node newNode = new Node(key, value);
        while(i < link.size()){

           Node existingNode = link.get(i);
            
           if(existingNode.key.equals(key)){
                
                link.add(i, newNode);
                return;
            }

            i++;
        }

        this.size++;
        link.add(newNode);
        return;
    }

    public Integer get(String key){

        if(key == null || key.isEmpty()){

            throw new IllegalArgumentException("Key is empty or null!");
        }

        int index = hash(key);
        LinkedList<Node> linkedList = this.container[index];
        
        if(linkedList == null){
            
            return null;
        }

        int i = 0;
        while(i < linkedList.size()){

           Node item = linkedList.get(i);
            if(item.key.equals(key)){
                return item.data;
            }

            i++;
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize(){

        this.capacity = this.capacity * 2;
        LinkedList<Node>[] temp = (LinkedList<Node>[]) new LinkedList[this.capacity];
        copyElements(this.container, temp);
        this.container = temp;
    }

    private void copyElements(LinkedList<Node>[] source, LinkedList<Node>[] target){

        if(source == null || source.length == 0){

            throw new IllegalStateException("Source is empty!");
        }

        for (LinkedList<Node> linkedList : source) {
            
            for (Node node : linkedList) {
                
                int index = hash(node.key);
                LinkedList<Node> link = target[index];
                
                if(link == null){
                    
                    link = new LinkedList<>();
                }

                int i = 0;
                while(i < link.size()){
                    
                    Node existingNode = link.get(i);
                    if(existingNode.key.equals(node.key)){
                        link.add(i, node);
                    }

                    i++;
                }

                link.add(node);
            }
        }

    }

    public Integer remove(String key){

        if(key == null || key.isEmpty()){

            throw new IllegalArgumentException("Key is null or empty!");
        }

        int index = hash(key);
         LinkedList<Node> list = this.container[index];
         if(list == null){

            return null;
         }

         for (Node node : list) {
    
            if(node.key.equals(key)){

                list.remove(node);
                this.size--;
                return node.data;
            }
         }
         
         return null;
    }

    private boolean isEmpty(){

        return this.size == 0;
    }

    private int hash(String key){

        return (key.length()*3) % this.capacity;
    }

    public static void main(String[] args) {
     
        System.out.println("Creating HashMap using chaining!");
        HashMapUsingChaining hashMapUsingChaining = new HashMapUsingChaining(10);
        System.out.println("Add few items to the hashmap");
        System.out.println("Adding varun and 50");
        hashMapUsingChaining.put("varun", 50);
        System.out.println("Adding sharma and 20");
        hashMapUsingChaining.put("sharma", 20);
        System.out.println("Adding keepcoding and 75");
        hashMapUsingChaining.put("keepcoding", 75);

        System.out.println("Get varun");
        System.out.println("Got " + hashMapUsingChaining.get("varun"));
        System.out.println("Get sharma");
        System.out.println("Got " + hashMapUsingChaining.get("sharma"));
        System.out.println("Get something");
        System.out.println("Got " + hashMapUsingChaining.get("something"));
        
        System.out.println("Remove items from hashmap");
        System.out.println("Remove sharma");
        System.out.println("Removed sharma which had the value " + hashMapUsingChaining.remove("sharma"));
    
        System.out.println("Remove varun");
        System.out.println("Removed varun which had the value " + hashMapUsingChaining.remove("varun"));

        System.out.println("Try to get the removed value from the hashmap.");
        System.out.println("Getting varun ");
        System.out.println("Got " + hashMapUsingChaining.get("varun"));
    
    }

}

class Node{

    String key;
    Integer data;

    public Node(String key, Integer data){

        this.data = data;
        this.key = key;
    }
}