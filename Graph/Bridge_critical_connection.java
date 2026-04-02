package Graph;
import java.util.*;
public class Bridge_critical_connection {
    private int timer =0;
    private void dfs(int node,int parent,int[] vis,ArrayList<ArrayList<Integer>> adj, int[] time,int[] low,List<List<Integer>> bridge){
        vis[node] =1; // as usual marked the node as visited which is passed to the func.
        time[node]= low[node] = timer; //the time and low will be equal to the timer , timer = visit order of dfs
        timer++;
        for(Integer it : adj.get(node)){ //check every neighbors
            if(it == parent) continue; // dont go back to parents in case of cycle
            if(vis[it] == 0){
                dfs(it,node,vis,adj,time,low,bridge); // not visited call dfs
                low[node] = Math.min(low[node],low[it]); // agar kisi adjacent node except parents ka time kaam hai toh update
                if(low[it] > time[node]){ //condition for bridege
                    bridge.add(Arrays.asList(it,node)); // if low(lowest it can go) is greater than time(visit order), toh its obv. ki isko visit karta hua jaay ga
                }
            }
            else{
                low[node] = Math.min(low[node],low[it]);// if already visited, mtlab while going back also we can update the low
                //but not checking for bridge, because updarting low means we found another path , and for brideg no other path should exist
            }
        }
    }
    //given no.of edges:n , and all the edges:connections [we need to form the graph by ourselves]
    public List<List<Integer>> critical_connections(int n,ArrayList<ArrayList<Integer>> connections){
        ArrayList<ArrayList<Integer>> adj= new  ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(List<Integer> it : connections){
            //accessing the values from given edges as connections
            int u=it.get(0);
            int v=it.get(1);
            //creating a edge -> between them
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int [] vis =new int[n];
        int [] time =new int[n];
        int [] low= new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1,vis,adj,time,low,bridges);
        return bridges;
    }
    public static void main(String[] args) {

        int n = 6;

        ArrayList<ArrayList<Integer>> connections = new ArrayList<>();

        connections.add(new ArrayList<>(Arrays.asList(0, 1)));
        connections.add(new ArrayList<>(Arrays.asList(1, 2)));
        connections.add(new ArrayList<>(Arrays.asList(2, 0))); // cycle

        connections.add(new ArrayList<>(Arrays.asList(1, 3))); // bridge
        connections.add(new ArrayList<>(Arrays.asList(3, 4))); // bridge
        connections.add(new ArrayList<>(Arrays.asList(4, 5))); // bridge

        Bridge_critical_connection obj = new Bridge_critical_connection();

        List<List<Integer>> bridges = obj.critical_connections(n, connections);

        System.out.println("Bridges are:");
        for (List<Integer> b : bridges) {
            System.out.println(b.get(0) + " - " + b.get(1));
        }
    }
}
