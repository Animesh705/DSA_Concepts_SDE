package Recursion_and_Backtracking;
import java.util.*;
public class sudukoSolver {
    public static boolean solve(char[][] board) {
        //for traversing the board ,
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                //finding empty spaces
                if (board[i][j] == '.') {
                    //after finding the empty space ,we will check from 1-9, that what we can fill
                    for (char c = '1'; c <= '9'; c++) {
                        //we will put the value of c in safe function to check if we can put or not
                        if (isValid(board, i, j, c)) {
                            //if valid than fill the value
                            board[i][j] = c;
                            //Recursion call ka flow:
                            //	•	Pehle empty cell pe 1-9 trial ho raha hai.
                            //	•	Kisi number se recursion call kar ke next empty cell try ho raha hai.
                            //	•	Jab pura board fill ho jaata hai (`col == n` base case), toh recursion return karke solution confirm karta hai.
                            //	•	Agar kisi step pe number dalna possible nahi, toh previous cell ka number hata ke alternate number try karta hai (backtracking).
                            if (solve(board) == true) {
                                return true;
                            }
                                else {
                                board[i][j] = '.';
                            }
                            }
                        }
                        return false;
                    }
                }
            }
        return true;
        }

    public static boolean isValid(char[][] board, int row, int col, char c) {
        //for traversing
        for (int i = 0; i < 9; i++) {
            // for checking if the character we want to insert is already present in the given row
            if (board[i][col] == c) return false;
            // for checking the column
            if (board[row][i] == c) return false;
            //for checking the 3x3 matrix
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
            //if all the condition are not false it means we can put that value , so we will return true
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 9; // You can take input from user also
        char[][] matrix = new char[n][n];

        System.out.println("Enter 9x9 matrix row wise (separated by space):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.next().charAt(0); // For character input
                // If integer matrix, use: matrix[i][j] = sc.nextInt();
            }
        }
        if (solve(matrix)) {
            System.out.println("Solved sudoku:");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists");
        }
    }
}
