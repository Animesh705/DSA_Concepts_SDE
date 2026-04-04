//Problem Statement: Given an array of N positive integers,
//we need to return the maximum sum of the subsequence such that no two elements of the subsequence are adjacent elements in the array.
package DP;
import java.util.*;
public class g5_maxSum_nonAdjacent_memo {
    public int sum(int[] nums,int i,int[] dp){
        // No element to pick
        if (i < 0) return 0;

        // Only one element
        if (i == 0) return nums[0];

        // Return stored result in dp array
        if (dp[i] != -1) return dp[i];

        // Pick current and move 2 back , 2 because cant pick teh adjacent one
        int pick = nums[i] + sum(nums, i - 2, dp);

        // Don't pick current, move 1 back
        int notPick = sum(nums, i - 1, dp);

        // Memoize and return result
        return dp[i] = Math.max(pick, notPick);
    }
    public int maxSum(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
// calling for recursion call
        return sum(nums,n-1,dp);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //size of array
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=sc.nextInt();

        g5_maxSum_nonAdjacent_memo sol = new g5_maxSum_nonAdjacent_memo();
        System.out.println(sol.maxSum(nums));
    }
}
