package BinaryTree;
import java.util.*;
public class LevelOrderTraversal {
        // Function to perform level-order traversal of a binary tree
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> level = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    Node node = q.poll();
                    level.add(node.data);

                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
                ans.add(level);
            }
            return ans;
        }
        public static void main(String[] args) {
            // Creating a sample binary tree
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);

            LevelOrderTraversal solution = new LevelOrderTraversal();
            List<List<Integer>> result = solution.levelOrder(root);

            System.out.println("Level Order Traversal of Tree:");
            for (List<Integer> level : result) {
                System.out.println(level);
            }
        }
    }
