package binary_search;
import java.util.*;
public class Angry_coww {
        // Function to check if cows can be placed with min distance d
        public boolean canPlace(int[] stalls, int cows, int d) {
            // Place the first cow at the first stall
            int count = 1;
            int lastPos = stalls[0];

            // Try placing the remaining cows
            for (int i = 1; i < stalls.length; i++) {
                // If current stall is at least 'd' away from last cow
                if (stalls[i] - lastPos >= d) {
                    // Place a cow here
                    count++;
                    lastPos = stalls[i];
                }
                // If all cows placed, return true
                if (count >= cows) return true;
            }
            // Not possible to place all cows
            return false;
        }

        // Function to find maximum minimum distance using brute force
        public int aggressiveCows(int[] stalls, int cows) {
            // Step 1: Sort stall positions
            Arrays.sort(stalls);

            // Step 2: Get the maximum possible distance
            int maxDist = stalls[stalls.length - 1] - stalls[0];

            // Step 3: Variable to store answer
            int ans = 0;

            // Step 4: Try all possible distances
            for (int d = 1; d <= maxDist; d++) {
                // If cows can be placed with distance d
                if (canPlace(stalls, cows, d)) {
                    // Update answer
                    ans = d;
                }
            }
            // Step 5: Return the maximum valid distance
            return ans;
        }
        public static void main(String[] args) {
            // Example input
            int[] stalls = {1, 2, 8, 4, 9};
            int cows = 3;

            // Create object and call function
            Angry_coww obj = new Angry_coww();
            System.out.println(obj.aggressiveCows(stalls, cows));
        }
    }


