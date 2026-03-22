package BinaryTree;
import java.util.*;
public class printNodesAtDistanceK {
    // Main method to find nodes at distance K from target node
    public List<Integer> distanceK(Node root, Node target, int k) {
        if (root == null) return new ArrayList<>();

        // Step 1: Build parent references using BFS
        Map<Node, Node> parentMap = new HashMap<>();
        mapParents(root, parentMap);

        // Step 2: Perform BFS from target to find all nodes at distance K
        return bfsFromTarget(target, parentMap, k);
    }

    // Helper method to build the parent map using level-order traversal
    private void mapParents(Node root, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // Record left child's parent
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }

            // Record right child's parent
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }

    // BFS starting from the target node to collect nodes at distance K
    private List<Integer> bfsFromTarget(Node target, Map<Node, Node> parentMap, int k) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);

        int currentLevel = 0;

        // Standard level-order BFS
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Stop traversal once we reach distance K
            if (currentLevel++ == k) break;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                // Explore left child
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }

                // Explore right child
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }

                // Explore parent from map
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    visited.add(parentMap.get(node));
                    queue.offer(parentMap.get(node));
                }
            }
        }

        // All nodes left in queue are exactly K distance from target
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().data);
        }

        return result;
    }
    public static void main(String[] args) {
        // Construct the binary tree
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        // Node with dataue 5
        Node target = root.left;
        int k = 2;

        printNodesAtDistanceK sol = new printNodesAtDistanceK();
        List<Integer> result = sol.distanceK(root, target, k);

        // Print the result
        for (int data : result) {
            System.out.print(data + " ");
        }
    }
}

