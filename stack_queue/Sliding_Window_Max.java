package stack_queue;
import java.util.*;
public class Sliding_Window_Max {
        // Function to return maximum of each sliding window of size k
        public List<Integer> maxSlidingWindow(int[] nums, int k) {

        /*
         Deque (Double Ended Queue) store karega INDEXES of elements.
         Important:
         - Values nahi, indexes store karte hain
         - Deque ko is tarah maintain karte hain ki:
           front -> maximum element ka index
        */
            Deque<Integer> dq = new LinkedList<>();

            // Result list jisme har window ka maximum store hoga
            List<Integer> result = new ArrayList<>();

            // Array ke har element ke liye loop
            for (int i = 0; i < nums.length; i++) {

            /*
             STEP 1: Window ke bahar ke elements hatao
             Current window range = [i - k + 1, i]
             Agar deque ka front index window se bahar ho gaya,
             to usse remove kar do
            */
                if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                    dq.pollFirst();
                }

            /*
             STEP 2: Deque ko decreasing order me maintain karo
             Jab tak:
             - Deque empty na ho
             - Last element ka value current element se chhota ho
             Tab tak last element hata do

             Kyunki:
             - Chhota element future windows me kabhi max nahi banega
            */
                while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                    dq.pollLast();
                }

            /*
             STEP 3: Current index deque ke end me add karo
             Ab deque me elements:
             front -> maximum
             back  -> smaller elements
            */
                dq.offerLast(i);

            /*
             STEP 4: Result tab add karo jab pehli window complete ho
             (i >= k - 1)
             Deque ke front par hamesha max element ka index hota hai
            */
                if (i >= k - 1) {
                    result.add(nums[dq.peekFirst()]);
                }
            }

            // Final result return karo
            return result;
        }
        public static void main(String[] args) {

            Sliding_Window_Max obj = new Sliding_Window_Max();

            int[] arr = {4, 0, -1, 3, 5, 3, 6, 8};
            int k = 3;

            // Function call
            List<Integer> ans = obj.maxSlidingWindow(arr, k);

            // Print result
            for (int num : ans) {
                System.out.print(num + " ");
            }
        }
    }
