package String;
import java.util.*;
public class ReverseWords {
            // Function to reverse the order of words
            public String reverseWords(String s) {

        /*
         StringBuilder to store final answer
         Example output: "skills coding amazing"
        */
                StringBuilder result = new StringBuilder();

                // Pointer i starts from the LAST character of string
                int i = s.length() - 1;

                // Traverse the string from right to left
                while (i >= 0) {

            /*
             STEP 1: Skip extra spaces
             Agar trailing spaces ya multiple spaces hain,
             to unhe ignore kar dete hain
            */
                    while (i >= 0 && s.charAt(i) == ' ') {
                        i--;
                    }

                    // Agar pura string hi spaces tha
                    if (i < 0) break;

            /*
             STEP 2: Mark the END of the current word
             Example: "skills"
                      ^ end
            */
                    int end = i;

            /*
             STEP 3: Move left until space mil jaaye
             Isse word ka START mil jaata hai
            */
                    while (i >= 0 && s.charAt(i) != ' ') {
                        i--;
                    }

            /*
             STEP 4: Extract the word using substring
             substring(start, end+1)
            */
                    String word = s.substring(i + 1, end + 1);

            /*
             STEP 5: Agar result empty nahi hai,
             to pehle ek space add karo
             (taaki words ke beech sirf ek space aaye)
            */
                    if (result.length() > 0) {
                        result.append(" ");
                    }

                    // STEP 6: Append the current word
                    result.append(word);
                }

                // Convert StringBuilder to String and return
                return result.toString();
            }
        public static void main(String[] args) {

            ReverseWords obj = new ReverseWords();

            // Input string (notice leading and trailing spaces)
            String s = " amazing coding skills ";

            // Output: "skills coding amazing"
            System.out.println(obj.reverseWords(s));
        }
    }