package stack_queue;
import java.util.*;
public class Check_for_BalancedParentheses {
        // Function to check if the input string has valid parentheses
        public boolean isValid(String s) {
            Stack<Character> st = new Stack<>();  // Stack to store opening brackets

            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '{' || ch == '[')
                    st.push(ch);  // Push opening brackets to stack
                else {
                    if (st.isEmpty()) return false;  // No matching opening bracket
                    char top = st.pop();

                    // Check for matching pair
                    if ((ch == ')' && top == '(') ||
                            (ch == ']' && top == '[') ||
                            (ch == '}' && top == '{'))
                        continue;
                    else
                        return false;
                }
            }
            return st.isEmpty();  // True if all brackets matched
        }

        public static void main(String[] args) {
            Check_for_BalancedParentheses sol = new Check_for_BalancedParentheses();
            String s = "()[{}()]";

            if (sol.isValid(s))
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
