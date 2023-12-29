public class TargetSum2 {

    public static boolean targetSum(int val[] ,int target){
        int n = val.length;
        boolean dp[][] = new boolean[n+1][target+1];

        //initialize
        for (int i=0;i<n+1;i++){
            dp[i][0] =true;
        }
//        for (int i=0;i<dp[0].length;i++){
//            dp[0][i]=false;
//        }

        for (int i =1;i<n+1;i++){
            for (int j=1;j<target+1;j++){

                int v = val[i-1];
                if (v<=j && dp[i-1][j-v] == true){
                    dp[i][j] =true;
                }else if (dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
        print(dp);
        return dp[n][target];

    }

    public static void print(boolean dp[][]){
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                System.out.format(dp[i][j]+" ");

            }
            System.out.println();

        }
        System.out.println();
    }



    public static int knapscakTabulation(int val[] , int wt[] ,int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        //initialization
        for (int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for (int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        //fill small to large
        for (int i=1;i<n+1;i++){
            for (int j=1;j<W+1;j++){
                //valid
                int v= val[i-1];
                int w = wt[i-1];
                if (w<=j){
                    int incProfit = v + dp[i][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit,excProfit);
                }else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        print(dp);
        return dp[n][W];
    }
    public static void  print(int dp[][]){
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                System.out.format("%3d",dp[i][j]);

            }
            System.out.println();
        }
        System.out.println();
    }



    //rodCutting problem
    public static int rodCutting(int price[] ,int length[] , int rodlen){
        int n = price.length;
        int dp[][] = new int[n+1][rodlen+1];

        //initialization
        for (int i=0;i<n+1;i++){
            dp[i][0]=0;

        }
        for (int i=0;i<rodlen+1;i++){
            dp[0][i]=0;
        }

        for (int i=1;i<n+1;i++){
            for (int j=1;j<rodlen+1;j++){
                int l = length[i-1];
                int p=price[i-1];
                if (l<=j){
                    dp[i][j] = Math.max(p+dp[i-1][j-l],dp[i-1][j]);

                }else {
                    dp[i][j] = dp[i-1][j];

                }
            }
        }
        print(dp);
        return dp[n][rodlen];


    }

    public static int longestCommonSubSequence(String str1 , String str2,int n ,int m){

        if (n==0 || m==0){
            return 0;
        }

        int count =0;
        if (str1.charAt(n-1) == str2.charAt(m-1)){
            return longestCommonSubSequence(str1,str2,n-1,m-1)+1;

        }else {

            int ans1  = longestCommonSubSequence(str1,str2,n-1,m);
            int ans2 = longestCommonSubSequence(str1,str2,n,m-1);
            return Math.max(ans2,ans1);

        }
    }

    public static void main(String[] args) {

//        int arr[] = {4,2,7,1,3};
//        int sum = 10;
//        System.out.println(targetSum(arr,sum));
//        int val[] = {15,14,10,45,30};
//        int items[] = {2,5,1,3,4};
//        int W =7;
//        System.out.println(knapscakTabulation(val,items,W));

//        int length[] = {1,2,3,4,5,6,7,8};
//        int price[] = {1,5,8,9,10,17,17,20};
//        int rodLenght=8;
//        System.out.println(rodCutting(price,length,rodLenght));

        String str1 = "abcgd";
        String str2 =  "abgd";
        System.out.println(longestCommonSubSequence(str1,str2,str1.length(),str2.length()));


    }
}
