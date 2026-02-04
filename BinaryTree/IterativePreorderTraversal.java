package BinaryTree;
import java.util.*;
public class IterativePreorderTraversal {
    // Function to perform preorder traversal of a binary tree iteratively
    public static List<Integer> preorderTraversal(Node root) {
        List<Integer> preorder = new ArrayList<>();  // List to store the preorder traversal result

        // If the root is null, return an empty traversal result
        if (root == null) {
            return preorder;
        }

        Stack<Node> st = new Stack<>();  // Stack to store nodes during traversal
        st.push(root);  // Push the root node onto the stack

        // Perform iterative preorder traversal
        while (!st.isEmpty()) {
            root = st.pop();  // Get the current node from the top of the stack
            preorder.add(root.data);  // Add the node's value to the preorder result

            // Push the right child onto the stack if exists
            if (root.right != null) {
                st.push(root.right);
            }

            // Push the left child onto the stack if exists
            if (root.left != null) {
                st.push(root.left);
            }
        }

        // Return the preorder traversal result
        return preorder;
    }
        public static void main(String[] args) {
            // Creating a binary tree
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);

            // Getting the preorder traversal
            List<Integer> result = IterativePreorderTraversal.preorderTraversal(root);

            // Displaying the preorder traversal result
            System.out.print("Preorder Traversal: ");
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
}

