import java.util.Arrays;

public class MatrixChainMultiplication {

    //Day58

    public static int matrixChainMultiplication(int arr[] , int i ,int j){
        if (i==j){
            return 0;
        }
        int minCost =  Integer.MAX_VALUE;
        for (int k=i;k<=j-1;k++){
            int cost1 = matrixChainMultiplication(arr,i,k);   // Ai......Ak  = A[i-1] *A[k]
            int cost2 = matrixChainMultiplication(arr,k+1,j); //A(k+1) .....Aj= A[k]*A[j]
            int cost3 = arr[i-1] * arr[k] *arr[j];
            int finalCost = cost1+cost2+cost3;
            minCost= Math.min(minCost,finalCost);

        }
        return  minCost;
    }

    public static int mcmUsingMemoization(int arr[],int i,int j,int dp[][]){
        if (i==j){
            return 0;
        }
        if (dp[i][j] !=-1){
            return dp[i][j];

        }
        int mincost = Integer.MAX_VALUE;

        for (int k=i;k<=j-1;k++){

            int cost1 = mcmUsingMemoization(arr,i,k,dp);
            int cost2 = mcmUsingMemoization(arr,k+1,j,dp);
            int cost3 = arr[i-1] *arr[k] *arr[j];

            int finalcost = cost1+cost2+cost3;
            mincost=Math.min(mincost,finalcost);
        }
          return  dp[i][j] =mincost;
    }

    public static int mcmTab(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        //initialization
        for (int i=0;i<n;i++){
            dp[i][i]=0;

        }

        //botton up
        for (int len=2;len<=n-1;len++){
            for (int i=1;i<=n-len;i++){
                int j = i+len-1;
                dp[i][j]= Integer.MAX_VALUE;
                for (int k=i;k<=j-1;k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] *arr[k]*arr[j];
                    dp[i][j] =  Math.min(dp[i][j],cost1+cost2+cost3);

                }
            }
        }
        print(dp);
        return dp[1][n-1];
    }
    public static void print(int dp[][]){
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp.length;j++){
                System.out.format("%3d",dp[i][j]);

            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,3};
        int n = arr.length;

//        System.out.println(matrixChainMultiplication(arr,1,arr.length-1));
//        int dp[][] = new int[n][n];
//        for (int i=0;i<n;i++){
//            Arrays.fill(dp[i],-1);
//        }
//        System.out.println(mcmUsingMemoization(arr,1,n-1,dp));
//
//        for (int i=0;i<n;i++){
//            for (int j=0;j<n;j++){
//                System.out.print(dp[i][j]+ " ");
//            }
//            System.out.println();
//        }

        System.out.println( mcmTab(arr));

    }
}
