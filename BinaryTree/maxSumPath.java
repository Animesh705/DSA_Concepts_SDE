package BinaryTree;
import java.util.*;

public class maxSumPath {

    // Global variable to store maximum path sum
    int maxSum = Integer.MIN_VALUE;

    // Public method to get final answer
    public int finalMAXSum(Node root) {
        pathSum(root);
        return maxSum;
    }

    // Recursive DFS method
    private int pathSum(Node root) {
        if (root == null) return 0;

        // Ignore negative paths
        int lh = Math.max(0, pathSum(root.left));
        int rh = Math.max(0, pathSum(root.right));

        // Update global maximum using current node as turning point
        maxSum = Math.max(maxSum, lh + rh + root.data);

        // Return one-sided path to parent
        return Math.max(lh, rh) + root.data;
    }

    // Tree printer (sideways)
    static void printTree(Node root, int level) {
        if (root == null) return;

        printTree(root.right, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(root.data);

        printTree(root.left, level + 1);
    }

    public static void main(String[] args) {

        // Correct tree construction
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        maxSumPath solution = new maxSumPath();

        // Print tree structure
        printTree(root, 0);

        // Correct function call
        int max = solution.finalMAXSum(root);
        System.out.println("Maximum path sum = " + max);
    }
}