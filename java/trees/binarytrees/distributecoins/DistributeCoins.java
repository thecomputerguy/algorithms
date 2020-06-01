package trees.binarytrees.distributecoins;

public class DistributeCoins {
    int noOfMoves;
    public int distribute(Node root){
        if(root == null) return 0;
        distributeCoins(root);
        return noOfMoves;
    }

    private int distributeCoins(Node node){

        if(node == null) return 0;
        int left = distributeCoins(node.left);
        int right = distributeCoins(node.right);
        noOfMoves += Math.abs(left) + Math.abs(right);
        return left + right + node.data - 1;
    }   
    
    public static void main(String[] args) {
        DistributeCoins distributeCoins = new DistributeCoins();
        System.out.println("Construct a binary tree");
        Node root1 = new Node(20);
        root1.left = new Node(10);
        root1.right = new Node(30);
        root1.left.left = new Node(5);
        root1.left.right = new Node(15);
        root1.right.left = new Node(25);
        root1.right.right = new Node(40);
        System.out.println("binary tree constructed.");
        int moves = distributeCoins.distribute(root1);
        System.out.println("Number of moves to evenly distribute coins: " + moves);
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