package stack_queue;
import java.util.*;
public class Stock_span {
        /*
         Function to find Previous Greater Element (PGE) index
         For each index i, we find the nearest index on the LEFT
         such that arr[index] > arr[i]
         If no such index exists, store -1
        */
        private int[] findPGE(int[] arr) {

            int n = arr.length;   // Total number of elements

            // Array to store index of Previous Greater Element for each index
            int[] ans = new int[n];

        /*
         Stack will store INDICES (not values)
         Stack property:
         - Elements in stack will be in decreasing order of values
        */
            Stack<Integer> st = new Stack<>();

            // Traverse array from left to right
            for (int i = 0; i < n; i++) {

                int currEle = arr[i]; // Current element value

            /*
             Jab tak stack empty nahi hai
             aur stack ke top ka element current element se chhota ya equal hai
             tab tak pop karo

             Reason:
             - Smaller elements kabhi PGE nahi ban sakte
             - Current element unhe future ke liye useless bana deta hai
            */
                while (!st.isEmpty() && arr[st.peek()] <= currEle) {
                    st.pop();
                }

            /*
             Agar stack empty ho gaya
             matlab left side me koi greater element nahi mila
            */
                if (st.isEmpty())
                    ans[i] = -1;
                else
                    // Stack ka top hi Previous Greater Element ka index hoga
                    ans[i] = st.peek();

            /*
             Current index ko stack me push karo
             Taaki ye future elements ke liye candidate ban sake
            */
                st.push(i);
            }

            // PGE indices return karo
            return ans;
        }

        /*
         Function to calculate stock span
         Span[i] = number of consecutive days before i
         where price <= price[i]
        */
        public int[] stockSpan(int[] arr, int n) {

            // Step 1: Find Previous Greater Element indices
            int[] PGE = findPGE(arr);

            // Array to store final span result
            int[] ans = new int[n];

        /*
         Step 2: Calculate span using formula
         span[i] = i - PGE[i]

         Why this works?
         - If PGE[i] = -1 → span = i + 1
         - Else → distance from previous greater element
        */
            for (int i = 0; i < n; i++) {
                ans[i] = i - PGE[i];
            }

            // Return stock span for each day
            return ans;
        }
        public static void main(String[] args) {

            int n = 7; // Number of days

            // Stock prices for each day
            int[] arr = {120, 100, 60, 80, 90, 110, 115};

            // Create Solution object
            Stock_span sol = new Stock_span();

            // Get stock span result
            int[] ans = sol.stockSpan(arr, n);

            // Print result
            System.out.print("The span of stock prices is: ");
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
        }
    }
