
package DP;
import java.util.*;
public class dp12_min_falling_path_sum_tabu {
    public static int minFallingPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        //declared dp array
        int[][] dp = new int[row][col];
        // Fill the table
        int r = 0; int c = 0;
        for (r = 0; r < row; r++) {
            for (c = 0; c < col; c++) {
                //declaring all the base case in dp 1.if(c<0 || c>=m) return (int)1e9; , 2.if(r==0) return grid[0][c];
                if (r == 0) {
                    dp[0][c] = grid[0][c];
                } else {
                    //now exploring all the path using for loop and r&c
                    int straight = grid[r][c] + dp[r - 1][c];
                    //if(r>0){ straight+=; } else straight+= (int)1e9;
                    int leftDiagonal = grid[r][c];
                    if (c-1 >= 0) {
                        leftDiagonal += dp[r - 1][c - 1];
                    } else {
                        leftDiagonal += (int) 1e9;
                    }
                    int rightDiagonal = grid[r][c];
                    if (c+1 < col) {
                        rightDiagonal += dp[r - 1][c + 1];
                    } else {
                        rightDiagonal += (int) 1e9;
                    }
                    dp[r][c] = Math.min(straight, Math.min(leftDiagonal, rightDiagonal));
                }
            }
        }
        //for covering all the destination of the last row
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < col; i++) {
            mini = Math.min(mini, dp[row - 1][i]);
        }
        return mini;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 4 ,1}, {2, 3, -1, -1}, {1, 1, -1, 8}
        };

        dp12_min_falling_path_sum_tabu sol= new dp12_min_falling_path_sum_tabu();
        System.out.print(sol.minFallingPathSum(grid));
    }
}
