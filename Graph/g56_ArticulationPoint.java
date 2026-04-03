//pre-requsite - g55_bridge_critical_connection
//given zero based indexing graph (v:no of edges and adj : adjacency list) , find all the articulating point nodes.
package Graph;
import java.util.*;
public class g56_ArticulationPoint {
    private int timer=0; //for storing the visit order(dfs) of every node
    private void dfs(int node, int parent, int[] vis, int[] time, int[] low, int[] mark, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1; // marked the node as visited
        time[node] = low[node] = timer; // time and low will be initially equal to the visit order
        timer++; // uodate the timer
        int child =0; // for the stating we need to check whether it has single or multiple child
        for(Integer it:adj.get(node)){ // traversing all the adjacent nodes
            if(it==parent){ continue; } //if the adjacent node is parent ignore it , dont go back to it
            if(vis[it]==0){  // if not visited call dfs for it
                dfs(it, node, vis, time, low, mark, adj); // calling dfs
                low[node] =  Math.min(low[node], low[it]);//if the adj. node(apart form parent and vis) has low less than current update
                if(low[it] >= time[node] && parent != -1){ //condition for checking the articulating point
                    mark[node] =1;// marking the node, so that we dont conisder them again
                }
                child++;// counting child for all node
            }
            else{
                low[node] = Math.min(low[node], time[it]); // if visited, just update the LOW with the TIME not low of the adj node
            }
        }
        if(child > 1 && parent == -1){ // if a node has multiple child and it is starting node(parent == -1)
            mark[node] =1; //mark it also as articulatiing node
        }
    }
    //creating the main function for finding the articulation point
    public ArrayList<Integer> articulationPoints(int n,ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[n];
        int[] time = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n]; // for marking the articulation point, so that we dont count or add it to ans more than once
        for(int i=0;i<n;i++){ //for making sure dfs is called for every nodes
            if(vis[i]==0){
                dfs(i,-1,vis,time,low,mark,adj); // if not visited call dfs function
            }
        }
        ArrayList<Integer> ans=new ArrayList<>(); // arraylist for storing the ans
        for(int i=0;i<n;i++){
            if(mark[i]==1){ // store all the node in ans, list marked as 1
                ans.add(i);
            }
        }
        if(ans.size()==0){
            ans.add(-1);
        }
        return ans;
    }
    public static void main(String[] args) {

        int n = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph

        // 0 - 1
        adj.get(0).add(1);
        adj.get(1).add(0);

        // 1 - 2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // 2 - 0 (cycle)
        adj.get(2).add(0);
        adj.get(0).add(2);

        // 1 - 3 (bridge)
        adj.get(1).add(3);
        adj.get(3).add(1);

        // 3 - 4 (bridge)
        adj.get(3).add(4);
        adj.get(4).add(3);

        g56_ArticulationPoint obj = new g56_ArticulationPoint();

        ArrayList<Integer> result = obj.articulationPoints(n, adj);

        System.out.println("Articulation Points:");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
