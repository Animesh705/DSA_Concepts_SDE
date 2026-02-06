package BinaryTree;
import javax.swing.tree.TreeNode;
import java.util.*;
public class DiameterOFbt {

    // Ye function sirf diameter return karega
    // Diameter = tree ke kisi bhi do nodes ke beech ka longest path
    public int diameterBT(Node root) {

        // Java me primitive int pass by value hota hai
        // Isliye array use kiya taaki recursive calls diameter ko update kar saken
        int[] diameter = new int[1];

        // Height function call karte hi saara kaam ho jaata hai
        height(root, diameter);

        // Final answer
        return diameter[0];
    }

    // Ye function height bhi calculate karta hai
    // Aur saath-saath diameter ko update karta rehta hai
    private int height(Node root, int[] diameter) {

        // Base case:
        // Agar node null hai, height = 0
        if (root == null) return 0;

        // Left subtree ki height nikaalo
        int lh = height(root.left, diameter);

        // Right subtree ki height nikaalo
        int rh = height(root.right, diameter);

        // Important concept:
        // Agar diameter current node se pass ho raha ho,
        // to uski length = left height + right height + 1 (current node)
        diameter[0] = Math.max(diameter[0], lh + rh + 1);

        // Height return karni hai parent ke liye
        // Height = 1 (current node) + max(left, right)
        return 1 + Math.max(lh, rh);
    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        DiameterOFbt solution = new DiameterOFbt();
        int depth = solution.diameterBT(root);

        System.out.println("Maximum diameter of the binary tree: " + depth);
    }
}
