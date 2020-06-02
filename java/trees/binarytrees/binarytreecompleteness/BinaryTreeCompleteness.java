package trees.binarytrees.binarytreecompleteness;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeCompleteness {

    public boolean isCompleteTree(Node root){
        
        if(root == null) return true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean end = false;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node == null){
                end = true;
            }else{
                if(end){
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }
    
    public static void main(String[] args) {

        BinaryTreeCompleteness binaryTreeCompleteness = new BinaryTreeCompleteness();
        System.out.println("Binary tree completeness problem.");

        System.out.println("Construct a binary tree");
        Node root1 = new Node(20);
        root1.left = new Node(10);
        root1.right = new Node(30);
        root1.left.left = new Node(5);
        root1.left.right = new Node(15);
        root1.right.left = new Node(25);
        root1.right.right = new Node(40);
        System.out.println("binary tree constructed.");

        boolean firstComplete = binaryTreeCompleteness.isCompleteTree(root1);
        System.out.println("is complete ? " + firstComplete);

        System.out.println("Construct a binary tree");
        Node root2 = new Node(20);
        root2.left = new Node(10);
        root2.right = new Node(30);
        root2.left.left = new Node(5);
        root2.left.right = new Node(15);
        //root2.right.left = new Node(25);
        root2.right.right = new Node(40);
        System.out.println("binary tree constructed.");


        boolean secondComplete = binaryTreeCompleteness.isCompleteTree(root2);
        System.out.println("is complete ? " + secondComplete);
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