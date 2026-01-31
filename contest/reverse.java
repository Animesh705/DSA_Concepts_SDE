//You are given a string s consisting of lowercase English letters and special characters.
//
//Your task is to perform these in order:
//
//Reverse the lowercase letters and place them back into the positions originally occupied by letters.
//Reverse the special characters and place them back into the positions originally occupied by special characters.
//Return the resulting string after performing the reversals.
//
//
//Example 1:
//
//Input: s = ")ebc#da@f("
//
//Output: "(fad@cb#e)"
//
package contest;
import java.util.*;
public class reverse {
    public String reverseLettersAndSpecials(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        // We will first collect letters and special characters separately.
        StringBuilder letters = new StringBuilder();
        StringBuilder specials = new StringBuilder();

        // Step 1: Separate letters and specials.
        for (char ch : arr) {
            if (ch >= 'a' && ch <= 'z') {
                letters.append(ch);  // This is a letter, save it.
            } else {
                specials.append(ch);  // This is a special character, save it.
            }
        }

        // Step 2: Reverse the letters and specials separately.
        letters.reverse();
        specials.reverse();

        // Step 3: Now we place characters back in their original types (letter or special).
        int li = 0; // Index for reversed letters.
        int si = 0; // Index for reversed specials.

        for (int i = 0; i < n; i++) {
            // If original position had a letter, place the next reversed letter here.
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = letters.charAt(li);  // Take next reversed letter.
                li++;  // Move to next letter.
            }
            // If original position had a special character, place the next reversed special here.
            else {
                arr[i] = specials.charAt(si);  // Take next reversed special.
                si++;  // Move to next special.
            }
        }

        // Step 4: Convert the modified array back to a string and return.
        return new String(arr);
    }

    public static void main(String[] args) {
        reverse sol = new reverse();
        String s = ")ebc#da@f(";
        System.out.println(sol.reverseLettersAndSpecials(s)); // Output: "(fad@cb#e)"
    }
    }
