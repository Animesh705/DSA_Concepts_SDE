package DP.Longest_inc_subSeq;
import java.util.*;

public class len_of_LIS {

    public int length(int i, int prev, int[] nums, int n, int[][] dp) {

        if(i == n) return 0;

        if(dp[i][prev+1] != -1) return dp[i][prev+1];

        int len = length(i+1, prev, nums, n, dp);

        if(prev == -1 || nums[prev] < nums[i]){
            len = Math.max(len, 1 + length(i+1, i, nums, n, dp));
        }

        return dp[i][prev+1] = len;
    }

    public int lengthOfLIS(int[] nums, int n){

        int[][] dp = new int[n][n+1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return length(0, -1, nums, n, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=8;
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        len_of_LIS obj = new len_of_LIS();
        System.out.println(obj.lengthOfLIS(nums, n));
    }
}