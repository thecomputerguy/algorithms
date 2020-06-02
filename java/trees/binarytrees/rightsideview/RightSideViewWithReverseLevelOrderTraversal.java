package trees.binarytrees.rightsideview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewWithReverseLevelOrderTraversal {
    
    public List<Integer> rightSideView(Node root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            int i = 0;
            while(i < size){
                Node node = queue.poll();
                if(i == 0)  result.add(node.data);
                if(node.right != null) queue.offer(node.right);
                if(node.left != null) queue.offer(node.left);
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Right side view of a binary tree with reverse level order traversal.");
        RightSideViewWithReverseLevelOrderTraversal view = new RightSideViewWithReverseLevelOrderTraversal();

        System.out.println("Construct a binary tree");
        Node root1 = new Node(20);
        root1.left = new Node(10);
        root1.right = new Node(30);
        root1.left.left = new Node(5);
        root1.left.right = new Node(15);
        root1.right.left = new Node(25);
        root1.right.right = new Node(40);
        System.out.println("binary tree constructed.");


        List<Integer> result = view.rightSideView(root1);
        for (Integer value : result) {
            System.out.print(value + " ");
        }
    }

   static class Node{
        int data;
        Node left;
        Node right;
    
        public Node(int data){
            this.data = data;
        }
    }

}

