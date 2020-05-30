package trees.binarytrees.bottomlefttreevalue;

import java.util.LinkedList;
import java.util.Queue;

public class BottomLeftTreeValue {

    public Node findLeftMostNode(Node root){

        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node node = root;
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node.right != null) queue.offer(node.right);
            if(node.left != null) queue.offer(node.left);
        }
       
        return node;
    }
    
    public static void main(String[] args) {
        
        BottomLeftTreeValue leftMostNode = new BottomLeftTreeValue();

        System.out.println("Creating a tree.");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Tree constructed.");

        Node node = leftMostNode.findLeftMostNode(root);
        System.out.println("Left most node of the tree is " + node.data);
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