package BinaryTree;

public class LCA {
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in left and right subtrees
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        // Result
        if (left == null) return right;
        if (right == null) return left;
        return root; // Both sides returned non-null, this is the LCA
    }
    public static void main(String[] args) {
        // Construct a sample binary tree
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        LCA solution = new LCA();
        Node p = root.left;       // Node with value 5
        Node q = root.right;      // Node with value 1

        Node lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.data);
    }
}
