package DP.stocks;
import java.util.*;
public class dp37_buy_sell_stock_III_tabu {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        // DP table: dp[ind][buy][cap]
        // ind → current index
        // buy → 0 = can buy, 1 = can sell
        // cap → remaining transactions (max 2)
        int[][][] dp=new int[n+1][2][3];

        // Base case: initialized to 0 → no profit if no transactions left or no days left

        int profit =0;

        for(int i=n-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy==1){
                        // Option 1: skip buying
                        // Option 2: buy today → subtract price, keep cap same
                        profit = Math.max((-prices[i] + dp[i+1][0][cap]), (0 + dp[i+1][1][cap]));
                    }else{
                        // Option 1: skip selling
                        // Option 2: sell today → add price, reduce cap by 1
                        profit=Math.max((prices[i] + dp[i+1][1][cap-1]), (0 + dp[i+1][0][cap]));
                    }
                    dp[i][buy][cap]=profit;
                }
            }
        }
        return dp[0][1][2];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i=0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        dp37_buy_sell_stock_III_tabu obj = new dp37_buy_sell_stock_III_tabu();
        System.out.println(obj.maxProfit(prices));
    }
}
