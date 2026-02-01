package BinaryTree;
import java.util.*;
    // Node structure for
// the binary tree
    class Node {
        int data;
        Node left;
        Node right;

        // Constructor to initialize
        // the node with a value
        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    // Solution class to perform preorder traversal
    public class PreOrderTraversal {

        // Function to perform preorder traversal
        // of the tree and store values in 'arr'
        public void preorder(Node root, java.util.List<Integer> arr) {
            // If the current node is NULL
            // (base case for recursion), return
            if (root == null) {
                return;
            }
            // Push the current node's
            // value into the vector
            arr.add(root.data);
            // Recursively traverse
            // the left subtree
            preorder(root.left, arr);
            // Recursively traverse
            // the right subtree
            preorder(root.right, arr);
        }

        // Function to initiate preorder traversal
        // and return the resulting list
        public java.util.List<Integer> preOrder(Node root) {
            // Create an empty list to
            // store preorder traversal values
            java.util.List<Integer> arr = new java.util.ArrayList<>();
            // Call the preorder traversal function
            preorder(root, arr);
            // Return the resulting list
            // containing preorder traversal values
            return arr;
        }
        public static void main(String[] args) {

            // Creating a sample binary tree
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);

            // Getting preorder traversal
            PreOrderTraversal sol = new PreOrderTraversal();
            java.util.List<Integer> result = sol.preOrder(root);

            // Displaying the preorder traversal result
            System.out.print("Preorder Traversal: ");
            // Output each value in the
            // preorder traversal result
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
