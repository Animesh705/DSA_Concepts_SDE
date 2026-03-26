package Graph;
import java.util.*;
public class NumberOfProvinces {
    private void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        // Visit all adjacent unvisited nodes
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    // Function to count number of provinces
    public int numProvinces(int[][] adj, int V) {
        // Creating adj list from adj matrix
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Convert matrix to list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // Ignore self loops
                if (adj[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        // Visited array to track visited nodes
        boolean[] visited = new boolean[V];

        // Count of provinces
        int count = 0;

        // Traverse all nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // Start DFS and increment count
                count++;
                dfs(i, adjList, visited);
            }
        }

        return count;
    }
    public static void main(String[] args) {
        // Input adjacency matrix
        int[][] adj = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };

        // Number of vertices
        int V = 3;
        NumberOfProvinces sol = new NumberOfProvinces();
        System.out.println(sol.numProvinces(adj, V));
    }
}
