
import java.util.Collections;
import java.util.PriorityQueue;


public class PriorityQueue1 {

    static class Student implements Comparable<Student>{
        int rank;
        String name;
        public Student(String name , int rank){
            this.name=name;
            this.rank=rank;

        }

//        @Override
//        public int compareTo(Student s2){
//            return this.rank-s2.rank;
//
//        }

        @Override
        public int compareTo(Student s2){
            return this.name.compareTo(s2.name);

        }
    }


    public static void main(String[] args) {
        /*

        PriorityQueue<Integer> pq= new PriorityQueue<>();
        pq.add(111);
        pq.add(10);
        pq.add(5);
        pq.add(11);

        while (!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }
         */


        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A" , 23));
        pq.add(new Student("B" , 3));
        pq.add(new Student("C" , 11));
        pq.add(new Student("D" , 2));

        while (!pq.isEmpty()){
            System.out.println(pq.peek().name+" -> " + pq.peek().rank);
            pq.remove();
        }


    }
}
