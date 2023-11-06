
import  java.util.*;

public class Stack3 {

    public static void pushAtBottom(Stack<Integer> s,int data)
    {
        if(s.isEmpty())
        {
            s.push(data);
            return;
        }


        int top = s.pop();
        pushAtBottom(s,data);
        s.push(top);

    }

    public static String reverseString(String str)
    {
        Stack<Character> s= new Stack<>();
        int ind = 0;
        while(ind<str.length())
        {
            s.push((str.charAt(ind)));
            ind++;

        }
        StringBuilder result= new StringBuilder();
        while(!s.isEmpty())
        {
            char curr=s.pop();
            result.append(curr);
        }
        return result.toString();

    }

    public static void reverseStack(Stack<Integer> s)
    {
        if(s.isEmpty())
        {
            return;
        }
        int top=s.pop();
        reverseStack(s);
        pushAtBottom(s,top);
    }




    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

//        pushAtBottom(s,4);

//        while (!s.isEmpty())
//        {
//            System.out.println(s.pop());
//        }
//        System.out.println(reverseString("divyanshu"));
        reverseStack(s);
        while (!s.isEmpty())
        {
            System.out.println(s.pop());
        }

    }
}
