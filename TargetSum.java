public class TargetSum {
    
    
    // Target sum Question takes two days to understand due to short span of time available to programmer
    public static boolean targetSumSubset(int arr[],int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        //i = items & j=target sum
        for (int i=0;i<n+1;i++){
            dp[i][0] =  true;
        }
        for (int i=1;i<n+1;i++){
            for (int j=1;j<sum+1;j++){
                int v= arr[i-1];

                //include
                if (v<=j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                    dp[i][j] = true;

                }
            }
        }
        print(dp);
        return dp[n][sum];

    }

    
    
    
    //print target  sum equation for ARRay 
    
    public static void print(boolean dp[][]){
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                System.out.format(dp[i][j]+"   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int arr[] = {4,2,7,1,3};
        int sum = 10;
        
        
        

        System.out.println(targetSumSubset(arr,sum));
    }
}
