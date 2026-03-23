package BinaryTree;
import java.util.*;
public class countNodesInBT {
    // Function to count nodes in a complete binary tree
    public int countNodes(Node root) {
        // If tree is empty, return 0
        if (root == null) {
            return 0;
        }
        // Get left height
        int lh = findHeightLeft(root);
        // Get right height
        int rh = findHeightRight(root);
        // If heights match, use perfect binary tree formula
        if (lh == rh) {
            return (1 << lh) - 1;
        }
        // Otherwise, recursively count left and right subtrees
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Helper to find height from leftmost path
    public int findHeightLeft(Node node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    // Helper to find height from rightmost path
    public int findHeightRight(Node node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    public static void main(String[] args) {
        // Create binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        // Create solution object
        countNodesInBT sol = new countNodesInBT();

        // Count total nodes
        int totalNodes = sol.countNodes(root);

        // Print result
        System.out.println("Total number of nodes in the Complete Binary Tree: " + totalNodes);
    }
}
