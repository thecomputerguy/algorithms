package tries.solvecontacts;

import java.util.Scanner;

public class SolveContacts {
 
    public static void main(String[] args) {
        
        System.out.println("Constructing a trie.");
        try(Scanner scan = new Scanner(System.in)){

            int i = 0;
            Node node = new Node();
            while(i < 5){

                System.out.println("Enter a word to add to trie...");
                String line = scan.nextLine();
                node.add(line);
                System.out.println(String.format("Added %s to trie.", line));
                i++;
            }
            
            System.out.println("Enter a prefix to find count of contacts that start with a given prefix.");
            String prefix = scan.nextLine();
            System.out.println("Finding count with prefix.");
            int count = node.findCount(prefix);
            System.out.println(String.format("Found %s contacts with prefix %s", count, prefix));
        }
    }
}

class Node{

    private static final int CHARACTERS_SUPPORTED = 26;
    private Node[] children = new Node[CHARACTERS_SUPPORTED];
    private int size;

    private int getIndex(char c){

        //this is to map the character inside the node to an index with in the range 0-25.
        return c-'a';
    }

    public void add(String value){

        add(value, 0);
    }

    private void add(String value, int index){

        this.size++;
        if(value.length() == index){

            return;
        }
        char c = value.charAt(index);
        Node child = this.children[getIndex(c)];
        
        //Only adds the child if the child does not exist.
        //If the child exists, then simply navigate to that child.
        if(child == null){
            child = new Node();
            this.children[getIndex(c)] = child;
        }

        child.add(value, index+1);
    }
    
    public int findCount(String prefix){

        return findCount(prefix, 0);
    }

    private int findCount(String prefix, int index){

        if(prefix.length() == index){

            return this.size++;
        }

        char c = prefix.charAt(index);
        Node child = this.children[getIndex(c)];
        if(child == null){

            return 0;
        }

        return child.findCount(prefix, index+1);
    }
}