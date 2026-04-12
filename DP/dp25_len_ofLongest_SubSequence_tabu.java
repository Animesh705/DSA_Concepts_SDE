////dp[i][j] ka matlab hai:
////s1 ke pehle i characters
////aur s2 ke pehle j characters ka LCS
/// Isliye (i-1) use hota hai
/// 👉 Yeh “previous” nahi, “current char” hai
///
/// dp[i][j] depends on smaller problems:
/// dp[i-1][j]
/// dp[i][j-1]
/// dp[i-1][j-1]
/// i+1 future value use karega → not computed yet ❌
///
/// dp[0][*] = 0 → empty string
/// dp[*][0] = 0 → empty string
/// int[][] dp = new int[n+1][m+1];
package DP;

import java.util.Arrays;
public class dp25_len_ofLongest_SubSequence_tabu {
    public static int lengthOfLongestSubSequence(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[][] dp= new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String args[]){
        String s1="abc";
        String s2="bdc";

        dp25_len_ofLongest_SubSequence_tabu obj=new dp25_len_ofLongest_SubSequence_tabu();
        System.out.println(obj.lengthOfLongestSubSequence(s1,s2));
    }
}
