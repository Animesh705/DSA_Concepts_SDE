package DP;
import java.util.*;
public class dp10_min_path_sum_tabu {
    public static int minPaths(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        //1.initialized a dp array of mXn size
        int[][] dp = new int[row][col];
        // Fill the table
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                // First cell initialization
                if (i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else {
                    // Calculate from top
                    int up = grid[i][j];
                    if (i > 0) up += dp[i - 1][j];
                    else up += (int)1e9;

                    // Calculate from left
                    int left = grid[i][j];
                    if (j > 0) left += dp[i][j - 1];
                    else left += (int)1e9;

                    // Take minimum
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        // Return result
        return dp[row - 1][col - 1];
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1,2,3},{4,5,6}
        };

        dp10_min_path_sum_tabu sol= new dp10_min_path_sum_tabu();
        System.out.print(sol.minPaths(grid));
    }
}
