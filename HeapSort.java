import java.util.PriorityQueue;

public class HeapSort {



    public static void heapify(int arr[] , int i,int size){
        int left = 2*i+1;
        int right= 2*i+2;
        int maxidx=i;

        if(left<size && arr[left]>arr[maxidx]){
            maxidx=left;
        }
        if (right<size && arr[right]>arr[maxidx]){
            maxidx=right;
        }
        if (maxidx!=i){
            int temp = arr[i];
            arr[i]=arr[maxidx];
            arr[maxidx]=temp;
            heapify(arr,maxidx,size);
        }
    }
    public static void heapSort(int arr[]){
        //step1 = build maxheap
        int n = arr.length;
        for (int i=n/2;i>=0;i--){
         heapify(arr,i,n);
        }
//        push largest at end
        for (int i=n-1;i>0;i--){
            //swap (largest first with last)
            int temp = arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr,0,i);
        }
    }

//    day 38
    static class Point implements Comparable<Point> {
    int x;
    int y;
    int distsq;
    int idx;

    public Point(int x, int y, int distsq, int idx) {
        this.x = x;
        this.y = y;
        this.distsq = distsq;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point p2) {

        return this.distsq - p2.distsq;

    }
}

    static class Soldiers implements  Comparable<Soldiers>{

            int soldier;
            int idx;
            public Soldiers(int soldier , int idx){
                this.soldier=soldier;
                this.idx=idx;

            }


            @Override
        public int compareTo(Soldiers s2) {
                if (this.soldier == s2.soldier) {
                    return this.idx - s2.idx;
                } else {
                    return this.soldier - s2.soldier;
                }
            }
}

    public static void main(String[] args) {

//        int arr[] ={1,2,4,5,3};
//        heapSort(arr);
//        for (int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }


//        -----------------------X----------------------

        /*
        day38

        int arr[][] ={{3,3}, {5,-1},{-2,4}};
        int k=2;

        PriorityQueue<Point> pq= new PriorityQueue<>();
        for (int i=0;i<arr.length;i++){
            int distSq = arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1];
            pq.add(new Point(arr[i][0], arr[i][1], distSq ,i));
        }
        //k nearset car
        for (int i=0;i<k;i++){
            System.out.println("C"+pq.remove().idx);
        }

         */

        //Minimum cost to binds ropes
/*
        int ropes[] = { 2,3,3,4,6};
        PriorityQueue<Integer> pq=  new PriorityQueue<>();
        for (int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        int cost =0;
        while (pq.size()>1){
            int min = pq.remove();;
            int min2= pq.remove();
            cost += min2+min;
            pq.add(min2+min);

        }

        System.out.println("Minimun cost is " + cost);


 */

        int  arr[][] ={{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};
        int k=2;
        PriorityQueue<Soldiers> pq = new PriorityQueue<>();

        for (int i=0;i<arr.length;i++){
            int count =0;
            for (int j=0;j<arr[0].length;j++){
                count += arr[i][j]==1 ? 1:0;

            }
            pq.add(new Soldiers(count ,i));
        }
        for (int i=0;i<k;i++) {

            System.out.println("Weakest rows are R" + pq.remove().idx);

        }
    }
}
