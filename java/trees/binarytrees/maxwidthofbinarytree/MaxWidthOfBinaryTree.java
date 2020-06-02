package trees.binarytrees.maxwidthofbinarytree;

import java.util.HashMap;
import java.util.Map;

public class MaxWidthOfBinaryTree {

    int maxWidth;
    Map<Integer, Integer> leftMostNodePosition = new HashMap<>();
    
    public int widthOfBinaryTree(Node root){

        if(root == null) return 0;
        
        computeMaxWidth(root, 0, 0);
        return maxWidth;
    }

    private void computeMaxWidth(Node node, int depth, int position){
        if(node == null) return;
        leftMostNodePosition.computeIfAbsent(depth, a -> position);
        maxWidth = Math.max(maxWidth, position - leftMostNodePosition.get(depth) + 1); 
        computeMaxWidth(node.left, depth + 1, position*2);
        computeMaxWidth(node.right, depth + 1, (position*2) + 1);
    }
    
    public static void main(String[] args) {
        MaxWidthOfBinaryTree maxWidthOfBinaryTree = new MaxWidthOfBinaryTree();
        System.out.println("Max width of a binary tree solution.");
        System.out.println("Construct a binary tree");
        Node root1 = new Node(20);
        root1.left = new Node(10);
        root1.right = new Node(30);
        root1.left.left = new Node(5);
        root1.left.right = new Node(15);
        root1.right.left = new Node(25);
        root1.right.right = new Node(40);
        System.out.println("binary tree constructed.");

        int width = maxWidthOfBinaryTree.widthOfBinaryTree(root1);
        System.out.println("Max width of a binary tree is " + width);
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