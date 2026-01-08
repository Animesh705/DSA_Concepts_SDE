package Recursion_and_Backtracking;
import java.util.*;
public class word_break {
    boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        //max length of the string in wordDict
        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // base case
        for (int i = 1; i <= n; i++)
        {
            for (int j = i - 1; j >= Math.max(0, i - maxLength); j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
        //Sample Test Cases
        public static void main(String[] args) {

            word_break sol = new word_break();

            // Example 1
            String s1 = "leetcode";
            List<String> dict1 = Arrays.asList("leet", "code");
            System.out.println(sol.wordBreak(s1, dict1)); // true

            // Example 2
            String s2 = "applepenapple";
            List<String> dict2 = Arrays.asList("apple", "pen");
            System.out.println(sol.wordBreak(s2, dict2)); // true

            // Example 3
            String s3 = "catsandog";
            List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
            System.out.println(sol.wordBreak(s3, dict3)); // false
        }
    }

