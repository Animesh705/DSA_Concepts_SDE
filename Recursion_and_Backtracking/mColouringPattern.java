package Recursion_and_Backtracking;
import java.util.*;
public class mColouringPattern {
    public static boolean graphColouring(List<Integer>[] G, int[] colour, int i, int m){
        int n= G.length;
        if(solve(n,G,colour,n,m)== true) return true;
        return false;
    }
    private static boolean isPossible(int node, List<Integer>[] G, int[] colour,int n, int col) {
        // we are just traversing all the adjacent node
        for(int it: G[node]){
            //and if the colour of adjacent node is equivalent to the colour i am trying to return false
            if(colour[it] == col) return false;
        }
        return true;
    }
    // recursion call, we give the rec. all the parameter req.
    private static boolean solve(int node, List<Integer>[] G, int[] colour, int n, int m) {
        //base case, whenever we will colour all the nodes
        if(node == n) return true;
        //we need to try to colour with all the possible colour , so will run a loop for all the m colour
        for(int i=1;i<=m;i++){
            //check whether it is possible to colour or not
            if(isPossible(node,G,colour,n,i)){
                //if yes, we will colour it
                colour[node] = i;
                // we will again call the recursive function, and if it returns the true , we will the true
                if(solve(node+1,G,colour,n,m) == true) return true;
                //or else if it return false, we will backtrack
                colour[node] = 0;
            }
        }
        //and if we tried all the possible colour , still unable to colour , we will return false
        return false;
    }
    public static void main(String[] args) {
        int N = 4, M = 3;
        List < Integer > [] G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList < > ();
        }
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);
        int[] color = new int[N];
        boolean ans = graphColouring(G, color, 0, M);
        if (ans == true)
            System.out.println("1");
        else
            System.out.println("0");
    }
}

