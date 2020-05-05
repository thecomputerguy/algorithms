package trees.selfbalancingtrees.avltrees;

public class AVLTree {

    private Node root;

    private void insert(int item){


    }

    public Node insert(Node node, int item){

        return null;
    }

    public Node search(int item){

        return null;
    }

    public Node search(Node node, int item){

        return null;
    }

    public Node remove(int item){

        return null;
    }

    public Node remove(Node node, int item){

        return null;
    }

    private boolean isEmpty(){

        return true;
    }

    private int digLeft(Node node){

        return 0;
    }

    private int digRight(Node node){

        return 0;
    }

    private int height(Node node){

        return 0;
    }

    private void rebalance(){

    }

    private int balanceFactor(){

        return 0;
    }

    public static void main(String[] args) {
        
        System.out.println("Creating binary search tree.");
        AVLTree avlTree = new AVLTree();

        System.out.println("Insert into the tree.");
        avlTree.insert(10);
        System.out.println("Inserted " + 10);
        avlTree.insert(50);
        System.out.println("Inserted " + 50);
        avlTree.insert(100);
        System.out.println("Inserted " + 100);
        avlTree.insert(85);
        System.out.println("Inserted " + 85);
        avlTree.insert(60);
        System.out.println("Inserted " + 60);

        System.out.println("Search 60");
        System.out.println("Found " + avlTree.search(60));
        System.out.println("Search 40");
        System.out.println("Found " + avlTree.search(40));

        System.out.println("Remove " + 60);
        avlTree.remove(60);
        System.out.println("Search 60");
        System.out.println("Found " + avlTree.search(60));
        
        System.out.println("Remove " + 55);
        avlTree.remove(55);
        System.out.println("Search 55");
        System.out.println("Found " + avlTree.search(55));
    }
}

class Node{

    int data;

    Node left, right;

    public Node(int data){

        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String toString(){
 
        return " " + this.data;
    }
}