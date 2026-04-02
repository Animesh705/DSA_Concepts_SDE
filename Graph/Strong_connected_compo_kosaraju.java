package Graph;
import java.util.*;
public class Strong_connected_compo_kosaraju {
    //dfs for ori. graph ,traversing and storing all the node in stack(lifo) acc. to the finishing time(finish first, means comes at last)
    private void dfs(int node, int[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node] = 1; // marking first node as visited
        //traversing all the adjacent node of the first node
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, vis, adj, st); // calling dfs for all the neighbors node
            }
        }
        st.push(node);//whenever dfs is over store in the stack(jaise 7 ka khatam hua, return back hua toh ussi time add it in stack)
    }
    //doing normal dfs for the reversed graph
    private void dfs3(int node, int[] vis,ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;
        for (Integer it : adjT.get(node)) {
            if (vis[it] == 0) {
                dfs3(it, vis, adjT);
            }
        }
    }
    public int kosaraju(ArrayList<ArrayList<Integer>> adj, int v){
        //visited array of total vertex size
        int[] vis = new int[v];
        //stack to store all the node according to the finishing time
        Stack < Integer > st = new Stack < > ();
        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                dfs(i, vis, adj, st);// calling dfs for the all the node , doing this to cover all the connected components
            }
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < v; i++){
            adjT.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < v; i++){
            vis[i] = 0;
            for(Integer it : adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        int scc=0;
        while(!st.isEmpty()){
            int node=st.peek();
            st.pop();
            if(vis[node] == 0){
                scc++;
                dfs3(node, vis, adjT);
            }
        }
        return scc;
    }
    public static void main(String[] args) {

        int V = 5;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Directed graph edges

        // 0 → 2
        adj.get(0).add(2);

        // 2 → 1
        adj.get(2).add(1);

        // 1 → 0  (cycle: 0-2-1)
        adj.get(1).add(0);

        // 0 → 3
        adj.get(0).add(3);

        // 3 → 4
        adj.get(3).add(4);

        // Create object
        Strong_connected_compo_kosaraju obj = new Strong_connected_compo_kosaraju();

        int result = obj.kosaraju(adj, V);

        System.out.println("Number of Strongly Connected Components: " + result);
    }
}
