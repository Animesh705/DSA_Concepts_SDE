package BinaryTree;
import java.util.*;
public class FlattenBT {
    // Function to flatten a binary tree
    // to a right next Linked List structure
    public void flatten(Node root) {
        // Initialize a pointer
        // 'curr' to the root of the tree
        Node curr = root;

        // Iterate until 'curr'
        // becomes NULL
        while (curr != null) {
            // Check if the current
            // node has a left child
            if (curr.left != null) {
                // If yes, find the rightmost
                // node in the left subtree
                Node pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                // Connect the rightmost node in
                // the left subtree to the current
                // node's right child
                pre.right = curr.right;

                // Move the entire left subtree to the
                // right child of the current node
                curr.right = curr.left;

                // Set the left child of
                // the current node to NULL
                curr.left = null;
            }

            // Move to the next node
            // on the right side
            curr = curr.right;
        }
    }
}

// Print the preorder traversal of the
// Original Binary Tree
class Main {
    public static void printPreorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // Print the Binary Tree along the
    // Right Pointers after Flattening
    public static void printFlattenTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printFlattenTree(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.right.right = new Node(7);
        root.right.left = new Node(8);

        FlattenBT sol = new FlattenBT();

        System.out.print("Binary Tree Preorder: ");
        printPreorder(root);
        System.out.println();

        sol.flatten(root);

        System.out.print("Binary Tree After Flatten: ");
        printFlattenTree(root);
        System.out.println();
    }
}
