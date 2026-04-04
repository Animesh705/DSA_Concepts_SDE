//Problem Statement:
// Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair.
//At a time the frog can climb either one or two steps. A height[N] array is also given.
//Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]),
//where abs() means the absolute difference.
// We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1..
package DP;
import java.util.*;
import static java.lang.Math.abs;
public class dp3_frog_prob_tabulation {
    public static int frog(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n=height.length;
        //created dp array of n+1 size
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<n;i++){
            int jumpOne = dp[i-1] + Math.abs(height[i] - height[i - 1]);
            int jumpSecond =Integer.MAX_VALUE;
            if(i>1){
                jumpSecond = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            }
            dp[i]=Math.min(jumpOne,jumpSecond);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        // Define the heights array
        int[] height = {30, 10, 60, 10, 60, 50};

        // Create Solution instance
        dp3_frog_prob_tabulation sol = new dp3_frog_prob_tabulation();

        // Compute and print the minimum energy
        System.out.println(sol.frog(height)); // Expected: 40
    }
}
