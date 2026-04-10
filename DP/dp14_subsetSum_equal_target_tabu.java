package DP;
import  java.util.*;
public class dp14_subsetSum_equal_target_tabu {
    public static boolean found(int n,int[] arr,int k) {
        // Create DP table with n rows and k+1 columns, default false
        boolean[][] dp = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        // Base case: If first element <= k, mark dp[0][arr[0]] true
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill the DP table iteratively
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Option 1: Do not take the current element
                boolean notTaken = dp[ind - 1][target];

                // Option 2: Take current element if it does not exceed target
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                // Mark current cell as true if either option is true
                dp[ind][target] = notTaken || taken;
            }

        }
        // Return whether sum k can be formed using all elements
        return dp[n - 1][k];
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 5};
        int k = 4;
        dp14_subsetSum_equal_target_tabu sol = new dp14_subsetSum_equal_target_tabu();

        if (sol.found(arr.length, arr, k))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
