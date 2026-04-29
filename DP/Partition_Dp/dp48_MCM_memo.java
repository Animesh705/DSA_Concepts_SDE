package DP.Partition_Dp;
import java.util.*;
public class dp48_MCM_memo {
    public int f(int i, int j,int[] arr,int[][] dp){
        if(i==j) return 0;
        int mini=(int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=i;k<j;k++){
            int steps=(arr[i-1]*arr[k]*arr[j]) +f(i,k,arr,dp)+f(k+1,j,arr,dp);
            mini=Math.min(mini,steps);
        }
        return dp[i][j]=mini;
    }
    public int multiplication(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][n];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return f(1,n-1,arr,dp);
    }
    public static void main(String[] args) {
        int[] arr={40, 20, 30, 10, 30};

        System.out.println(new dp48_Matrix_chain_multiplication().multiplication(arr));
    }
}
