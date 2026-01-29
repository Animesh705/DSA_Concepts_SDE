package String;
import java.util.*;
public class Z_Function {
        // Function to compute Z-array for a given string
        public int[] computeZArray(String s) {
            int n = s.length();
            int[] z = new int[n];
            int left = 0, right = 0;

            // Traverse the string to fill the Z-array
            for (int i = 1; i < n; i++) {
                if (i <= right)
                    z[i] = Math.min(right - i + 1, z[i - left]);

                // Expand the Z-box by matching characters
                while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i]))
                    z[i]++;

                // Update the window if we expanded beyond right
                if (i + z[i] - 1 > right) {
                    left = i;
                    right = i + z[i] - 1;
                }
            }

            return z;
        }

        // Function to find all pattern occurrences in text using Z-function
        public List<Integer> zFunctionSearch(String text, String pattern) {
            String combined = pattern + "$" + text;
            int[] z = computeZArray(combined);
            List<Integer> result = new ArrayList<>();

            for (int i = pattern.length() + 1; i < combined.length(); i++) {
                if (z[i] == pattern.length()) {
                    // Match found, calculate original index in text
                    result.add(i - pattern.length() - 1);
                }
            }

            return result;
        }
        public static void main(String[] args) {
            String text = "ababcababc";
            String pattern = "ab";

            Z_Function sol = new Z_Function();
            List<Integer> indices = sol.zFunctionSearch(text, pattern);

            System.out.print("Pattern found at indices: ");
            for (int idx : indices) {
                System.out.print(idx + " ");
            }
            System.out.println();
        }
    }
