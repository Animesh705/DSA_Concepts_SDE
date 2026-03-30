package Graph;
import java.util.*;
public class DisjointSetRank {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSetRank(int n) {
        for(int i=0;i<=n;i++){
            //initially everyone has rank zero because no one is beneath them and every node is parent to itself
            rank.add(0);
            parent.add(i);
        }
    }
    //findup is func for findiung ultimate parents
    public int findUP(int node) {
        //if current node == parent node in parent list , return the node
        if(node==parent.get(node)){
            return node;
        }
        //path compression ,
        //save the ultimate parent in ulp , so if someone ask in future we can return
        int ulp=findUP(parent.get(node));
        //updating the parent list with ultimate parent node
        parent.set(node,ulp);
        //returning the parent of the node
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ulp_u=findUP(u);
        int ulp_v=findUP(v);
        //agar u or v dono ka ultimate parent same toh simply return kar do because no change will be their
        if(ulp_u == ulp_v){
            return;
        }
        //if rank of ultimate parent of u is less than ultimate parent of v than add u to v
       if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        //if the rank of ultimate parent of v is smaller than add v to u 
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }
        else{
            //when both the rank of ultimate parent of u and v are same than anyone to anyone and
            // increase the rank by 1 in which other is added
            parent.set(ulp_v, ulp_u); // v is addded to u i.e; parent.set(jo add hoga, jisme hoga) , therefor rank of u is increased by 1
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
    public static void main(String[] args) {
        DisjointSetRank ds = new DisjointSetRank(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);

        if(ds.findUP(3) == ds.findUP(7)){
            System.out.println("same");
        }else
            System.out.println("not same");
        ds.unionByRank(3,7);
        if(ds.findUP(3) == ds.findUP(7)) {
            System.out.println("same");
        }
            else
                System.out.println("not same");
        }
    }



