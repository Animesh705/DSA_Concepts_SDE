package DP;
import java.util.*;
import static java.lang.Math.abs;
public class dp3_frog_prob_memo {
public static int jump(int ind,int[] height, int[] dp){
    // base case , for zero to zero always == 0
    if (ind == 0) return 0;
    //if the ans for the sub-problem is already present reuse else re compute
    if(dp[ind] != -1) return dp[ind];
    //for somecase there can't be right present like when ind<1
    int right=Integer.MAX_VALUE;
    // calculating left as first jump
    int left = jump(ind-1,height,dp) + Math.abs(height[ind]-height[ind-1]);
    //calculating the 2nd jump
    if(ind>1) {
        right = jump(ind - 2,height,dp) + Math.abs(height[ind] - height[ind - 2]);
    }
    //storing the ans in dp array
    dp[ind] = Math.min(left,right);
    return dp[ind];
}
    public static int frog(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n=height.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
         return jump(n-1,height,dp);
    }
        public static void main(String[] args) {
            // Define the heights array
            int[] height = {30, 10, 60, 10, 60, 50};

            // Create Solution instance
            dp3_frog_prob_memo sol = new dp3_frog_prob_memo();

            // Compute and print the minimum energy
            System.out.println(sol.frog(height)); // Expected: 40
        }
}
