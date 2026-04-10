package DP;
import java.util.*;
/*
public class dp14_subsetSum_equal_target {
    public static boolean targetSum(int ind,int target, int[] arr){
        if(target == 0) return true;
        if(ind == 0) return (arr[0]==target);

        boolean notTake = targetSum(ind-1, target, arr);
        boolean take = false;
        if(target >= arr[ind]){
            take = targetSum(ind-1, target-arr[ind], arr);
        }
        return (notTake || take);

    }
    public static boolean found(int n,int[] arr,int target){
        return targetSum(n-1,target,arr);
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        int k = 4;
        dp14_subsetSum_equal_target sol = new dp14_subsetSum_equal_target();

        if (sol.found(arr.length, arr, k))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
 */
public class dp14_subsetSum_equal_target {
    public static boolean targetSum(int ind,int target, int[] arr, int[][] dp){
        if(target == 0) return true;
        if(ind == 0) return (arr[0]==target);

        if(dp[ind][target] != -1) return dp[ind][target] == 1;

        boolean notTake = targetSum(ind-1, target, arr,dp);
        boolean take = false;
        if(target >= arr[ind]){
            take = targetSum(ind-1, target-arr[ind], arr,dp);
        }
        dp[ind][target] = (notTake || take) ? 1:0;
        return (notTake || take);

    }
    public static boolean found(int n,int[] arr,int target){
        int[][] dp = new int[n][target+1];

        for(int i = 0; i < n; i++) Arrays.fill(dp[i],-1);

        return targetSum(n-1,target,arr,dp);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 5};
        int k = 4;
        dp14_subsetSum_equal_target sol = new dp14_subsetSum_equal_target();

        if (sol.found(arr.length, arr, k))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
