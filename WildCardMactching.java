import java.util.Arrays;

public class WildCardMactching {

    public static int catlan(int n ){
        if (n==0 || n==1){
            return 1;
        }
        int ans= 0;
        for (int i=0;i<=n-1;i++){
            ans +=catlan(i)*catlan(n-i-1);
        }
        return ans;
    }

    public static boolean isMatch(String s , String p){
        int n= s.length();
        int m =  p.length();

        boolean dp[][] = new  boolean[n+1][m+1];

        //initialize
        dp[0][0]=true;

        //pattern=" "
        for (int i=1;i<n+1;i++){
            dp[i][0] = false;
        }
        //s=' '
        for (int j=1;j<m+1;j++){
            {
                if (p.charAt(j-1)=='*'){
                    dp[0][j] = dp[0][j-1];
                }
            }
        }
        //bottom-up
        for (int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){
                //case -> ith char ==jth chr ||jth char==?
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1) =='?'){
                    dp[i][j]= dp[i-1][j-1];

                }else if (p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];

                }else {
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];

    }

    public static int catalanMen(int n ,int dp[]){
        if (n==0 || n==1){
            return 1;
        }

        if (dp[n] != -1){
            return  dp[n];
        }
        int ans =0;
        for (int i=0;i<n;i++){
            ans += catalanMen(i,dp) * catalanMen(n-i-1,dp);
        }
        return dp[n] = ans;
    }

    public static void main(String[] args) {
//        String s ="baaabab";
//        String p ="*****ba*****ab";
//        System.out.println(isMatch(s,p));

        int n = 10;
        int dp[]  = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(catalanMen(10,dp));
        System.out.println(catlan(10));
    }
}
