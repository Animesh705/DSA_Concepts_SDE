package DP;
import java.util.*;
public class dp33_edit_distance_memo {
        public int f(int i,int j,String word1,String word2,int[][] dp){
            if(i<0) return j+1;
            if(j<0) return i+1;

            if(dp[i][j] != -1) return dp[i][j];

            if(word1.charAt(i)==word2.charAt(j)){
                return dp[i][j]=(0+f(i-1,j-1,word1,word2,dp));
            }else{
                return dp[i][j]= Math.min((1+f(i,j-1,word1,word2,dp)),
                        Math.min((1+f(i-1,j,word1,word2,dp)),
                                (1+f(i-1,j-1,word1,word2,dp))));
            }
        }
        public int minDistance(String word1, String word2) {
            int n=word1.length();
            int m=word2.length();

            int[][] dp= new int[n+1][m+1];
            for(int[] row:dp) Arrays.fill(row,-1);

            return f(n-1,m-1,word1,word2,dp);
        }
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String word1 = sc.nextLine();
            String word2 = sc.nextLine();

            dp33_edit_distance_memo obj = new dp33_edit_distance_memo();
            System.out.println(obj.minDistance(word1,word2));
        }
}
