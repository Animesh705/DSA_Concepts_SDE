package DP;
import java.util.*;
public class dp7_ninja_training_memo {
    public static int maxpoints(int day,int last, int[][] points, int[][] dp) {
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return maxi;
        }
        int maxi = 0;
            if(dp[day][last]!=-1){ return dp[day][last];}
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    int point = points[day][task] + maxpoints(day - 1, task, points, dp);
                    maxi = Math.max(maxi, point);
                }
            }
            return dp[day][last]=maxi;
        }
    public static int totalpoints(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return maxpoints(n-1,3,points,dp);
    }
    public static void main(String[] args) {
        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        int n = points.length;

        dp7_ninja_training_memo sol = new dp7_ninja_training_memo();

        System.out.println(sol.totalpoints(n, points));
    }

    }
