//Problem Statement: Given a m x n grid filled with non-negative numbers,
//find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
//Note: You can only move either down or right at any point in time.
package DP;
import java.util.*;
public class dp10_min_path_sum_memo {
        public static int paths(int i, int j, int[][] grid,int[][] dp ){
            //base case : when we reach our target we return the value of that cell
            if(i==0 && j==0) return grid[0][0];
            // if we go outside the matrix means the path is invalid therefore return the gretest value of integer;
            if(i<0 || j<0) return (int)1e9;
            //check the dp array if the answer for the sub-problem exist , if yes return the ans
            if(dp[i][j]!=-1) return dp[i][j];
            //claculating the path , by going up and left
            int up= grid[i][j] + paths(i-1, j,grid, dp); // current cell + upar wale cell ka best path
            int left= grid[i][j] + paths(i, j-1,grid, dp); //current cell + left wale cell ka best path
// returning the sum of left and up path, refer to notes for its dry run and intuition
            return dp[i][j]= Math.min(up,left);
        }
        public static int minPaths(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            //1.initialized a dp array of mXn size
            int[][] dp = new int[row][col];
            //2.filling the  dp array with -1
            for(int[] i:dp){
                Arrays.fill(i,-1);
            }
            //3.calling recursion
            return paths(row-1,col-1,grid,dp);
        }
        public static void main(String[] args) {
            int[][] grid = {
                    {1,2,3},{4,5,6}
            };

            dp10_min_path_sum_memo sol= new dp10_min_path_sum_memo();
            System.out.print(sol.minPaths(grid));
        }
    }
