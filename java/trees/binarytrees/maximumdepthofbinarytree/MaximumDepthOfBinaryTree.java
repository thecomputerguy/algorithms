package trees.binarytrees.maximumdepthofbinarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(Node node){

        if(node == null) return 0;
        int depth = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        //Do a level order traversal to get the depth of the tree.
        while(!queue.isEmpty()){
            //pull the size here to process nodes level by level.
            int size = queue.size();
            while(size > 0){
                Node item = queue.poll();
                size--;
                //Add next level nodes into the queue.
                if(item.left != null) queue.offer(item.left);
                if(item.right != null) queue.offer(item.right);
            }
            depth++;
        }

        return depth;
    }
    
    public static void main(String[] args) {
        System.out.println("Maximum depth of a binary tree solution.");
        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
        System.out.println("Creating a tree.");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Tree constructed.");
        int depth = tree.maxDepth(root);
        System.out.println("Max Depth of a tree is: " + depth);

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