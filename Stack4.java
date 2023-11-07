import java.util.Stack;

public class Stack4 {
//    public static void stockSpan(int stocks[],int span[])
//    {
//        Stack<Integer> s= new Stack<>();
//        span[0]=1;
//        s.push(0);
//        for(int i=0;i<stocks.length;i++)
//        {
//            int currPrice = stocks[i];
//            while (!s.isEmpty() && currPrice>stocks[s.peek()])
//            {
//                s.pop();
//            }
//            if(s.isEmpty()){
//                span[i]=i+1;
//            }
//            else {
//                int prevHigh= s.peek();
//                span[i]=i-prevHigh;
//            }
//            s.push(i);
//        }
//    }

    public static void stockSpan(int stocks[],int span[])
    {
        Stack<Integer>  s = new Stack<>();
        span[0]=1;
        s.push(0);
        for (int i=1;i<stocks.length;i++)
        {
            int currPrice = stocks[i];



//!s.isEmpty() && currPrice>stocks[s.peek()]   -> user this condtion if you do not want to count last high itself;

            while (!s.isEmpty() && currPrice>=stocks[s.peek()]){
                s.pop();

            }
            if(s.isEmpty())
            {
                span[i]= i+1;

            }else{
                int preHigh= s.peek();
                span[i]=i-preHigh;

            }
            s.push(i);
        }
    }

    public static void nextGreater(int arr[] , int next[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                next[i] = -1;

            } else {
                next[i] = s.peek();
            }
            s.push(arr[i]);
        }
    }






    public static void main(String[] args) {

//        int arr[]= {100,80,60,70,60,85,100};
//        int span[]= new int [stocks.length];
//        stockSpan(stocks,span);
//        for(int i=0;i<stocks.length;i++)
//        {
//            System.out.println(span[i]+" ");
//        }
        int arr[]= {100,80,60,70,60,85,100};
        int next[]= new int [arr.length];
        nextGreater(arr,next);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(next[i]+" ");
        }

    }


}
