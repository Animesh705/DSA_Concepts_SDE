package DP.stocks;

import java.util.Scanner;

public class dp36_buy_and_sell_stockII_tabula {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];

        dp[n][0]=dp[n][1]=0;
        int profit =0;

        for(int i=n-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    profit = Math.max((-prices[i] + dp[i+1][0]), (0 + dp[i+1][1]));
                }else{
                    profit=Math.max((prices[i] + dp[i+1][1]), (0 + dp[i+1][0]));
                }
                dp[i][buy]=profit;
            }
        }
        return dp[0][1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i=0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        dp36_buy_and_sell_stockII_tabula obj = new dp36_buy_and_sell_stockII_tabula();
        System.out.println(obj.maxProfit(prices));
    }
}
