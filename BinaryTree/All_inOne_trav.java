package BinaryTree;
import java.util.*;
class Pair {
    Node node;
    int num;

    Pair(Node node, int num) {
        this.node = node;
        this.num = num;
    }
}
public class All_inOne_trav {
    // Function to get the Preorder,
    // Inorder and Postorder traversal
    // Of Binary Tree in One traversal
    public List<List<Integer>> preInPostTraversal(Node root) {
        // Lists to store traversals
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        // If the tree is empty,
        // return empty traversals
        if (root == null) {
            return new ArrayList<>();
        }

        // Stack to maintain nodes
        // and their traversal state
        Stack<Pair> st = new Stack<>();

        // Start with the root node
        // and state 1 (preorder)
        st.push(new Pair(root, 1));

        while (!st.empty()) {
            Pair it = st.pop();

            // this is part of pre
            if (it.num == 1) {
                // Store the node's data
                // in the preorder traversal
                pre.add(it.node.data);
                // Move to state 2
                // (inorder) for this node
                it.num++;
                // Push the updated state
                // back onto the stack
                st.push(it);

                // Push left child onto
                // the stack for processing
                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }

            // this is a part of in
            else if (it.num == 2) {
                // Store the node's data
                // in the inorder traversal
                in.add(it.node.data);
                // Move to state 3
                // (postorder) for this node
                it.num++;
                // Push the updated state
                // back onto the stack
                st.push(it);

                // Push right child onto
                // the stack for processing
                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }

            // this is part of post
            else {
                // Store the node's data
                // in the postorder traversal
                post.add(it.node.data);
            }
        }

        // Returning the traversals
        List<List<Integer>> result = new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;
    }

    // Function to print the elements of a list
    public void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Create object of Solution class
        All_inOne_trav sol = new All_inOne_trav();

        // Getting the pre-order, in-order,
        // and post-order traversals
        List<List<Integer>> traversals = sol.preInPostTraversal(root);

        // Extracting the traversals
        List<Integer> pre = traversals.get(0);
        List<Integer> in = traversals.get(1);
        List<Integer> post = traversals.get(2);

        // Printing the traversals
        System.out.print("Preorder traversal: ");
        sol.printList(pre);

        System.out.print("Inorder traversal: ");
        sol.printList(in);

        System.out.print("Postorder traversal: ");
        sol.printList(post);
    }
}
