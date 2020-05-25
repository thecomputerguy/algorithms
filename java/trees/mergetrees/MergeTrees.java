package trees.mergetrees;

import java.util.Stack;

public class MergeTrees {

    public Node merge(Node node1, Node node2){

        if(node1 == null){
            return node2;
        }

        if(node2 == null){
            return node1;
        }

        //Merge data from two nodes into the first node.
        node1.data = node1.data + node2.data;
        //Call recursively to copy the left subtree.
        node1.left = merge(node1.left, node2.left);
        //call recursively to copy the right subtree.
        node1.right = merge(node1.right, node2.right);

        return node1;
    }

    public void inorderTraversal(Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(current != null || !stack.isEmpty()){
            
            while(current != null){
                stack.add(current);
                current = current.left;
            }
            Node node = stack.pop();
            System.out.print(node.data + " ");
            current = node.right;
        }
    }

    public void preorderTraversal(Node root){
        if(root == null) return;
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.data + " ");
            if(node.right != null) stack.add(node.right);
            if(node.left != null) stack.add(node.left);
        }
    }

    public static void main(String[] args) {
        MergeTrees mergeTrees = new MergeTrees();
        Node root1 = createTree();
        Node root2 = createTree();
        Node mergedTree = mergeTrees.merge(root1, root2);
        
        //do an inorder traversal on the mergedTree to print all the nodes.
        System.out.println("Inorder Traversal of the tree");
        mergeTrees.inorderTraversal(mergedTree);

        System.out.println();
        System.out.println("Preoreder Traversal of the tree");
        mergeTrees.preorderTraversal(mergedTree);

    }

    public static Node createTree(){
        System.out.println("Creating a tree.");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Tree constructed.");
        return root;
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