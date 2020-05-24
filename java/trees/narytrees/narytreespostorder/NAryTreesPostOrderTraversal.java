package trees.narytrees.narytreespostorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NAryTreesPostOrderTraversal {

    public List<Integer> postOrder(Node root){
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){

            Node node = stack.pop();
            result.offerFirst(node.data);
            for (Node child : node.children) {
                stack.add(child);
            }
        } 

        return result;
    }
    
    public static void main(String[] args) {
    
        System.out.println("N-Ary Trees Post order traversal.");
        NAryTreesPostOrderTraversal tree = new NAryTreesPostOrderTraversal();
        Node root = new Node(1);
        List<Node> children = new ArrayList<>();

        for (int i = 2; i < 10; i++) {
            Node node = new Node(i);
            children.add(node);    
        }
        root.children = children;

        List<Integer> result = tree.postOrder(root);

            for (int i : result) {
                System.out.print(i + " ");
            }

    }
}

class Node{

    int data;
    List<Node> children = new ArrayList<>();

    public Node(int data){
        this.data = data;
    }
}