package DP;
import java.util.*;
public class g5_maxSum_nonAdjacent_tabu {
    public int maxSum(int[] nums) {
        int n=nums.length;
        //initilaized the dp array
        int[] dp=new int[n];
        //added the base case
        dp[0]=nums[0];
//if only one element is present
        if(n==1) return 0;
        // Compare first two elements
        dp[1] = Math.max(nums[0], nums[1]);

        // Iterate from index 2
        for (int i = 2; i < n; i++) {
            // Take current and dp[i-2] or just dp[i-1]
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        // Return result from last index
        return dp[n - 1];
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //size of array
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=sc.nextInt();

        g5_maxSum_nonAdjacent_tabu sol = new g5_maxSum_nonAdjacent_tabu();
        System.out.println(sol.maxSum(nums));
    }
}
