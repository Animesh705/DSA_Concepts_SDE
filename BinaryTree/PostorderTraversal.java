package BinaryTree;
import java.util.*;
public class PostorderTraversal {
    public void postorderTraversal(Node root,List<Integer> postorder) {
        if(root==null) return;

        postorderTraversal(root.left,postorder);
        postorderTraversal(root.right,postorder);
        postorder.add(root.data);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        postorderTraversal(root,list);
        return list;
    }
    public static void main(String[] args) {

        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting postorder traversal
        PostorderTraversal sol = new PostorderTraversal();
        List<Integer> result = sol.postorder(root);

        // Displaying the postorder traversal result
        System.out.print("postorder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
