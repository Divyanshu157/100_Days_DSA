import java.util.HashMap;
import java.util.Map;


public class MaximumStoneRemoval {

    int maxRemove(int stones[][] ,int n ){
        int maxRow =0;
        int maxCol =0;
        for (int i=0;i<n;i++){
            maxRow=Math.max(maxRow,stones[i][0]);
            maxCol=Math.max(maxCol,stones[i][1]);

        }
        DisiontSet ds = new DisiontSet(maxRow+maxCol+1);
        HashMap<Integer,Integer> stonesNodes = new HashMap<>();
        for (int i=0;i<n;i++){
            int nodeRow  = stones[i][0];
            int nodeCol = stones[i][1]+maxRow+1;
            ds.unionBySize(nodeRow,nodeCol);
            stonesNodes.put(nodeRow,1);
            stonesNodes.put(nodeCol,1);

        }
        int cnt =0;
        for (Map.Entry<Integer,Integer> it : stonesNodes.entrySet()){
            if (ds.findPar(it.getKey()) == it.getKey()){
                cnt++;

            }

        }
        return n-cnt;


    };




    public static void main(String[] args) {



    }
}
