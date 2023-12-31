//problem
//You are given an infinite supply of coins of each of denominations
// D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W,
// in which you can make a change for value V using coins of denominations from D. Print 0,
// if a change isn't possible.
public class WaysToMakeCoinChange {


    //using recursion problem
    public static int count(int denomination[] , int n ,int sum){

//        if sum is zero  there is one way
//        exclude the coin
        if (sum==0){
            return 1;

        }
        //sum is there is no way
        if (sum<0){
            return 0;
        }

        //if there is no coin then sum is Zero
        if (n<=0){
            return 0;
        }
        //1 . exclude the coin
        //2. include the coin ->  sense the coin is included the sum will decrease at each recursion

        return count(denomination,n-1,sum) + count(denomination,n,sum-denomination[n-1]);

    }



    public static int coinChange(int denomination[] , int value){
        int n = denomination.length; //length of denomiation array
        int dp[][]  = new int[n+1][value+1];

//
//        if (n==0 || value==0){
//            return  0;
//
//        }
//
//        //initialization
//        for (int i=0;i<n+1;i++){
//            for (int j=0;j<value+1;j++){
//                if (i==0|| j==0){
//                    dp[i][j]=0;
//                }
//
//            }
//        }
        dp[0][0] = 1;
        //filling
        for (int i=1;i<n+1;i++){
            for (int j=0;j<value+1;j++){
                    dp[i][j] += dp[i - 1][j];

               if (j-denomination[i-1] >= 0) {
                   dp[i][j] += dp[i ][j - denomination[i - 1]];
               }
            }
        }
        print(dp);
        return dp[n][value];
    }

    public static int countMemo(int denomination[] , int sum,int n ){

        int dp[][] = new int[n+1][sum+1];



    }


    public static void print(int dp[][]){
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int denomination[] = {1,2,3};
        int value=4;
        System.out.println(coinChange(denomination,value));


        System.out.println(count(denomination,denomination.length,value));

    }
}
