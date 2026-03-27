package BinaryTree;
import java.util.*;
public class morris_inOrder {
    // Function to perform iterative Morris
    // inorder traversal of a binary tree
    public List<Integer> getInorder(Node root) {
        // List to store the
        // inorder traversal result
        List<Integer> inorder = new ArrayList<>();
        // Pointer to the current node,
        // starting from the root
        Node cur = root;

        // Loop until the current
        // node is not NULL
        while (cur != null) {
            // If the current node's
            // left child is NULL
            if (cur.left == null) {
                // Add the value of the current
                // node to the inorder list
                inorder.add(cur.data);
                // Move to the right child
                cur = cur.right;
            } else {
                // If the left child is not NULL,
                // find the predecessor (rightmost node
                // in the left subtree)
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // If the predecessor's right child
                // is NULL, establish a temporary link
                // and move to the left child
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    // If the predecessor's right child
                    // is already linked, remove the link,
                    // add current node to inorder list,
                    // and move to the right child
                    prev.right = null;
                    inorder.add(cur.data);
                    cur = cur.right;
                }
            }
        }

        // Return the inorder
        // traversal result
        return inorder;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);

        morris_inOrder sol = new morris_inOrder();

        List<Integer> inorder = sol.getInorder(root);

        System.out.print("Binary Tree Morris Inorder Traversal: ");
        for (int i = 0; i < inorder.size(); i++) {
            System.out.print(inorder.get(i) + " ");
        }
        System.out.println();
    }
}
