public class Dynamic1 {

    public static int countWays(int n){
        if (n==0){
            return 1;
        }
        if (n<0){
            return 0;
        }
        return  countWays(n-1)+countWays(n-2);

    }
    
    //fiboonaci



    public static int fib(int n){
        if (n==0 || n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);

    }

    //Day52

    //Differernt approch fro ClimbStairs
    public static int countWaysTab(int n){
        int dp[] = new int [n+1];
        dp[0]=1;
        for (int i=1;i<=n;i++){
            if (i==1){
                dp[i]=dp[i-1];
            }else {
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[n];

    }

    public static void main(String args[]){
        int n=5;

        System.out.println(countWays(5));

        //
        System.out.println(countWaysTab(5));


    }
}
