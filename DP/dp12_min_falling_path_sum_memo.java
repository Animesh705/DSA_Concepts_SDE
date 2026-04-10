package DP;
import java.util.*;
public class dp12_min_falling_path_sum_memo {
    public static int pathSum(int r, int c, int[][] grid, int[][] dp) {
        int n=grid.length;
        int m=grid[0].length;
        //defining the base cases in terms of r and c
        //1. out of bound case
        if(c<0 || c>=m) return (int)1e9;
        //2.recahing the destination
        if(r==0) return grid[0][c];
        //check the dp array if the answer for the sub-problem exist , if yes return the ans
        if(dp[r][c]!=-1) return dp[r][c];
        //now exploring all the path using for loop and r&c
        int straight = grid[r][c]+ pathSum(r-1, c, grid, dp);
        int leftDiagonal = grid[r][c]+ pathSum(r-1, c-1, grid, dp);
        int rightDiagonal = grid[r][c]+ pathSum(r-1, c+1, grid, dp);

        return dp[r][c]=Math.min(straight,Math.min(leftDiagonal,rightDiagonal));
    }
    public static int minFallingPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];

        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        //the end point is not fixed , so calling recursion for every possible destination
        int maxi = Integer.MAX_VALUE;
        for(int j = 0; j < col; j++) {
            maxi = Math.min(maxi, pathSum(row - 1, j, grid, dp));
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {5, 9, 6},
                {11, 5, 2}
        };

        dp12_min_falling_path_sum_memo sol= new dp12_min_falling_path_sum_memo();
        System.out.print(sol.minFallingPathSum(grid));
    }
}
