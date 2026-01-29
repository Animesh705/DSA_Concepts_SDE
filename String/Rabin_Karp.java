package String;
import java.util.*;
public class Rabin_Karp {
    static final int base = 31;
    static final int mod = 1000000007;

    // Check if pattern exists in text
    public static boolean contains(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        if (m > n) return false;

        long patternHash = 0;
        long textHash = 0;
        long power = 1;

        // base^(m-1)
        for (int i = 0; i < m - 1; i++) {
            power = (power * base) % mod;
        }

        // Initial hash
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * base + pattern.charAt(i)) % mod;
            textHash = (textHash * base + text.charAt(i)) % mod;
        }

        // Sliding window
        for (int i = 0; i <= n - m; i++) {

            // Hash match
            if (patternHash == textHash) {
                // Verify to avoid collision
                if (text.substring(i, i + m).equals(pattern)) {
                    return true;
                }
            }

            // Compute next hash
            if (i < n - m) {
                textHash = (textHash - text.charAt(i) * power) % mod;
                textHash = (textHash * base + text.charAt(i + m)) % mod;
                if (textHash < 0) textHash += mod;
            }
        }

        return false;
    }
    // Optimal approach using Rabin–Karp
    public int repeatedStringMatch(String a, String b) {

        StringBuilder temp = new StringBuilder();
        int count = 0;

        // Repeat until temp length >= b length
        while (temp.length() < b.length()) {
            temp.append(a);
            count++;
        }

        // Check using Rabin–Karp
        if (Rabin_Karp.contains(temp.toString(), b)) {
            return count;
        }

        // One extra repeat for overlap
        temp.append(a);
        count++;

        if (Rabin_Karp.contains(temp.toString(), b)) {
            return count;
        }

        return -1;
    }
    public static void main(String[] args) {

        Rabin_Karp sol = new Rabin_Karp();

        // Test case 1
        String a1 = "abcd";
        String b1 = "cdabcdab";
        System.out.println(sol.repeatedStringMatch(a1, b1)); // Expected: 3

        // Test case 2
        String a2 = "abc";
        String b2 = "cabcab";
        System.out.println(sol.repeatedStringMatch(a2, b2)); // Expected: 3

        // Test case 3
        String a3 = "a";
        String b3 = "aa";
        System.out.println(sol.repeatedStringMatch(a3, b3)); // Expected: 2

        // Test case 4
        String a4 = "abc";
        String b4 = "ac";
        System.out.println(sol.repeatedStringMatch(a4, b4)); // Expected: -1
    }
}

