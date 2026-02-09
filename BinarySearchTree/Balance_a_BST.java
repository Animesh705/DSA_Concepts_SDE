package BinarySearchTree;
import java.util.*;

public class Balance_a_BST {

    // Ye function BST ko balance karke naya balanced BST return karta hai
    public TreeNode balanceBST(TreeNode root) {

        // Inorder traversal ka result yahan store hoga (sorted order)
        List<Integer> inorder = new ArrayList<>();

        // Step 1: inorder traversal
        inorderTraversal(root, inorder);

        // Step 2: sorted list se balanced BST banana
        return createBalancedBST(inorder, 0, inorder.size() - 1);
    }

    // Inorder traversal: Left -> Root -> Right
    // BST ke case me ye sorted values deta hai
    private void inorderTraversal(TreeNode root, List<Integer> inorder) {
        if (root == null) return;

        inorderTraversal(root.left, inorder);
        inorder.add(root.data);
        inorderTraversal(root.right, inorder);
    }

    // Sorted list se balanced BST create karta hai
    private TreeNode createBalancedBST(List<Integer> inorder, int start, int end) {

        // Base case
        if (start > end) return null;

        // Middle element ko root banate hain
        int mid = start + (end - start) / 2;

        // Left aur right subtree recursively bante hain
        TreeNode leftSubtree = createBalancedBST(inorder, start, mid - 1);
        TreeNode rightSubtree = createBalancedBST(inorder, mid + 1, end);

        // New node create ho raha hai (old tree ke nodes reuse nahi ho rahe)
        TreeNode node = new TreeNode(inorder.get(mid));
        node.left = leftSubtree;
        node.right = rightSubtree;
        return node;
    }

    // 🔥 Level order traversal with nulls (LeetCode style print)
    public static List<String> printTree(TreeNode root) {

        List<String> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(curr.data));
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }

        // Trailing nulls remove kar dete hain
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i);
            i--;
        }

        return result;
    }

    // ✅ Main function (LeetCode ke bahar test karne ke liye)
    public static void main(String[] args) {

        // Input: [1,null,2,null,3,null,4]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        Balance_a_BST sol = new Balance_a_BST();

        // Balanced BST ka root
        TreeNode balancedRoot = sol.balanceBST(root);

        // Poora balanced tree print
        System.out.println(printTree(balancedRoot));
    }
}