package DP;
import java.util.*;
public class fibonaci_using_memoization {
    // Function to calculate Fibonacci using memoization
    public int fib(int n, int[] dp) {
        // If base case return n
        if (n <= 1) return n;
        // step 3 :If already computed, return stored value
        if (dp[n] != -1) return dp[n];
        // Otherwise compute and store
        //step 2: storing the values in dp array
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        fibonaci_using_memoization sol = new fibonaci_using_memoization();
        System.out.println(sol.fib(n, dp));
    }
}

