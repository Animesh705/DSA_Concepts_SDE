package DP;
import java.util.*;
public class dp8_grid_uniq_path_tabu {
        public static int totalPaths(int row, int col) {
            //1.initialized a dp array of mXn size
            int[][] dp = new int[row][col];
            //express all the base case
            dp[0][0] = 1;
            //now express all other states other tha base case
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int up=0; int left=0;
                    if (i == 0 && j == 0) continue;
                    //used these if condition to prevent from going outside the matrix
                    if (i > 0) {
                        up = dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    //store the answer in dp
                    dp[i][j] = (up + left);
                }
            }
            //return the final case
            return dp[row - 1][col - 1];
        }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();

            dp8_grid_uniq_path_tabu obj = new dp8_grid_uniq_path_tabu();
            int ans = obj.totalPaths(n, m);
            System.out.println(ans);
        }
}
