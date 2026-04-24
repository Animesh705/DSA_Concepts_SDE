package DP.stocks;
import java.util.*;
public class dp36_buy_and_sell_stockII {
    public int f(int i,int buy,int[] prices,int[][] dp) {
        int profit=0;
        if(i==prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];

        if(buy==1) {
            //two option we have either buy or sell
            //but for buying also two option , buy or not buy
            profit = Math.max((-prices[i] + f(i + 1, 0, prices, dp)), (0 + f(i + 1, 1, prices, dp)));
        }else{
            //but for selling also two option , sell or not sell
            profit=Math.max((prices[i] + f(i + 1, 1, prices, dp)), (0 + f(i + 1, 0, prices, dp)));
        }

        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int[] row:dp) Arrays.fill(row,-1);

        return f(0,1,prices,dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i=0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        dp36_buy_and_sell_stockII obj = new dp36_buy_and_sell_stockII();
        System.out.println(obj.maxProfit(prices));
    }

}
