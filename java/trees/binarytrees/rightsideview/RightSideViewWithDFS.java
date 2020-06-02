package trees.binarytrees.rightsideview;

import java.util.ArrayList;
import java.util.List;

public class RightSideViewWithDFS {
    
    public List<Integer> rightSideView(Node root){
        
        List<Integer> result = new ArrayList<>(10);
        if(root == null) return result;
    
        rightSideView(root, 0, result);
        return result;
    }

    private void rightSideView(Node node, int depth, List<Integer> result){
        
        if(node == null) return;
        if(result.size() == depth){
            result.add(node.data);
        }else{
            result.set(depth, node.data);
        }
        
        if(node.left != null) rightSideView(node.left, depth + 1, result);
        if(node.right != null) rightSideView(node.right, depth + 1, result);
    }

    public static void main(String[] args) {
        RightSideViewWithDFS view = new RightSideViewWithDFS();

        System.out.println("Construct a binary tree");
        Node root1 = new Node(20);
        root1.left = new Node(10);
        root1.right = new Node(30);
        root1.left.left = new Node(5);
        root1.left.right = new Node(15);
        root1.right.left = new Node(25);
        root1.right.right = new Node(40);
        System.out.println("binary tree constructed.");

        List<Integer> rightSideViewOfTree = view.rightSideView(root1);
        for (Integer value : rightSideViewOfTree) {
            System.out.print(value + " ");
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