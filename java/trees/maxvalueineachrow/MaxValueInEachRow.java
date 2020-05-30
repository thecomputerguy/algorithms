package trees.maxvalueineachrow;

import java.util.ArrayList;
import java.util.List;

public class MaxValueInEachRow {

    public List<Integer> maxValue(Node root){
        List<Integer> result = new ArrayList<>(); 
        if(root == null) return result;
        result.add(root.data);
        maxValue(root, result, 0);
        return result;
    }

    private void maxValue(Node node, List<Integer> result, int level){

        if(node == null) return;

        if(result.size() == level){
            result.add(node.data);
        }else{
            result.set(level, Math.max(node.data, result.get(level)));
        }

        maxValue(node.left, result, level+1);
        maxValue(node.right, result, level+1);
    }
    
    public static void main(String[] args) {
        MaxValueInEachRow maxValueInEachRow = new MaxValueInEachRow();
        System.out.println("Max value in each row soltuion.");
        System.out.println("Creating a tree.");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Tree constructed.");
        List<Integer> values = maxValueInEachRow.maxValue(root);
        
        for (int i = 0; i < values.size(); i++) {
            System.out.println("level " + i + " : " + values.get(i));
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