package String;
import java.util.*;
public class isomorphic_string {
        // Method to check if two strings are isomorphic
        public boolean isomorphicString(String s, String t) {
            // Arrays to track last seen positions of characters in s and t
            int[] m1 = new int[256], m2 = new int[256];

            // Get length of the strings
            int n = s.length();

            // Loop through all characters in the strings
            for (int i = 0; i < n; ++i) {
                // Return false if mapping is inconsistent
                if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;

                // Update last seen index for both characters
                m1[s.charAt(i)] = i + 1;
                m2[t.charAt(i)] = i + 1;
            }

            // Return true if all character mappings are consistent
            return true;
        }
        public static void main(String[] args) {
            // Create instance of Solution class
            isomorphic_string solution = new isomorphic_string();

            // Define input strings
            String s = "paper";
            String t = "title";

            // Check if strings are isomorphic
            if (solution.isomorphicString(s, t)) {
                System.out.println("Strings are isomorphic.");
            } else {
                System.out.println("Strings are not isomorphic.");
            }
        }
    }
