package trees.binarytrees.univaluedbinarytree;

public class UnivaluedBinaryTree {
    
    public boolean isUnivalTree(Node root){
        if(root == null) return true;
        boolean leftUnivaled = root.left == null || root.left.data == root.data  && isUnivalTree(root.left);
        boolean rightUnivaled = root.right == null || root.right.data == root.data && isUnivalTree(root.right);

        return leftUnivaled && rightUnivaled;
    }

    public static void main(String[] args) {
        UnivaluedBinaryTree tree = new UnivaluedBinaryTree();
        System.out.println("Construct a binary tree");
        Node root1 = new Node(20);
        root1.left = new Node(10);
        root1.right = new Node(30);
        root1.left.left = new Node(5);
        root1.left.right = new Node(15);
        root1.right.left = new Node(25);
        root1.right.right = new Node(40);
        System.out.println("binary tree constructed.");

        boolean result1 = tree.isUnivalTree(root1);
        System.out.println("is univalued tree " + result1);

        System.out.println("Construct a second binary tree");
        Node root2 = new Node(20);
        root2.left = new Node(20);
        root2.right = new Node(20);
        root2.left.left = new Node(20);
        root2.left.right = new Node(20);
        root2.right.left = new Node(20);
        root2.right.right = new Node(20);
        System.out.println("second binary tree constructed.");

        boolean result2 = tree.isUnivalTree(root2);
        System.out.println("is univalued tree " + result2);
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