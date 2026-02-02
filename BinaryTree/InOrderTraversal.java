package BinaryTree;
import java.util.*;


public class InOrderTraversal {
        public void inorderTraversal(Node root,java.util.List<Integer> inorder) {
            if(root==null) return;

            inorderTraversal(root.left,inorder);
            inorder.add(root.data);
            inorderTraversal(root.right,inorder);
        }
        public List<Integer> inorder(Node root) {
            List<Integer> list=new ArrayList<>();
            inorderTraversal(root,list);
            return list;
        }
    public static void main(String[] args) {

        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting preorder traversal
        InOrderTraversal sol = new InOrderTraversal();
        List<Integer> result = sol.inorder(root);

        // Displaying the preorder traversal result
        System.out.print("inorder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
