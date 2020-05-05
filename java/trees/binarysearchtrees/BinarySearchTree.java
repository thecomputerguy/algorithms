package trees.binarysearchtrees;

public class BinarySearchTree {

    private Node root;
    
    public void insert(int item){

        if(isEmpty()){

            this.root = new Node(item);
            return;
        }

        if(item < this.root.data){

            this.root.left = insert(this.root.left, item);
        }else{
            
            this.root.right = insert(this.root.right, item);
        }

    }

    private Node insert(Node node, int item){

        if(node == null){

            return new Node(item);
        }

        if(node.data > item){

            node.left = insert(node.left, item);
        }else{

            node.right = insert(node.right, item);
        }

        return node;
    }

    public Node search(int item){

        if(isEmpty()){

            throw new IllegalStateException("Tree is empty!");
        }

        if(this.root.data == item){

            return this.root;
        }else if(this.root.data < item){

            return search(this.root.right, item);
        }

        return search(this.root.left, item);
    }

    public Node search(Node node, int item){

        if(node == null){

            return null;
        }

        if(node.data == item){

            return node;
        }else if(node.data > item){

            return search(node.left, item);
        }

        return search(node.right, item);
    }

    public Node remove(int item){

        if(isEmpty()){

            throw new IllegalStateException("Tree is empty!");
        }

        this.root = remove(this.root, item);

        return this.root;
    }

    public Node remove(Node node, int item){

        if(node == null){

            return null;
        }

        if(node.data > item){

            node.left = remove(node.left, item);

        }else if(node.data < item){

            node.right = remove(node.right, item);
        
        }else{

            //we have found the node that we want to remove.

            if(node.left == null){
                
                node = node.right;
            }else if(node.right == null){

                node = node.left;
            }else{

                node.data = digRight(node.right);
                node.right = remove(node.right, item);
            }

        }

        return node;
    }

    private int digRight(Node right) {

        //Dig as far left as possible to get the smallest value from the right subtree.
        Node current = right;
        while(current.left != null){

            current = current.left;
        }

        return current.data;
    }

    private int digLeft(Node left){

        //Dig as far right as possible to get the biggest value from the left subtree.
        Node current = left;
        while(current.right != null){

            current = current.right;
        }

        return current.data;
    }

    public boolean isEmpty() {
        
        return this.root == null;
    }

    public static void main(String[] args) {
        
        System.out.println("Creating binary search tree.");
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        System.out.println("Insert into the tree.");
        binarySearchTree.insert(10);
        System.out.println("Inserted " + 10);
        binarySearchTree.insert(50);
        System.out.println("Inserted " + 50);
        binarySearchTree.insert(100);
        System.out.println("Inserted " + 100);
        binarySearchTree.insert(85);
        System.out.println("Inserted " + 85);
        binarySearchTree.insert(60);
        System.out.println("Inserted " + 60);

        System.out.println("Search 60");
        System.out.println("Found " + binarySearchTree.search(60));
        System.out.println("Search 40");
        System.out.println("Found " + binarySearchTree.search(40));

        System.out.println("Remove " + 60);
        binarySearchTree.remove(60);
        System.out.println("Search 60");
        System.out.println("Found " + binarySearchTree.search(60));
        
        System.out.println("Remove " + 55);
        binarySearchTree.remove(55);
        System.out.println("Search 55");
        System.out.println("Found " + binarySearchTree.search(55));
    }
    
}

class Node{
    
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String toString(){
 
        return " " + this.data;
    }
}