import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;





public class Queue3 {

//Problem 1
//    Implement Queue usinh 2 stacks


//    add->  O(n)
//    remve - > 0(1)
//    peek -> 0(1)
    static class Queue{

         static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2= new Stack<>();


        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        public static void add(int data){

            while (!s1.isEmpty()){
                s2.push(s1.pop());

            }
            s1.push(data);
            while (!s2.isEmpty()){
                s1.push(s2.pop());

            }
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;

            }
            return s1.pop();

        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;

            }
            return s1.peek();

        }
}


    public static void main(String[] args) {
//Implentation o Queue using Coollection Framworks

//        We cannot create object of queue as it was interface which wa imleetn in class of Linked list ans ArrayDeque


//        Queue<Integer> q = new LinkedList<>();
//        Queue<Integer> q = new ArrayDeque<>();
//
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        while (!q.isEmpty()){
//            System.out.println(q.peek());
//            q.remove();
//
//        }


        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isEmpty()){
            System.out.println(q.remove());
        }



    }
}
