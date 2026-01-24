package stack_queue;
import java.util.*;
public class celebrity_problem {
        // Function to find the index of the celebrity
        public int celebrity(int[][] M) {
            // Size of the given matrix
            int n = M.length;

            // Top and Down pointers for narrowing the possible celebrity
            int top = 0, down = n - 1;

            // Traverse for all the people to find potential celebrity
            while (top < down) {
                // If top knows down, top cannot be a celebrity
                if (M[top][down] == 1) {
                    top = top + 1;
                }
                // If down knows top, down cannot be a celebrity
                else if (M[down][top] == 1) {
                    down = down - 1;
                }
                // If neither knows each other, both are not the celebrity
                else {
                    top++;
                    down--;
                }
            }

            // If top exceeds down, no celebrity is found
            if (top > down) return -1;

            // Check if the person pointed by top is a celebrity
            for (int i = 0; i < n; i++) {
                if (i == top) continue; // Skip checking the person itself

                // If top knows someone or someone doesn't know top, it's not a celebrity
                if (M[top][i] == 1 || M[i][top] == 0) {
                    return -1;
                }
            }

            // Return the index of the celebrity
            return top;
        }
        public static void main(String[] args) {
            // Input matrix representing the "knows" relationship
            int[][] M = {
                    {0, 1, 1, 0},
                    {0, 0, 0, 0},
                    {1, 1, 0, 0},
                    {0, 1, 1, 0}
            };

            // Create an instance of the Solution class
            celebrity_problem sol = new celebrity_problem();

            // Call the function to find the index of the celebrity
            int ans = sol.celebrity(M);

            // Print the result
            System.out.println("The index of the celebrity is: " + ans);
        }
    }