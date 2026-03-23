package BinaryTree;
import java.util.*;

public class constructBT_from_preANDinoreder {

    // Main function jo tree banata hai
    public Node buildTree(int[] preorder, int[] inorder) {

        // inorder ka value -> index store kar rahe hain (fast lookup ke liye)
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        // recursive build start
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, inMap);
    }

    // Helper recursive function
    private Node build(int[] preorder, int preStart, int preEnd,
                       int[] inorder, int inStart, int inEnd,
                       Map<Integer, Integer> inMap) {

        // Base case: agar range invalid ho gayi → koi node nahi
        if (preStart > preEnd || inStart > inEnd) return null;

        // preorder ka first element hamesha root hota hai
        Node root = new Node(preorder[preStart]);

        // inorder me root ka index find karo
        int inRoot = inMap.get(root.data);

        // left subtree me kitne nodes hain
        int numsLeft = inRoot - inStart;

        /*
        Ab important part:

        preorder:
        [root | left subtree | right subtree]

        inorder:
        [left subtree | root | right subtree]
        */

        // LEFT subtree build
        root.left = build(preorder,
                preStart + 1,                 // left subtree ka start
                preStart + numsLeft,          // left subtree ka end
                inorder,
                inStart,                      // inorder left start
                inRoot - 1,                   // inorder left end
                inMap);

        // RIGHT subtree build
        root.right = build(preorder,
                preStart + numsLeft + 1,      // right subtree start
                preEnd,                       // right subtree end
                inorder,
                inRoot + 1,                   // inorder right start
                inEnd,                        // inorder right end
                inMap);

        return root;
    }

    // inorder print (verify karne ke liye)
    public static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};

        constructBT_from_preANDinoreder sol = new constructBT_from_preANDinoreder();

        Node root = sol.buildTree(preorder, inorder);

        System.out.println("Inorder of Unique Binary Tree Created:");
        printInorder(root);
    }
}