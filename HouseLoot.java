import java.util.Arrays;

public class HouseLoot {

    public static int houseLoot(int arr[] , int n){
        if (n<0){
            return 0;
        }
        if (n==0){
            return arr[0];
        }

        int pick= arr[n] + houseLoot(arr,n-2);

        int notpick=houseLoot(arr,n-1);

        return Math.max(pick,notpick);
    }


    //house loot using tabulation
    public static void houseLoottabu(int arr[] ,int n){
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-5);

        if (n==1 || n==2){
            int money=Integer.MIN_VALUE;
            for (int i=0;i<=1;i++){
                money=Math.max(arr[i],money);
            }
            System.out.println();
            System.out.println("Maximum money "+ money);
        }

        dp[0]=arr[0];
        dp[1]=arr[1];
        for (int i=2;i<arr.length;i++){
            int money=0;
            dp[i]=arr[i];
            for (int j=i-2;j>=0;j--){
                money=Math.max(dp[j],money);

            }
            dp[i] +=money;

        }

        int max= Arrays.stream(dp).max().getAsInt();
        System.out.println("Maximum value possiblw is"+ max);

    }

    public static void main(String[] args) {

        int arr[]={6,7,1,3,8,2,4};
        System.out.println(houseLoot(arr,arr.length-1));
       houseLoottabu(arr,arr.length-1);

    }
}
