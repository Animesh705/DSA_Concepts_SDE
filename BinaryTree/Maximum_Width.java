package BinaryTree;
import java.util.*;

public class Maximum_Width {

    // Custom Pair class (simple and correct)
    static class Pair {
        Node node;
        int index;

        Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // Function to find maximum width
    public int widthOfBinaryTree(Node root) {

        if (root == null) return 0;

        int maxWidth = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {

            int size = q.size();
            int minIndex = q.peek().index;

            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {

                Pair p = q.poll();
                Node node = p.node;
                int currIndex = p.index - minIndex;

                if (i == 0) first = currIndex;
                if (i == size - 1) last = currIndex;

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * currIndex + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * currIndex + 2));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(9);

        Maximum_Width sol = new Maximum_Width();
        System.out.println("Maximum width: " + sol.widthOfBinaryTree(root));
    }
}