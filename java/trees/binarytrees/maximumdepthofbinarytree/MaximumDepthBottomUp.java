package trees.binarytrees.maximumdepthofbinarytree;

public class MaximumDepthBottomUp {
    
    public int maxDepth(Node node){

        if(node == null) return 0;

        //depth of left subtree.
        int leftDepth = maxDepth(node.left);
        
        //depth of right subtree.
        int rightDepth = maxDepth(node.right);
        
        //Add root's depth to the max of right and left subtree.
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        
        System.out.println("Maximum depth of a binary tree solution.");
        MaximumDepthTopDown tree = new MaximumDepthTopDown();
        System.out.println("Creating a tree.");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Tree constructed.");
        int depth = tree.maxDepth(root);
        System.out.println("Max Depth of a tree is: " + depth);
    }
}