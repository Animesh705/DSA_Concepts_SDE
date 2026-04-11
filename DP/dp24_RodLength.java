package DP;
import java.util.*;
public class dp24_RodLength {
    public static int cut(int ind, int n, int[] price,int[][] dp){
    if(ind==0) {
        return (n*price[0]);
    }
    if(dp[ind][n]!=-1) return dp[ind][n];

    int notpick= cut(ind-1, n, price, dp);
    int pick=0; int rodLength=ind+1;
    if(rodLength<=n){
        pick=price[ind]+cut(ind, n-rodLength, price, dp);
    }
    return dp[ind][n]=Math.max(notpick,pick);
    }
    public static int totalPrice(int[] price, int n){
        int m=price.length;
        int[][] dp = new int[m][n+1];
        for(int[] i:dp) Arrays.fill(i,-1);

        return cut(m-1, n, price, dp);
    }
    public static void main(String[] args) {
        int n=5;
        int[] price={2,5,7,8,10};

        dp24_RodLength obj = new dp24_RodLength();
        System.out.println(obj.totalPrice(price, n));

    }
}
