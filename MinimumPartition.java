import java.util.Arrays;

public class MinimumPartition {

    //Day 59
    public static int partition(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }


        int W = sum / 2;
        int dp[][] = new int[n + 1][W + 1];
        //botttom-up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (arr[i - 1] <= j) {//valid
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);

                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1= dp[n][W];
        int sum2 = sum-sum1;
        return Math.abs(sum1-sum2);

    }


    public static int minJumps(int nums[]){
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        dp[n-1]=0;
        for (int i =n-2;i>=0;i--){
            int steps = nums[i];
            int ans = Integer.MAX_VALUE;
            for (int j=i+1;j<=i+steps && j<n;j++){
                if (dp[j] != -1){
                    ans= Math.min(ans,dp[j]+1);

                }

            }
            if (ans != Integer.MAX_VALUE){
                dp[i]=ans;
            }
        }
        //dp[i] -> i to n-1
        return  dp[0];
    }

        public static void main (String[]args){

//        int nums[] ={1,11,11,15};
//            System.out.println(partition(nums));


            int nums[] ={2,3,1,1,4};
            System.out.print(minJumps(nums));


        }

}

