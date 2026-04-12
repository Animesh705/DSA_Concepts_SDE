package DP;
import java.util.*;
public class dp25_len_ofLongest_SubSequence {
    public static int sub(int ind1 , int ind2, String s1, String s2,int[][] dp){
        if(ind1 < 0 || ind2 < 0){
            //return dp[ind1][ind2]=0; this will wrong dp[-1] out of bound
            return 0;
        }
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

        if(s1.charAt(ind1) == s2.charAt(ind2))
            return dp[ind1][ind2]=1+sub(ind1-1, ind2-1, s1, s2, dp);
        return dp[ind1][ind2]=Math.max(sub(ind1-1,ind2,s1,s2,dp),sub(ind1, ind2-1, s1, s2, dp));
    }
    public static int lengthOfLongestSubSequence(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[][] dp= new int[n][m];

        for(int[] i:dp) Arrays.fill(i,-1);
//remember string are also zero based indexed
        return sub(n-1,m-1,s1,s2,dp);
    }
    public static void main(String args[]){
        String s1="abc";
        String s2="bdc";

        dp25_len_ofLongest_SubSequence obj=new dp25_len_ofLongest_SubSequence();
        System.out.println(obj.lengthOfLongestSubSequence(s1,s2));
    }
}
