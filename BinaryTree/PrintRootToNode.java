package BinaryTree;
import java.util.*;
public class PrintRootToNode {
    // Function to get path from root to node with dataue x
    public boolean getPath(Node root, List<Integer> arr, int x) {
        // Base case: If node is null
        if (root == null)
            return false;

        // Add current node to path
        arr.add(root.data);

        // If current node is the target
        if (root.data == x)
            return true;

        // Recurse into left and right children
        if (getPath(root.left, arr, x) || getPath(root.right, arr, x))
            return true;

        // Backtrack if not found
        arr.remove(arr.size() - 1);
        return false;
    }

    // Function to return the final path vector
    public List<Integer> solve(Node root, int x) {
        // Initialize result list
        List<Integer> arr = new ArrayList<>();

        // If tree is empty
        if (root == null)
            return arr;

        // Call helper function
        getPath(root, arr, x);
        return arr;
    }
    public static void main(String[] args) {
        // Construct the tree
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        // Create solution object
        PrintRootToNode sol = new PrintRootToNode();

        // Target node dataue
        int target = 7;

        // Get path from root to target
        List<Integer> path = sol.solve(root, target);

        // Print the path
        System.out.print("Path from root to node " + target + ": ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1)
                System.out.print(" -> ");
        }
    }
}
