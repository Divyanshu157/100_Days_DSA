import java.util.Arrays;
import java.util.HashSet;

public class SubString {

    public static int subString(String str1,String str2 , int n ,int m){
        int dp[][] = new int[n+1][m+1];
        int ans=0;

        for (int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){

                if (str1.charAt(i-1)==str2.charAt(j-1)){
                dp[i][j]=dp[i-1][j-1]+1;
                ans=Math.max(dp[i][j],ans);
                }else {
                    dp[i][j]=0;
                }
            }
        }
        print(dp);
        return ans;
    }
    public static void print(int dp[][]){
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int lis(int arr1[]){
        HashSet<Integer>  hash=  new HashSet<>();
        for (int i=0;i<arr1.length;i++){
            hash.add(arr1[i]);
        }
        int arr2[] = new int[hash.size()];

        int i=0;
        for (int num: hash) {
            arr2[i]=num;
            i++;

        }
        Arrays.sort(arr2);

        return lcs(arr1,arr2);
    }


    public static  int lcs( int arr1[],int arr2[]){
        int n =arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];
        for (int i=0;i<n+1;i++){
            for (int j=0;j<m+1;j++){
                if (i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        for (int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){
                if (arr1[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    int ans1= dp[i-1][j];
                    int ans2= dp[i][j-1];
                    dp[i][j] = Math.max(ans2,ans1);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
//        String str1= "abcd";
//        String str2= "abdg";
//        System.out.println(subString(str1,str2,str1.length(),str2.length()));

        int arr[] = { 50,3,10,7,40,80};
        System.out.println(lis(arr));


    }
}
