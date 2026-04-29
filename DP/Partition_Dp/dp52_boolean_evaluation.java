package DP.Partition_Dp;
import java.util.*;
public class dp52_boolean_evaluation {
    public int f(int i, int j,int isTrue, int[] a, int[][][] dp){
        if(i>j) return 0;
        if(i==j) {
            if (isTrue == 1) {
                return a[i] == 'T' ? 1 : 0;
            } else {
                return a[i] == 'F' ? 1 : 0;
            }
        }
            if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];

            int ways=0;
            for(int k=i+1;k<=j-1;k=k+2){
                //left true
                int lt= f(i,k-1,1,a,dp);
                int rt= f(k+1,j,1,a,dp);
                int lf= f(i,k-1,0,a,dp);
                int rf= f(k+1,j,0,a,dp);

                if(a[k] == '&') {
                    if (isTrue == 1) {
                        ways += lt * rt;
                    } else {
                        ways += (lt * rf) + (lf * rt) + (lf * rf);
                    }
                }
                if(a[k] == '|') {
                        if (isTrue == 1) {
                            ways += (lt * rt) + (lt * rf) + (lf * rt);
                        } else {
                            ways += (lf * rf);
                        }
                    }
                if(a[k] == '^') {
                    if (isTrue == 1) {
                        ways += (lt*rf) + (lf*rt);
                    }else{
                        ways += (lt*rt)+(lf*rf);
                    }
                }
            }
        return dp[i][j][isTrue] = ways;
    }
    public int evaluation(String s) {
        int n = s.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i);
        }
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return f(0, n - 1, 1, a, dp);
    }
    public static void main(String[] args) {
        String exp = "F|T^F";  // Example expression

        // Evaluate the expression and find the number of ways to get the result as True
        int ways = new dp52_boolean_evaluation().evaluation(exp);

        // Output the result
        System.out.println("The total number of ways: " + ways);
    }
}
