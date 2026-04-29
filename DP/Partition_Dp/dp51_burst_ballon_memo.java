package DP.Partition_Dp;
import java.util.*;
public class dp51_burst_ballon_memo {
    public int f(int i, int j,int[] a,int[][] dp){
        if(i>j) return 0;
        int maxi= Integer.MIN_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i;ind<=j;ind++){
            int cost=(a[i-1]*a[ind]*a[j+1])+f(i,ind-1,a,dp)+f(ind+1,j,a,dp);
            maxi=Math.max(maxi,cost);
        }
        return dp[i][j]=maxi;
    }
    public int maxCost(int[] ballons){
        int n = ballons.length;
        int[] a=new int[n+2];
        //padding req.
        //for adding 1 on start and end for last ballon
        a[0] = 1;
        a[n+1] = 1;
        for(int i=1;i<=n;i++){
            a[i]=ballons[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return f(1,n,a,dp);
    }
    public static void main(String[] args) {
        int[] ballons ={3, 1, 5, 8};

        System.out.print(new  dp51_burst_ballon_memo().maxCost(ballons));
    }
}
