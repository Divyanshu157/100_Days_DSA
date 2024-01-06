public class PartitionEqualSubsetSum {

    public static boolean equalPartition(int arr[],int n ,int sum){

        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;


        if (arr[n - 1] > sum)
            return equalPartition(arr, n - 1, sum);

        return equalPartition(arr, n - 1, sum)
                || equalPartition(arr, n - 1, sum - arr[n - 1]);

    }

    public static boolean findPartition(int arr[], int n)
    {
        // Calculate sum of the elements in array
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // If sum is odd, there cannot be two subsets
        // with equal sum
        if (sum % 2 != 0)
            return false;

        // Find if there is subset with sum equal to half
        // of total sum
        return equalPartition(arr, n, sum / 2);
    }

    //different approch  space optimized approch


    public static boolean findPartiion(int arr[], int n)
    {
        int sum = 0;
        int i, j;

        for (i = 0; i < n; i++)
            sum += arr[i];

        if (sum % 2 != 0)
            return false;

        boolean[] part = new boolean[sum / 2 + 1];


        for (i = 0; i <= sum / 2; i++) {
            part[i] = false;
        }


        for (i = 0; i < n; i++) {


            for (j = sum / 2; j >= arr[i]; j--) {

                if (part[j - arr[i]] == true || j == arr[i])
                    part[j] = true;
            }
        }
        return part[sum / 2];
    }



    public static void main(String[] args) {

//        int arr[] = new  int[5];
       int arr[] = {1,2,3,3,3,7};
       int n =arr.length;

        System.out.println(findPartition(arr,n));


    }
}
