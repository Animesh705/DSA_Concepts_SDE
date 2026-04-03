package DP;
import java.util.Scanner;
public class fibonaci_using_tabulation {
    // Function to calculate Fibonacci using tabulation
    public int fib(int n) {
        // If n is 0 or 1, return n
        if (n <= 1) return n;
        // Create dp array
        int[] dp = new int[n + 1];
        // Initialize base cases
        dp[0] = 0;
        dp[1] = 1;
        // Fill dp array iteratively
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // Return final answer
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 10;
        fibonaci_using_tabulation sol = new fibonaci_using_tabulation();
        System.out.println(sol.fib(n));
    }
}

/* will do space optimisation in this code
public int fib(int n) {
        // If n is 0 return 0
        if(n == 0) return 0;
        // If n is 1 return 1
        if(n == 1) return 1;

        // prev2 stores fib(n-2)
        int prev2 = 0;
        // prev stores fib(n-1)
        int prev = 1;
        // curr stores current fib
        int curr = 0;

        // Loop from 2 to n
        for(int i = 2; i <= n; i++) {
            // Calculate current fib
            curr = prev + prev2;
            // Update prev2
            prev2 = prev;
            // Update prev
            prev = curr;
        }
        // Return final answer
        return prev;
    }
}
 */