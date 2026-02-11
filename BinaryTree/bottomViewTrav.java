package BinaryTree;

import java.util.*;


public class bottomViewTrav {

    // Custom Pair class to store node and its vertical line
    static class Pair {
        Node node;
        int line;

        Pair(Node node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    // Function to return the bottom view of the binary tree
    public List<Integer> bottomView(Node root) {

        // Result list
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        // TreeMap to keep vertical lines sorted
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue for BFS
        Queue<Pair> q = new LinkedList<>();

        // Start BFS from root at vertical line 0
        q.offer(new Pair(root, 0));

        // BFS traversal
        while (!q.isEmpty()) {

            Pair p = q.poll();
            Node curr = p.node;
            int line = p.line;

            // Overwrite value at this vertical line
            // (bottom-most node wins)
            map.put(line, curr.data);

            // Move left
            if (curr.left != null) {
                q.offer(new Pair(curr.left, line - 1));
            }

            // Move right
            if (curr.right != null) {
                q.offer(new Pair(curr.right, line + 1));
            }
        }

        // Collect bottom view from map
        for (int val : map.values()) {
            ans.add(val);
        }

        return ans;
    }

    // Main function
    public static void main(String[] args) {

        // Create sample tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(10);

        bottomViewTrav obj = new bottomViewTrav();

        // Get bottom view
        List<Integer> result = obj.bottomView(root);

        // Print result
        System.out.println("Bottom View Traversal:");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}