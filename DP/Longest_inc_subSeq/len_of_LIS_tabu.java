package DP.Longest_inc_subSeq;
import java.util.*;
public class print_LIC {
    public int lengthOfLIS(int[] nums, int n) {

        int[][] dp = new int[n][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int len = 0 + dp[i + 1][prev + 1];

                if (prev == -1 || nums[prev] < nums[i]) {
                    len = Math.max(len, 1 + dp[i + 1][i + 1]);
                }
                dp[i][prev + 1] = len;
            }
        }
        return dp[0][-1 + 1];
    }
        public static void main(String[] args) {
            int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

            print_LIC sol = new print_LIC();
           int lis = sol.lengthOfLIS(nums);

            System.out.print("LIS: ");
            for (int x : lis) System.out.print(x + " ");
            System.out.println();
        }
    }
