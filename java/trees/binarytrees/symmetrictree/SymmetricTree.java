package trees.binarytrees.symmetrictree;

public class SymmetricTree {
    
    public boolean isSymmetric(Node root){
        if(root == null) return true;
        boolean symmetric = isSymmetric(root, root);
        return symmetric;
    }

    public boolean isSymmetric(Node node1, Node node2){

        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;

        return (node1.data == node2.data) && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left); 
    }

    public static void main(String[] args) {
        System.out.println("symmetric tree solution.");
        SymmetricTree tree = new SymmetricTree();
        System.out.println("Creating a tree.");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        System.out.println("Tree constructed.");
        boolean symmetric = tree.isSymmetric(root);
        System.out.println("is tree symmetric: " + symmetric);
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