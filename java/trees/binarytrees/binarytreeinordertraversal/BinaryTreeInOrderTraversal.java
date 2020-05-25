package trees.binarytrees.binarytreeinordertraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

public List<Node> inOrderTraversal(Node root){
    
    List<Node> output = new ArrayList<>();
    if(root == null) return output;

    //Fill the output array with node in by using inorder traversal.
    inOrderTraversalRec(root, output);
    return output;
}

public void inOrderTraversalRec(Node node, List<Node> output){

    //stop recursion when base condition is hit.
    if(node == null) return;
    inOrderTraversalRec(node.left, output);
    output.add(node);
    inOrderTraversalRec(node.right, output);
}

public List<Node> inOrderTraversalIterative(Node root){
    List<Node> output = new ArrayList<>();
    if(root == null) return output;
    Stack<Node> stack = new Stack<>();
    Node current = root;
    while(current != null || !stack.isEmpty()){

        while(current != null){
            stack.add(current);
            current = current.left;
        }

        current = stack.pop();
        output.add(current);
        current = current.right;
    }
    return output;
}
    
    public static void main(String[] args) {
        
        BinaryTreeInorderTraversal tree = new BinaryTreeInorderTraversal();
        System.out.println("Creating a tree.");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Tree constructed.");

        List<Node> recursiveOutput = tree.inOrderTraversal(root);
        List<Node> iterativeOutput = tree.inOrderTraversalIterative(root);

        System.out.println("Printing recursive output.");
        for (Node node : recursiveOutput) {
            System.out.print(node.data + " ");
        }

        System.out.println(); //Throwing a new line here...
        System.out.println("Printing iterative output.");
        for(Node node : iterativeOutput){
            System.out.print(node.data + " ");
        }

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