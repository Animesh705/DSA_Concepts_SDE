package BinaryTree;
import java.util.*;
public class ZigZag_Trav {
    // Function to perform zigzag (spiral) level order traversal of a binary tree
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        // List to store the final zigzag traversal result
        List<List<Integer>> result = new ArrayList<>();

        // If the tree is empty, return an empty list
        if (root == null) return result;

        // Queue to store nodes for BFS (level order traversal)
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        // Boolean flag to control traversal direction
        boolean leftToRight = true;

        // Loop until all levels are processed
        while (!q.isEmpty()) {
            // Get the number of nodes at the current level
            int size = q.size();

            // Temporary array to store current level's values in zigzag order
            Integer[] level = new Integer[size];

            // Process each node in the current level
            for (int i = 0; i < size; i++) {
                // Get the front node from the queue
                Node node = q.poll();

                // Determine index where this value should be stored
                int index = leftToRight ? i : size - 1 - i;
                level[index] = node.data;

                // Add left child to queue if it exists
                if (node.left != null) q.offer(node.left);
                // Add right child to queue if it exists
                if (node.right != null) q.offer(node.right);
            }

            // Flip traversal direction for the next level
            leftToRight = !leftToRight;

            // Add current level to the final result
            result.add(Arrays.asList(level));
        }

        // Return the zigzag traversal result
        return result;
    }
    public static void main(String[] args) {
        // Create binary tree:
        //        1
        //      /   \
        //     2     3
        //    / \     \
        //   4   5     6
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // Create solution object
        ZigZag_Trav sol = new ZigZag_Trav();

        // Get zigzag traversal
        List<List<Integer>> ans = sol.zigzagLevelOrder(root);

        // Print result
        System.out.println(ans);
    }
}
