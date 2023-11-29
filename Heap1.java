import java.util.ArrayList;


public class Heap1 {

//    Day36


//    Heap is not implemented as class  bcoz it add complexity is O(n) + fixing of elemetn at its proper place
//    but it visualize as Binary Tree
//    Heap is Implemented as Array and ArrayList
//    LeftchildIdx  = 2*i+1
//    rightchildIdx = 2*i+2


//    we can convert min heap to max ust by changing the three sign of greateer  to smaller than



    static class Heap {
//        min heap
        ArrayList<Integer> arr = new ArrayList<>();

        //       add element in heap
        public void add(int data) {
//           add at last idx
            arr.add(data);

            int x = arr.size() - 1;  //x is child index
            int par = (x - 1) / 2;     // parent index

            while (arr.get(x) < arr.get(par)) {  // O(logn)
//               swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        //       peek element in heap
        public int peek() { //O(1)
            return arr.get(0);
        }

        //       remove element from heap
        public int remove() {  //O(logn)
            int data = arr.get(arr.size() - 1);

//           swap 1 and last element
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

//            step 2 delete last
            arr.remove(arr.size() - 1);
//            step 3 -> heapifiy
            heapify(0);
            return data;

        }

//        fix element in heap in proper  order
//        wrost  case O(logn)
        private void heapify(int i) {
            int minIdx = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx=left;

            }

            if (right<arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx=right;
            }
            if (minIdx != i){
                int temp =arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);

                heapify(minIdx);
            }

        }

//        Is Heap is Empty


        public boolean isEmpty(){
            return arr.size()==0;
        }


//        -------------------------------------X----------
//        max Heap

    }

    public static void main(String[] args) {

        Heap p = new Heap();
        p.add(3);
        p.add(4);
        p.add(1);
        p.add(5);

        while (!p.isEmpty()){  //heap sort --O(nlogn)
            System.out.println(p.peek());
            p.remove();

        }
    }
}
