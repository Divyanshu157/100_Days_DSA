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


//    problem 1

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
// problem 2
    public static boolean isValid(String str)
    {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char ch =str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                if( (s.peek()=='(' && ch ==')')
                    ||(s.peek()=='{' && ch=='}')
                    || (s.peek()=='[' &&  ch==']') ) {
                   s.pop();
                }else {
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;

        }else{
            return false;
        }

    }
//problem 3
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

//    problem 4

    public static boolean isDuplicate(String str){
        Stack<Character>  s = new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch==')'){
                int count =0;
                while (s.peek() !='(')
                {
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;   // duplicate
                }else{
                    s.pop();
                }
            }else {
                s.push(ch);
            }
        }
        return false;
    }

//    problem 5
    public static void maxArea(int arr []){
        int maxArea  =0;
        int nsr[] =  new int[arr.length];
        int nsl[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();



//        Next Smaller right
        for(int i=arr.length-1;i>=0;i--)
        {
            while (!s.isEmpty() && arr[s.peek()]>=arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                nsr[i] = arr.length;
            }else {
                nsr[i]=s.peek();
            }
            s.push(i);
        }

//        next smaller left
        s=new Stack<>();

        for(int i=0;i< arr.length;i++)
        {
            while (!s.isEmpty() && arr[s.peek()]>=arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                nsl[i] = -1;
            }else {
                nsl[i]=s.peek();
            }
            s.push(i);
        }


        for (int i=0;i<arr.length;i++)
        {
            int height = arr[i];
            int width = nsr[i] - nsl[i] -1;
            int currArea = height * width ;
            maxArea=  Math.max(currArea,maxArea);

        }

        System.out.println(maxArea);
    }


//    Current Area : width = j-i-1 =  nsr[i] - nsl[i] - 1



    public static void main(String[] args) {

//        int arr[]= {100,80,60,70,60,85,100};
//        int span[]= new int [stocks.length];
//        stockSpan(stocks,span);
//        for(int i=0;i<stocks.length;i++)
//        {
//            System.out.println(span[i]+" ");
//        }



//        int arr[]= {100,80,60,70,60,85,100};
//        int next[]= new int [arr.length];
//        nextGreater(arr,next);
//        for(int i=0;i<arr.length;i++)
//        {
//            System.out.println(next[i]+" ");
//        }




//        String str = "((a+b))";
//        System.out.println(isDuplicate(str));

        int arr[] = {2,1,5,6,2,3};
        maxArea(arr);

    }
}
