package trees.binarytrees.inverttree;

import java.util.Stack;

public class InvertTree {

    public Node invert(Node root){

        if(root == null) return root;

        Node left = invert(root.left);
        Node right = invert(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

    public void inorderTraversal(Node root){

        if(root == null) return;

        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(current != null || !stack.isEmpty()){

            while(current != null){
                stack.add(current);
                current = current.left;
            }

            Node node = stack.pop();
            System.out.print(node.data + " ");
            current = node.right;
        }

    }

    public void preorderTraversal(Node root){

        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.data + " ");
            if(node.right != null) stack.add(node.right);
            if(node.left != null) stack.add(node.left);
        }

    }
    
    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();
        System.out.println("Invert a binary tree solution.");
        Node root = createTree();
        System.out.println("Before inverting : ");
        System.out.println("inorder traversal.");
        invertTree.inorderTraversal(root);
        System.out.println();
        System.out.println("preorder traversal.");
        invertTree.preorderTraversal(root);
        System.out.println();
        System.out.println("Inverted tree: ");
        Node invertedTree = invertTree.invert(root);
        System.out.println("inorder traversal.");
        invertTree.inorderTraversal(invertedTree);
        System.out.println();
        System.out.println("preorder traversal.");
        invertTree.preorderTraversal(invertedTree);
    }

    public static Node createTree(){
        System.out.println("Creating a tree.");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Tree constructed.");
        return root;
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