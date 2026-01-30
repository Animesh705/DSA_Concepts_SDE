package String;
import java.util.*;
public class Valid_Anagram {
        public boolean anagramStrings(String s, String t) {
            // Edge Cases
            if (s.length() != t.length()) return false;

            // To store the count of each character
            int[] count = new int[26];

            // Count occurrence of each character in first string
            for (char c : s.toCharArray()) count[c - 'a']++;

            // Decrement the count for each character in the second string
            for (char c : t.toCharArray()) count[c - 'a']--;

            // Check for count of every character
            for (int i : count) {
                // If the count is not zero
                if (i != 0) return false; // Return false
            }

            // Otherwise strings are anagram
            return true;
        }
        public static void main(String[] args) {
            String str1 = "integer";
            String str2 = "tegerni";

            // Creating an instance of Solution class
            Valid_Anagram sol = new Valid_Anagram ();

        /* Function call to find out
        whether two strings are anagram */
            boolean result = sol.anagramStrings(str1, str2);

            // Output
            if (result) System.out.println("The given strings are anagrams.");
            else System.out.println("The given strings are not anagrams.");
        }
        }
