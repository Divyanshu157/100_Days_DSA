import java.util.ArrayList;
import java.util.List;

class DisiontSet{

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisiontSet(int n ){
        for (int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findPar(int node){
        if (node==parent.get(node)){
            return node;
        }
        int ulp = findPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);

    }

    public void unionByRank(int u,int v){
        int ulp_u = findPar(u);
        int ulp_v=findPar(v);
        if (ulp_u==ulp_v) return;

        if (rank.get(ulp_u) < rank.get(ulp_u)){
            parent.set(ulp_u,ulp_v);

        }
        else if (rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);

        }
        else {
            parent.set(ulp_v,ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
}

public class DisjointSet1 {
    public static void main(String[] args) {
        DisiontSet ds = new DisiontSet(7);

        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);

        if (ds.findPar(3)==ds.findPar(7)) {
            System.out.println("Same");
        }
        else
        {
            System.out.println("Not same");
        }
        ds.unionByRank(3,7);
        if (ds.findPar(3)== ds.findPar(7)){
            System.out.println("Same");
        }else {
            System.out.println("nt same");
        }
    }


}
