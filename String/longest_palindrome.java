package String;
import java.util.*;
public class longest_palindrome {
        /*
         Helper function:
         Given a center (left, right),
         yeh function palindrome ko dono taraf expand karta hai
         aur us palindrome ka start aur end index return karta hai
        */
        private int[] expandAroundCenter(String s, int left, int right) {

        /*
         Jab tak:
         - left string ke andar hai
         - right string ke andar hai
         - left aur right characters same hain
         tab tak expand karo
        */
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {

                // Left ko ek step left le jao
                left--;

                // Right ko ek step right le jao
                right++;
            }

        /*
         Loop tab rukta hai jab:
         - mismatch ho jaye
         - ya boundary cross ho jaye

         Isliye actual palindrome ek step andar hota hai
         so return:
         left + 1  → actual start
         right - 1 → actual end
        */
            return new int[]{left + 1, right - 1};
        }

        /*
         Function to find the longest palindromic substring
        */
        public String longestPalindrome(String s) {

            int n = s.length();

            // Edge case: empty string
            if (n == 0) return "";

        /*
         start aur end store karenge
         longest palindrome ka range jo ab tak mila hai
        */
            int start = 0, end = 0;

        /*
         Har index ko possible center maan ke check karenge
        */
            for (int i = 0; i < n; i++) {

            /*
             Case 1: Odd length palindrome
             Center ek hi character hota hai (i, i)
             Example: "bab", "aba"
            */
                int[] odd = expandAroundCenter(s, i, i);

            /*
             Case 2: Even length palindrome
             Center do characters ke beech hota hai (i, i+1)
             Example: "abba"
            */
                int[] even = expandAroundCenter(s, i, i + 1);

            /*
             Agar odd palindrome ki length
             current best se zyada hai
             to answer update karo
            */
                if (odd[1] - odd[0] > end - start) {
                    start = odd[0];
                    end = odd[1];
                }

            /*
             Agar even palindrome ki length
             current best se zyada hai
             to answer update karo
            */
                if (even[1] - even[0] > end - start) {
                    start = even[0];
                    end = even[1];
                }
            }

        /*
         substring(start, end+1) kyunki
         substring end index exclusive hota hai
        */
            return s.substring(start, end + 1);
        }
        public static void main(String[] args) {

            longest_palindrome sol = new longest_palindrome();

            String s = "babad";

            // Output: "bab" or "aba"
            System.out.println(sol.longestPalindrome(s));
        }
    }
