//thier is a thief went for stealing , he has a bag with capacity leftWeight , cant exceed , but he need to pick with sum of max value
//given a wt array and value array for every item
package DP;
import java.util.*;
public class dp19_knapsack {
    /* recursive solution
    public static int steal(int ind,int leftWt,int[] wt,int[] val ){
        if(ind == 0){
            if(leftWt>=wt[ind]){
                return val[0];
            }else return 0;
        }
        int notpick= 0 + steal(ind-1,leftWt,wt,val);
        int pick = Integer.MIN_VALUE;
        if(leftWt>=wt[ind]){
            pick = val[ind] + steal(ind-1,leftWt-wt[ind],wt,val);
        }
        return Math.max(notpick,pick);
    }
    public static int totalValue(int[] wt,int[] val, int Bwt){
        int n=val.length;

        return steal(n-1,Bwt,wt,val);
    }
     */
    public static int steal(int ind,int leftWt,int[] wt,int[] val ,int[][] dp){

        if(dp[ind][leftWt] != -1) return dp[ind][leftWt] = 1;

        if(ind == 0){
            if(leftWt>=wt[ind]){
                return val[0];
            }else return 0;
        }
        int notpick= 0 + steal(ind-1,leftWt,wt,val,dp);
        int pick = Integer.MIN_VALUE;
        if(leftWt>=wt[ind]){
            pick = val[ind] + steal(ind-1,leftWt-wt[ind],wt,val,dp);
        }
        return dp[ind][leftWt]=Math.max(notpick,pick);
    }
    public static int totalValue(int[] wt,int[] val, int Bwt){
        int n=val.length;
        //our function depends on two thing basically that is index and leftweight
        int[][] dp = new int[n][Bwt+1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return steal(n-1,Bwt,wt,val,dp);
    }
    public static void main(String[] args){
        int[] wt={3,2,5};
        int[] val={30,40,60};
        int Bwt=6;

        dp19_knapsack obj= new dp19_knapsack();
        System.out.print(obj.totalValue(wt,val,Bwt));
    }
}
