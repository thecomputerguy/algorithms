package trees.binarysearchtrees.rangesumbst;

public class RangeSumBST{

    int sum;
    public int rangeSum(Node root, int left, int right){

        if(root == null) return 0;
        if(root.data >= left && root.data <= right) sum += root.data;
        if(root.data > left) rangeSum(root.left, left, right);
        if(root.data < right) rangeSum(root.right, left, right);

        return sum;
    }

    public static void main(String[] args) {
        RangeSumBST rangeSumBST = new RangeSumBST();
        System.out.println("Construct a bst");
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.right.left = new Node(25);
        root.right.right = new Node(40);
        System.out.println("bst constructed.");
        int sum = rangeSumBST.rangeSum(root, 5, 35);
        System.out.println("Range sum of bst is " + sum);
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