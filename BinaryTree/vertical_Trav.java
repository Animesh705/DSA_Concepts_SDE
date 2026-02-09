package BinaryTree;
import java.util.*;
public class vertical_Trav {
    // Function to perform vertical order traversal
    public List<List<Integer>> findVertical(Node root) {
        // Map to store vertical and level mapping
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodes = new TreeMap<>();

        // Queue for BFS storing node with vertical and level
        Queue<Pair> todo = new LinkedList<>();

        // Push root node with coordinates (0,0)
        todo.offer(new Pair(root, 0, 0));

        // Perform BFS
        while (!todo.isEmpty()) {
            Pair p = todo.poll();
            Node temp = p.node;
            int x = p.vertical;
            int y = p.level;

            // Add node value to map
            nodes.putIfAbsent(x, new TreeMap<>());
            nodes.get(x).putIfAbsent(y, new PriorityQueue<>());
            nodes.get(x).get(y).offer(temp.data);

            // If left child exists, push to queue
            if (temp.left != null) {
                todo.offer(new Pair(temp.left, x - 1, y + 1));
            }

            // If right child exists, push to queue
            if (temp.right != null) {
                todo.offer(new Pair(temp.right, x + 1, y + 1));
            }
        }

        // Final answer
        List<List<Integer>> ans = new ArrayList<>();

        // Iterate through map to build result
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : nodes.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> pq : ys.values()) {
                while (!pq.isEmpty()) {
                    col.add(pq.poll());
                }
            }
            ans.add(col);
        }

        return ans;
    }

    // Helper class for queue elements
    static class Pair {
        Node node;
        int vertical;
        int level;

        Pair(Node n, int v, int l) {
            node = n;
            vertical = v;
            level = l;
        }
    }

    // Function to print result
    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> level : result) {
            for (int val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Main function
    public static void main(String[] args) {
        // Create sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        // Create solution object
        vertical_Trav solution = new vertical_Trav();

        // Call function
        List<List<Integer>> verticalTraversal = solution.findVertical(root);

        // Print result
        System.out.println("Vertical Traversal:");
        printResult(verticalTraversal);
    }
}

