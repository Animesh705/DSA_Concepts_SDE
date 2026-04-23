package DP.stocks;
import java.util.*;
public class dp35_best_buy_sell {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++) {
            int cost =prices[i]-mini;
            profit= Math.max(profit,cost);
            mini=Math.min(mini,prices[i]);
        }
        return profit;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        dp35_best_buy_sell s=new dp35_best_buy_sell();
        System.out.println(s.maxProfit(arr));
    }
}
