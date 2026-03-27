package BinaryTree;
import java.util.*;
public class Morris_preOrder {
    // Function to perform iterative Morris
    // preorder traversal of a binary tree
    public List<Integer> getPreorder(Node root) {
        // List to store the
        // preorder traversal result
        List<Integer> preorder = new ArrayList<>();

        // Pointer to the current node,
        // starting with the root
        Node cur = root;

        // Iterate until the
        // current node becomes null
        while (cur != null) {
            // If the current node
            // has no left child
            if (cur.left == null) {
                // Add the value of the
                // current node to the preorder list
                preorder.add(cur.data);

                // Move to the right child
                cur = cur.right;
            } else {
                // If the current node has a left child
                // Create a pointer to traverse to the
                // rightmost node in the left subtree
                Node prev = cur.left;

                // Traverse to the rightmost node in the
                // left subtree or until we find a node
                // whose right child is not yet processed
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // If the right child of the
                // rightmost node is null
                if (prev.right == null) {
                    // Set the right child of the
                    // rightmost node to the current node
                    prev.right = cur;

                    // Add the value of the
                    // current node to the preorder list
                    preorder.add(cur.data);

                    // Move to the left child
                    cur = cur.left;
                } else {
                    // If the right child of the
                    // rightmost node is not null
                    // Reset the right child to null
                    prev.right = null;

                    // Move to the right child
                    cur = cur.right;
                }
            }
        }

        // Return the resulting
        // preorder traversal list
        return preorder;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);

        Morris_preOrder sol = new Morris_preOrder();

        List<Integer> preorder = sol.getPreorder(root);

        System.out.print("Binary Tree Morris Preorder Traversal: ");
        for (int i = 0; i < preorder.size(); i++) {
            System.out.print(preorder.get(i) + " ");
        }
        System.out.println();
    }
}
