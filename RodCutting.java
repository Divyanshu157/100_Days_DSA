
//Prblem Description
//Given a rod of length n inches and an  Array of proces that include  prices of all pieces of size
//smaller tten n .class Determine gthe maximum value obtained by cutting up the rod and selling the pieces
//
//length = 1,2,3,4,5,6,7,8
//price = 1,5,8,9,10,17,17,20
//
//rodlength = 8


public class RodCutting {

    //weight => length ; val=>price ; W =>totRod
    public static int rodCutting(int length[], int price[] ,int totrod){
        int n = price.length;
        int dp[][] = new int[n+1][totrod+1];

        for (int i=0;i<n+1;i++){
            for (int j=0;j<totrod+1;j++){
                if (i==0 || j==0)
                {
                    dp[i][j]=0;

                }
            }
        }

        for (int i=1;i<n+1;i++){
            for (int j=1;j<totrod+1;j++){
                //valid
                if (length[i-1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                }else {
                    //invalid
                    dp[i][j] = dp[i-1][j];

                }
            }
        }

        return dp[n][totrod];

    }

    public static void main(String[] args) {

        int length[]  = { 1,2,3,4,5,6,7,8};
        int price[] = { 1,5,8,9,10,17,17,20};
        int totrod= 8;
        System.out.println(rodCutting(length,price,totrod));
    }
}
