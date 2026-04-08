package DP;
import java.util.*;
public class dp8_grid_uniq_path_memo {
    public static int paths(int i, int j, int[][] dp ){
        //base case : when we reach our target we return zero
        if(i==0 && j==0) return 1;
        // if we go outside the matrix means the path is invalid therefore return 0;
        if(i<0 || j<0) return 0;
        //check the dpn array if the answer for the sub-problem exist , if yes return the ans
        if(dp[i][j]!=-1) return dp[i][j];
        //claculating the path , by going up and left
        int up= paths(i-1, j, dp);
        int left= paths(i, j-1, dp);
// returning the sum of left and up path, refer to notes for its dry run and intuition
        return dp[i][j]= up+left;
    }
    public static int totalPaths(int row, int col) {
        //1.initialized a dp array of mXn size
        int[][] dp = new int[row][col];
        //2.filling the  dp array with -1
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        //3.calling recursion
        return paths(row-1,col-1,dp);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        dp8_grid_uniq_path_memo sol= new dp8_grid_uniq_path_memo();
        System.out.print(sol.totalPaths(n,m));
    }
}
