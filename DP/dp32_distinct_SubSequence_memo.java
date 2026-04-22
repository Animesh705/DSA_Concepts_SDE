package DP;

import java.util.*;

public class dp32_distinct_SubSequence_memo {
    public int f(int i,int j,String s,String t,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j] != -1)  return dp[i][j];

        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=(f(i-1,j-1,s,t,dp)+f(i-1,j,s,t,dp));
        }else{
            return dp[i][j]=f(i-1,j,s,t,dp);
        }


    }
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] row :dp) Arrays.fill(row,-1);

        return f(n-1,m-1,s,t,dp);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();

        dp32_distinct_SubSequence_memo obj = new dp32_distinct_SubSequence_memo();
        System.out.println(obj.numDistinct(s, t));
    }
}
