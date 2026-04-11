//given a coin array , and a target amount , we can take any coin any number of time , total ways that sum upto target
package DP;
import java.util.*;
public class dp22_coinChange2 {
    public int ways(int ind, int[] coins, int target, int[][] dp) {

        if(ind==0){
            return (target % coins[ind] == 0) ? 1:0;
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        int notpick= ways(ind-1, coins, target, dp);
        //for every case where we can take any element any number of times(REPETITION),
        // in that case when we pick , we dont move the index.
        int pick=0;
        if(coins[ind]<=target){
            pick=ways(ind, coins, target-coins[ind], dp);
        }
        return dp[ind][target] = notpick + pick;
    }
    public int coinChange(int[] coins, int target) {
        int n = coins.length;
        //remember our recursion depends on coins array ind and target , so we create the dp for them only
        int[][] dp= new int[n][target+1];
        for(int[] i:dp) {
            Arrays.fill(i,-1);
        }

        return ways(n-1,coins,target,dp);
    }
    public static void main(String[] args) {
        int[] coins={1,2,3};
        int target=4;

        dp22_coinChange2 obj = new dp22_coinChange2();
        System.out.println(obj.coinChange(coins, target));
    }
}
