//Problem Statement: You are given an array 'arr' of size 'n' which denotes the position of stalls. You are also given an integer 'k' which denotes the number of aggressive cows.
//You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible. Find the maximum possible minimum distance.
//
//Examples
//Example 1:
//Input Format:
// N = 6, k = 4, arr[] = {0,3,4,7,10,9}
//Result:
// 3
//Explanation:
// The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways.
//
//Example 2:
//Input Format:
// N = 5, k = 2, arr[] = {4,2,1,3,6}
//Result:
// 5
//Explanation:
// The maximum possible minimum distance between any two cows will be 5 when 2 cows are placed at positions {1, 6}.
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


