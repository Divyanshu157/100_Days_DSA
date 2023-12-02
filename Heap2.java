import java.util.PriorityQueue;

public class Heap2 {

    static class Pair implements Comparable<Pair>{

        int idx;
        int val;

        public Pair(int idx , int val){
            this.idx=idx;
            this.val=val;

        }

        @Override

        public int compareTo(Pair p){

            //decending order Arrange

            return p.val-this.val;

        }

    }

//    Problem of Sliding Window Maximum
    public static void main(String[] args) {
        int arr[] = { 1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[] = new int[arr.length-k+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i=0;i<k;i++){
            pq.add(new Pair(i,arr[i]));
        }

        res[0] = pq.peek().val;
        for (int i=k;i<arr.length;i++){
            while (pq.size()>=0 && pq.peek().idx<=(i-k)){
                pq.remove();
            }
            pq.add(new Pair(i,arr[i]));
            res[i-k+1]= pq.peek().val;
        }
        for (int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }

    }
}
