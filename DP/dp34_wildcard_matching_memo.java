package DP;
import java.util.*;
public class dp34_wildcard_matching_memo {
    public boolean check(int i,int j,String s,String p,int[][] dp){

        if(i<0 && j<0) return true;

        if(i>=0 && j<0) return false;

        if(i<0 && j>=0){
            while(j>=0){
                if(p.charAt(j)!='*') return false;
                j--;
            }
            return true;
        }

        if(dp[i][j]!=-1) return dp[i][j]==1;

        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
            dp[i][j]=check(i-1,j-1,s,p,dp) ? 1:0;

        else if(p.charAt(j)=='*')
            dp[i][j]=(check(i-1,j,s,p,dp) || check(i,j-1,s,p,dp)) ? 1:0;

        else
            dp[i][j]=0;

        return dp[i][j]==1;

    }

    public boolean isMatch(String s, String p) {

        int n=s.length();
        int m=p.length();

        int[][] dp= new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);

        return check(n-1,m-1,s,p,dp);
    }
        public static void main(String[] args) {
            String S1 = "ab*cd";
            String S2 = "abdefcd";

           dp34_wildcard_matching_memo obj = new dp34_wildcard_matching_memo();
           System.out.println(obj.isMatch(S1,S2));
        }
    }

