package String;
import java.util.*;
public class KMP_Algo {
        // Function to compute the LPS (Longest Prefix which is also Suffix) array
        public int[] computeLPS(String pattern) {

            // Create LPS array
            int[] lps = new int[pattern.length()];

            // Length of the previous longest prefix suffix
            int len = 0;

            // Start from index 1 (as lps[0] is always 0)
            int i = 1;

            // Loop to fill lps[i] for i = 1 to pattern.length() - 1
            while (i < pattern.length()) {

                // If current character matches with the character at current length
                if (pattern.charAt(i) == pattern.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                } else {

                    // If mismatch occurs after at least one match
                    if (len != 0) {
                        len = lps[len - 1];
                    } else {

                        // No prefix match, set lps[i] to 0
                        lps[i] = 0;
                        i++;
                    }
                }
            }

            // Return the final LPS array
            return lps;
        }

        // Function to perform KMP pattern searching
        public List<Integer> KMP(String text, String pattern) {

            // Preprocess the pattern to get LPS array
            int[] lps = computeLPS(pattern);

            // Result list to store indices where pattern is found
            List<Integer> result = new ArrayList<>();

            // Indices for text and pattern
            int i = 0, j = 0;

            // Traverse the entire text
            while (i < text.length()) {

                // If characters match, increment both pointers
                if (text.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                }

                // If full pattern matched
                if (j == pattern.length()) {
                    result.add(i - j);
                    j = lps[j - 1];
                }

                // If mismatch occurs after some matches
                else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {

                    // Use LPS to skip unnecessary comparisons
                    if (j != 0) {
                        j = lps[j - 1];
                    } else {
                        i++;
                    }
                }
            }

            // Return the list of matching indices
            return result;
        }
        public static void main(String[] args) {

            // Create object of Solution class
            KMP_Algo sol = new KMP_Algo();

            // Define text and pattern
            String text = "ababcababcabc";
            String pattern = "abc";

            // Call the KMP function
            List<Integer> matches = sol.KMP(text, pattern);

            // Print the result
            System.out.println("Pattern found at indices: " + matches);
        }
    }
