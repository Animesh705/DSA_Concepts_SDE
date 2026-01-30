package String;
import java.util.*;
public class LPS_Array {
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
                System.out.println(pattern.charAt(len));
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
    // MAIN FUNCTION FOR TESTING
    public static void main(String[] args) {

        LPS_Array  sol = new LPS_Array ();

        // Test pattern
        String pattern = "abacc";

        // Compute LPS array
        int[] lps = sol.computeLPS(pattern);

        // Print pattern
        System.out.println("Pattern: " + pattern);

        // Print LPS array
        System.out.print("LPS Array: ");
        for (int val : lps) {
            System.out.print(val + " ");
        }
    }
}
