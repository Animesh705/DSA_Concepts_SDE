package stack_queue;
import java.util.*;
public class Sliding_Window_Max {
        // Function to return the max of each sliding window of size k
        public List<Integer> maxSlidingWindow(int[] nums, int k) {
            // Deque to store indices of useful elements
            Deque<Integer> dq = new LinkedList<>();

            // List to store result
            List<Integer> result = new ArrayList<>();

            // Loop through each element
            for (int i = 0; i < nums.length; i++) {
                // Remove indices out of current window
                if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                    dq.pollFirst();
                }

                // Remove smaller values from the back of deque
                while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                    dq.pollLast();
                }

                // Add current index
                dq.offerLast(i);

                // Add to result once the first window is formed
                if (i >= k - 1) {
                    result.add(nums[dq.peekFirst()]);
                }
            }

            // Return result list
            return result;
        }
        public static void main(String[] args) {
            Sliding_Window_Max obj = new Sliding_Window_Max();

            int[] arr = {4, 0, -1, 3, 5, 3, 6, 8};
            int k = 3;

            List<Integer> ans = obj.maxSlidingWindow(arr, k);

            for (int num : ans) {
                System.out.print(num + " ");
            }
        }
    }
