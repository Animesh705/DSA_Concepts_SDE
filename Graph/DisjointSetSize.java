package Graph;
import java.util.*;
public class DisjointSetSize {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSetSize(int n) {
        for(int i=0;i<=n;i++){
            //initially everyone has size zero because no one is beneath them and every node is parent to itself
            size.add(0);
            parent.add(i);
        }
    }
    //findup is func for finding ultimate parents
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
    public void unionBySize(int u,int v){
        int ulp_u=findUP(u);
        int ulp_v=findUP(v);
        //agar u or v dono ka ultimate parent same toh simply return kar do because no change will be their
        if(ulp_u == ulp_v){
            return;
        }
        //if size of ultimate parent of u is less than ultimate parent of v than add u to v
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
        //if the size of ultimate parent of v is smaller than add v to u
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
    public static void main(String[] args) {
        DisjointSetSize ds = new DisjointSetSize(7);
        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);

        if(ds.findUP(3) == ds.findUP(7)){
            System.out.println("same");
        }else
            System.out.println("not same");
        ds.unionBySize(3,7);
        if(ds.findUP(3) == ds.findUP(7)) {
            System.out.println("same");
        }
        else
            System.out.println("not same");
    }
}



