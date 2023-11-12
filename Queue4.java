import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queue4 {

//    Problem 1

    public static void firstNonRepeat(String str){
        int  freq[]= new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0;i<str.length();i++){
            char ch =  str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while (!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();


            }
            if(q.isEmpty()){
                System.out.println(-1+" ");

            }else {
                System.out.println(q.peek()+" ");
            }
//            System.out.println();

        }


    }

//    problem 2
//    Interleave

    public static void interLeave(Queue<Integer> q){

        Queue<Integer> firstHalf = new LinkedList<>();

        int size = q.size();

        for(int i=1;i<=size/2;i++){
            firstHalf.add(q.remove());
        }
        while (!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
        while (!q.isEmpty()){
            System.out.print(q.remove()+ " ");

        }


    }

    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();


        while (!q.isEmpty()){
            s.push(q.remove());
        }

        while (!s.isEmpty()){
            q.add(s.pop());

        }

    }


    public static void main(String[] args) {

//
//        String str = "aabccxb";
//        firstNonRepeat(str);


        Queue<Integer>  q= new LinkedList<>();
        for(int i=1;i<=10;i++){
            q.add(i);

        }
//        interLeave(q);


        reverse(q);
        while (!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }




    }
}
