package trees.binarytrees.sumofleftleaves;

import java.util.Stack;

public class SumOfLeftLeavesIterative {
    
    public int sum(Node root){
        if(root == null) return 0;
        int sumOfLeftLeaves = 0;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node.left != null){
                if(node.left.left == null && node.left.right == null){
                    sumOfLeftLeaves += node.left.data;
                }else{
                    stack.add(node.left);
                }   
            }

            if(node.right != null){
                if(node.right.left != null || node.right.right != null){
                    stack.add(node.right);
                }
            }
        }

        return sumOfLeftLeaves;
    }   

    public static void main(String[] args) {

        System.out.println("Sum of left leaves iterative solution.");
        SumOfLeftLeavesIterative leftLeaves = new SumOfLeftLeavesIterative();
        
        Node root1 = new Node(20);
        root1.left = new Node(10);
        root1.right = new Node(30);
        root1.left.left = new Node(5);
        root1.left.right = new Node(15);
        root1.right.left = new Node(25);
        root1.right.right = new Node(40);

        int sum = leftLeaves.sum(root1);
        System.out.println("Sum of left leaves is " + sum);
    }
}