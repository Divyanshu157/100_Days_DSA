import java.util.Arrays;

public class DynamicProgramming {

    public static int fib(int n ){
        if (n==0 || n ==1){
            return  n;

        }
        return  fib(n-1)*fib(n-2);

    }


    //using memoaization
    public static int fib(int n , int dp[]){
        if (n==0 || n==1){
            return n;
        }
        if (dp[n] != 0){
            return dp[n];
        }

       dp[n]=fib(n - 1, dp) + fib(n - 2, dp);
        return  dp[n];
    }

//    ..fibonaaciiusing tabulation

    public static int fibTabulation(int n){

        int dp[] = new int[n+1];

        //initialization
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[n];
    }

    //Memoaization of code
    public static int climbStairsUsingMemo(int n , int dp[]){

        if (n<0){
            return 0;
        }
        if(n==0 || n==1 || n==2){
            return n;
        }

        if (dp[n] != -1){
            return dp[n];

        }
        dp[n] = climbStairsUsingMemo(n-1,dp)+climbStairsUsingMemo(n-2,dp);
        return dp[n];

    }


    public static int climbStairUsingTabulation(int n ){
        int dp[]  =  new int[n+1];
        int ans =0;

        //initialize
        dp[0] = 0;
        dp[1] = 1;
        dp[2] =2;

        //fill array
        for (int i=3 ;i<n+1;i++){
            dp[i] = dp[i-1] + dp[i-2];

        }
        return dp[n];
    }



    public static int climbStairs(int n ){
        if (n<-1){
            return 0;
        }
        if(n==0 || n==1 ||n==2){
            return n;
        }
        int countWays = climbStairs(n-1)+climbStairs(n-2);
        return countWays;
    }


    public static void main(String[] args) {
        int n =7;
        int dp[] = new  int[n+1];
//        System.out.println(fib(n,dp));
//        System.out.println(fibTabulation(5));
//        System.out.println(climbStairs(-1));
//        Arrays.fill(dp,-1);
//        System.out.println(climbStairsUsingMemo(n ,dp));
        System.out.println(climbStairUsingTabulation(n));





    }
}
