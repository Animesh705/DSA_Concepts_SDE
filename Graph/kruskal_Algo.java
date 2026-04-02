package Graph;
import  java.util.*;
//Comparable → inside class (default sorting) : object does the sorting by itself : method - compareTo()
//Comparator → outside class (custom sorting) : used when multiple sorting criteria is needed : method - compare()
//therefore for sorting either implement comparable inside the class or comparator while sorting.
class Edge implements Comparable<Edge>{
    int src, dest, weight;
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    public int compareTo(Edge compareEdge) {
        //this.weight - compareEdge.weight = +(compareWeight comes first) if - then vice versa , 0 means equal
        return this.weight - compareEdge.weight;
    }
}
public class kruskal_Algo {
    //adj[i] = [[adjNode, weight],[adjNode, weight]] ,
    // structure of adj list :adj = [
    //  [ [1,10], [2,6] ],   ← node 0
    //  [ [0,10], [3,15] ],  ← node 1
    //  [ [0,6],  [3,4] ],   ← node 2
    //  [ [1,15], [2,4] ]    ← node 3
    //]
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        //list of edges
       List<Edge> edges = new ArrayList<Edge>();
       //traversing all nodes and their neighbors
       for(int i = 0; i < V; i++){
         for(int j = 0; j < adj.get(i).size(); j++){
             int adjNode = adj.get(i).get(j).get(0);
             int wt = adj.get(i).get(j).get(1);
             int node=1;
             //list of all edges ,
             // after the traversing is complete all the edges and their weight will be stored in it (eg:0-1 (10) ,0-2 (6), 1-3 (15)
             Edge temp= new Edge(i,adjNode,wt);
             edges.add(temp);
         }
       }
       DisjointSetSize ds = new DisjointSetSize(V);
       Collections.sort(edges);
       int mstWt=0;
       //extracting the edges
       for(int i = 0; i < edges.size(); i++){
           int wt= edges.get(i).weight;
           int u= edges.get(i).src;
           int v= edges.get(i).dest;
//checking if v and u are not in same component
           if(ds.findUP(u) != ds.findUP(v)){
               mstWt += wt;
               ds.unionBySize(u,v);
           }
       }
       return mstWt;
    }
    public static void main(String[] args) {

        int V = 4;

        // Adjacency list: [node -> [adjNode, weight]]
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph (add both directions)

        // 0 - 1 (10)
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 10)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 10)));

        // 0 - 2 (6)
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 6)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(0, 6)));

        // 0 - 3 (5)
        adj.get(0).add(new ArrayList<>(Arrays.asList(3, 5)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(0, 5)));

        // 1 - 3 (15)
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 15)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(1, 15)));

        // 2 - 3 (4)
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 4)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(2, 4)));

        int mstWeight = spanningTree(V, adj);

        System.out.println("MST Weight: " + mstWeight);
    }
}
