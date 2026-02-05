package BinaryTree;
import java.util.*;
public class HeightOfBT {
    // Function to find the
    // maximum depth of a binary tree
    // using level order traversal
    int maxDepth(Node root) {
        // If the root is NULL
        // (empty tree), depth is 0
        if (root == null) {
            return 0;
        }

        // Create a queue for
        // level order traversal
        Queue<Node> q = new LinkedList<>();
        int level = 0;

        // Push the root node into the queue
        q.add(root);

        // While there are nodes in the queue
        while (!q.isEmpty()) {
            // Get the number of nodes
            // at the current level
            int size = q.size();

            // Process all nodes
            // at the current level
            for (int i = 0; i < size; i++) {
                // Get the front node in the queue
                Node front = q.poll();

                // Enqueue left child if exists
                if (front.left != null) {
                    q.add(front.left);
                }

                // Enqueue right child if exists
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            // Increment level to
            // move to the next level
            level++;
        }
        // Return the level, which represents
        // the maximum depth of the tree
        return level;
    }
    // Main function
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        HeightOfBT solution = new HeightOfBT();
        int depth = solution.maxDepth(root);

        System.out.println("Maximum depth of the binary tree: " + depth);
    }
}
