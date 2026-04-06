package DP;
import java.util.*;
public class dp7_ninja_training_tabu {
    public static int totalpoints(int n, int[][] points) {
        int[][] dp = new int[n][4];
//base case : for day 0, we dont have last day task, so this will break the formula(point = points[day][task] + dp[day - 1][task])
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        //from day 1 to n-1
        for (int day = 1; day < n ; day++) {
            //run,swim,fight,no task performed
            for (int last = 0; last < 4; last++) {
                //choose the best for this case, so assigned to zero
                dp[day][last] = 0;
                //run,swim,fight
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        //If today you choose task = X,
                        //then yesterday's "last" must be X
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
    public static void main(String[] args) {
        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        int n = points.length;

        dp7_ninja_training_tabu sol = new dp7_ninja_training_tabu();

        System.out.println(sol.totalpoints(n, points));
    }

}
