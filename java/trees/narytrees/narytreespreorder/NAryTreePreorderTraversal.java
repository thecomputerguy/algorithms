package trees.narytrees.narytreespreorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NAryTreePreorderTraversal {
    
    public List<Integer> preorder(Node root){
        List<Integer> output = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(root == null) return output;

        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            output.add(node.data);
            List<Node> children = node.children;
            Collections.reverse(children);
            for (Node child : children) {
                stack.add(child);
            }
        }

        return output;
    }

    public static void main(String[] args) {
    
        NAryTreePreorderTraversal tree = new NAryTreePreorderTraversal();
        System.out.println("Preorder traversal");
        Node root = new Node(1);
        List<Node> children = new ArrayList<>();

        for (int i = 2; i < 10; i++) {
            Node node = new Node(i);
            children.add(node);    
        }
        root.children = children;

        List<Integer> result = tree.preorder(root);

            for (int i : result) {
                System.out.print(i + " ");
            }
    }
}

class Node implements Comparable<Node>{
    int data;
    List<Node> children = new ArrayList<>();

    public Node(int data){
        this.data = data;
    }

    public int compareTo(Node to){

        return this.data - to.data;
    }
}