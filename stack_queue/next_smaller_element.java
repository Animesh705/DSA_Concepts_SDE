package stack_queue;
import java.util.*;
public class next_smaller_element {
        // Function to find next smaller element using stack
        public int[] nextSmallerElement(int[] arr) {
            int n = arr.length;

            // Stack to keep potential next smaller elements
            Stack<Integer> st = new Stack<>();

            // Initialize result array with -1
            int[] ans = new int[n];
            Arrays.fill(ans, -1);

            // Traverse from right to left
            for (int i = n - 1; i >= 0; i--) {

                // Pop elements from stack that are not smaller
                while (!st.isEmpty() && st.peek() >= arr[i]) {
                    st.pop();
                }

                // If stack not empty, top is the next smaller element
                if (!st.isEmpty()) {
                    ans[i] = st.peek();
                }

                // Push current element to stack
                st.push(arr[i]);
            }

            // Return result
            return ans;
        }
        public static void main(String[] args) {
            int[] arr = {1, 3, 2, 4};
            next_smaller_element sol = new next_smaller_element();

            // Get next smaller elements
            int[] ans = sol.nextSmallerElement(arr);

            // Print result
            System.out.print("The next smaller elements are: ");
            for (int val : ans) {
                System.out.print(val + " ");
            }
        }
    }
