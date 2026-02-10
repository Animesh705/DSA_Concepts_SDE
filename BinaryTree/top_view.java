package BinaryTree;
import java.util.*;
public class top_view {
    // Function to return the top view of the binary tree
    public List<Integer> topView(Node root) {
        // Create a list to store the final result
        List<Integer> ans = new ArrayList<>();

        // If the tree is empty, return empty result
        if (root == null) {
            return ans;
        }

        // Map to store vertical level -> node value (only first encountered)
        Map<Integer, Integer> mpp = new TreeMap<>();

        // Queue for BFS storing {node, vertical_level}
        Queue<AbstractMap.SimpleEntry<Node, Integer>> q = new LinkedList<>();

        // Push the root node with vertical level 0
        q.add(new AbstractMap.SimpleEntry<>(root, 0));

        // Start BFS traversal
        while (!q.isEmpty()) {
            // Get the front element of the queue
            AbstractMap.SimpleEntry<Node, Integer> entry = q.poll();

            // Extract node and vertical position
            Node node = entry.getKey();
            int line = entry.getValue();

            // If vertical position is visited for the first time, store the value
            if (!mpp.containsKey(line)) {
                mpp.put(line, node.data);
            }

            // If left child exists, push it with vertical level - 1
            if (node.left != null) {
                q.add(new AbstractMap.SimpleEntry<>(node.left, line - 1));
            }

            // If right child exists, push it with vertical level + 1
            if (node.right != null) {
                q.add(new AbstractMap.SimpleEntry<>(node.right, line + 1));
            }
        }

        // Transfer values from the map to the answer list
        for (int val : mpp.values()) {
            ans.add(val);
        }

        // Return the result
        return ans;
    }
    public static void main(String[] args) {
        // Create the sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        // Create Solution object
        top_view solution = new top_view();

        // Get the top view
        List<Integer> result = solution.topView(root);

        // Print the result
        System.out.print("Top View Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
