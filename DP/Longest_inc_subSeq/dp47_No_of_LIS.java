//total count of lis in an array
package DP.Longest_inc_subSeq;
import java.util.*;
public class dp47_No_of_LIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        //creating the dp array for storing LIS on the current index
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        //for storing the count of LIS on the current index
        int[] count = new int[n];
        Arrays.fill(count, 1);
        //to keep a track of max length of lis
        int maxLength = 1;
        //loop for traversing the each element in array
        for (int i = 0; i < n; i++) {
            //loop for doing the comaprision between curr and all prev element
            for (int j = 0; j < i; j++) {
                //curr is gretaer tha prev &&
                // the lis for curr < lis for prev ,(if same than we add, if less or more we ignore)
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = 1 + dp[j];
                    count[i] = count[j];
                } else if (nums[i] > nums[j] && dp[i] == dp[j] + 1) {
                    count[i] = count[i] + count[j];
                }
            }
            //after every elemnt we check keep a track of max lis
            maxLength = Math.max(maxLength, dp[i]);
        }
        int countLIS = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                countLIS += count[i];
            }
        }
        return countLIS;
    }
    public static void main(String[] args) {
        // Define the input sequence
        int[] arr = {1, 3, 5, 4, 7};

        // Create an object of Solution class
        dp47_No_of_LIS sol = new dp47_No_of_LIS();

        // Output the total count of longest increasing subsequences
        System.out.println("The count of Longest Increasing Subsequences (LIS) is "
                + sol.findNumberOfLIS(arr));
    }
}
