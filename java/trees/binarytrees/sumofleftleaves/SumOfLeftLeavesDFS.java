package trees.binarytrees.sumofleftleaves;

public class SumOfLeftLeavesDFS {

    public int sum(Node root){
        if(root == null) return 0;
        int SumOfLeftLeaves = 0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                SumOfLeftLeaves += root.left.data;
            }else{
                SumOfLeftLeaves += sum(root.left);
            }
        }

        if(root.right != null){
            if(root.right.left != null || root.right.right != null){
                SumOfLeftLeaves += sum(root.right);
            }
        }

        return SumOfLeftLeaves;
    }
    
    public static void main(String[] args) {
        SumOfLeftLeavesDFS lefLeaves = new SumOfLeftLeavesDFS();
        
        Node root1 = new Node(20);
        root1.left = new Node(10);
        root1.right = new Node(30);
        root1.left.left = new Node(5);
        root1.left.right = new Node(15);
        root1.right.left = new Node(25);
        root1.right.right = new Node(40);

        int leftLeavesSum = lefLeaves.sum(root1);
        System.out.println("Left leaves sum " + leftLeavesSum);
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