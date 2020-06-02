package trees.binarysearchtrees.search;

public class SearchElementInBinarySearchTree {
    
    public Node search(Node root, int element){
        if(root == null) return new Node(-1);
        if(root.data == element){
            return root;
        }else if(root.data > element){
            return search(root.left, element);
        }else {
            return search(root.right, element);
        }
    }

    public static void main(String[] args) {
        SearchElementInBinarySearchTree binarySearchTree = new SearchElementInBinarySearchTree();
        System.out.println("Search element in binary search tree.");
        System.out.println("Creating a tree that satisfies the properties of a binary search tree.");
        
        Node root1 = new Node(20);
        root1.left = new Node(10);
        root1.right = new Node(30);
        root1.left.left = new Node(5);
        root1.left.right = new Node(15);
        root1.right.left = new Node(25);
        root1.right.right = new Node(40);
        System.out.println("binary search tree constructed.");
        
        Node element = binarySearchTree.search(root1, 25);
        System.out.println(element.data + "");

        Node element2 = binarySearchTree.search(root1, 95);
        System.out.println(element2.data + "");
    }
}

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }
}