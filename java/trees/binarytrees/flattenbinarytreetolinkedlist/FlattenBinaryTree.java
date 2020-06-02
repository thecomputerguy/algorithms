package trees.binarytrees.flattenbinarytreetolinkedlist;

import java.util.Stack;

public class FlattenBinaryTree {
    
    public Node flatten(Node root){

        if(root == null) return root;
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node.right != null) stack.add(node.right);
            if(node.left != null) stack.add(node.left);
            if(!stack.isEmpty()) node.right = stack.peek();
            node.left = null;
        }

        return root;
    }

    public static void main(String[] args) {
        FlattenBinaryTree flattenBinaryTree = new FlattenBinaryTree();
        
        System.out.println("Construct a binary tree");
        Node root1 = new Node(20);
        root1.left = new Node(10);
        root1.right = new Node(30);
        root1.left.left = new Node(5);
        root1.left.right = new Node(15);
        root1.right.left = new Node(25);
        root1.right.right = new Node(40);
        System.out.println("binary tree constructed.");

        Node flattenedTree = flattenBinaryTree.flatten(root1);
        System.out.println("Print the flattened tree.");
        Node currentNode = flattenedTree;
        while(currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.right;
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