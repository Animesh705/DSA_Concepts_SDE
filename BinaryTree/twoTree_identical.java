package BinaryTree;
import java.util.*;
public class twoTree_identical {
    public boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {
            return (p==q);
        }
        return (p.data==q.data) && (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
    public static void main(String[] args) {
        // Creating the first binary tree (Node1)
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        // Creating the second binary tree (Node2)
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);

        // Creating an instance of the Solution class
        twoTree_identical solution = new twoTree_identical();

        // Check if the two binary trees are identical and output the result
        if (solution.isSameTree(root1, root2)) {
            System.out.println("The binary trees are identical.");
        } else {
            System.out.println("The binary trees are not identical.");
        }
    }
}
