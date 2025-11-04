package Recursion_and_Backtracking;
import java.util.*;
public class rat_In_a_Maze {
    //safe function:i.x and y should be inside the boundary i.e; greater than or equal to 0 and smaller than n
                // ii.the path shouldn't be marked as 0 , because we cant visit it
                //iii.the path we will taking must not be visited before
    boolean isSafe(int x, int y, int n, int[][] maze, int[][] visited) {
        return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1 && visited[x][y] == 0);
    }
// recursion function
    void solve(int x, int y, int n, int[][] maze, int[][] visited, String path, List<String> res) {
        //base case: whenever you reach the destination
        if (x == n - 1 && y == n - 1) {
            //add that path to the result
            res.add(path);
            return;
        }
        //and mark every path you visit as visited
        visited[x][y] = 1;
// safe function for checking downward path
        if (isSafe(x + 1, y, n, maze, visited)) {
            solve(x + 1, y, n, maze, visited, path + "D", res);
        }
        // safe function for checking left path
        if (isSafe(x, y - 1, n, maze, visited)) {
            solve(x, y - 1, n, maze, visited, path + "L", res);
        }
        // safe function for checking right path
        if (isSafe(x, y + 1, n, maze, visited)) {
            solve(x, y + 1, n, maze, visited, path + "R", res);
        }
        // safe function for checking upward path
        if (isSafe(x - 1, y, n, maze, visited)) {
            solve(x - 1, y, n, maze, visited, path + "U", res);
        }
        visited[x][y] = 0;
    }

    List<String> findPath(int[][] maze, int n) {
        List<String> res = new ArrayList<>();
        //nxn matrix to mark the visited path
        int[][] visited = new int[n][n];
        //to check whether we can go the path or not,if it is 0 we cant move
        if (maze[0][0] == 1) {
            solve(0, 0, n, maze, visited, "", res);
        }
        return (res);
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        int n = maze.length;
        rat_In_a_Maze obj = new rat_In_a_Maze();
        List<String> res = obj.findPath(maze, n);

        for (String p : res) {
            System.out.println(p + " ");
        }
    }
}

