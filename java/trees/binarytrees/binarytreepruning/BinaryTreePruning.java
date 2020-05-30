package trees.binarytrees.binarytreepruning;

import java.util.Stack;

public class BinaryTreePruning {
    
    public Node prune(Node root){

        if(root == null) return root;
        containsOne(root);
        return root;
    }

    private boolean containsOne(Node node){

        if(node == null) return false;

        boolean leftSubtreeContainsOne = containsOne(node.left);
        boolean rightSubtreeContainsOne = containsOne(node.right);

        if(!leftSubtreeContainsOne) node.left = null;
        if(!rightSubtreeContainsOne) node.right = null;

        return node.data == 1 || leftSubtreeContainsOne || rightSubtreeContainsOne;
    }

    public void inorderTraversal(Node root){
        System.out.println("Inside inorder traversal.");
        if(root == null) return;
        
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while(current != null || !stack.isEmpty()){

            //Go as far left as possible.
            while(current != null){
                stack.add(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    public static void main(String[] args) {
        System.out.println("Binary Tree pruning problem.");
        BinaryTreePruning binaryTree = new BinaryTreePruning();
        System.out.println("Creating a tree.");
        Node root = new Node(1);
        root.left = new Node(0);
        root.right = new Node(1);
        root.left.left = new Node(0);
        root.left.right = new Node(0);
        root.right.left = new Node(1);
        root.right.right = new Node(0);
        System.out.println("Tree constructed.");
        Node prunedTree = binaryTree.prune(root);
        binaryTree.inorderTraversal(prunedTree);
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