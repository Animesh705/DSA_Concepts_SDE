package BinaryTree;
import  java.util.*;
public class RightLeftView {
    // Function to get left view
    public void leftDFS(Node node, int level, List<Integer> res) {
        // Base case
        if (node == null) return;

        // If we're visiting this level the first time
        if (res.size() == level)
            res.add(node.data);

        // Recurse left
        leftDFS(node.left, level + 1, res);

        // Recurse right
        leftDFS(node.right, level + 1, res);
    }

    // Function to get right view
    public void rightDFS(Node node, int level, List<Integer> res) {
        if (node == null) return;

        if (res.size() == level)
            res.add(node.data);

        // Recurse right
        rightDFS(node.right, level + 1, res);

        // Recurse left
        rightDFS(node.left, level + 1, res);
    }

    // Wrapper for left view
    public List<Integer> leftView(Node root) {
        List<Integer> res = new ArrayList<>();
        leftDFS(root, 0, res);
        return res;
    }

    // Wrapper for right view
    public List<Integer> rightView(Node root) {
        List<Integer> res = new ArrayList<>();
        rightDFS(root, 0, res);
        return res;
    }
    public static void main(String[] args) {
        // Create binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        // Create solution instance
        RightLeftView sol = new RightLeftView();

        // Get left and right views
        List<Integer> left = sol.leftView(root);
        List<Integer> right = sol.rightView(root);

        // Print left view
        System.out.print("Left View: ");
        for (int data : left)
            System.out.print(data + " ");

        // Print right view
        System.out.print("\nRight View: ");
        for (int data : right)
            System.out.print(data + " ");
    }
}
