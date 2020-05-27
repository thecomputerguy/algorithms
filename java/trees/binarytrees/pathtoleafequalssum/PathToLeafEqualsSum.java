package trees.binarytrees.pathtoleafequalssum;

import java.util.Stack;

public class PathToLeafEqualsSum {
    
    public boolean hasPath(Node root, int sum){

        if(root == null) return false;
        Stack<Node> nodes = new Stack<>();
        Stack<Integer> sumHolder = new Stack<>();
        nodes.add(root);
        sumHolder.add(sum - root.data);

        while(!nodes.isEmpty()){
            Node currentNode = nodes.pop();
            int currentSum = sumHolder.pop();
            
            if(currentNode.left == null && currentNode.right == null && currentSum == 0) return true;
            
            if(currentNode.left != null){
                nodes.add(currentNode.left);
                sumHolder.add(currentSum - currentNode.left.data);
            }

            if(currentNode.right != null) {
                nodes.add(currentNode.right);
                sumHolder.add(currentSum - currentNode.right.data);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        
        System.out.println("Maximum depth of a binary tree solution.");
        PathToLeafEqualsSum tree = new PathToLeafEqualsSum();
        System.out.println("Creating a tree.");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Tree constructed.");
        System.out.println("Looking for path sum " + 7);
        boolean result1 = tree.hasPath(root, 7);
        System.out.println("Path to leaf equals sum? " + result1);
        System.out.println("Looking for path sum " + 16);
        boolean result2 = tree.hasPath(root, 16);
        System.out.println("Path to leaf equals sum? " + result2);
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