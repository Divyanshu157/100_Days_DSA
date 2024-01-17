public class Backtracking1 {

    public static void changeArr(int arr[] , int i ,int val){

        //base

        if (i==arr.length){
            print(arr);
            return;
        }
        //recursion
        arr[i]=val;

        changeArr(arr,i+1,val+1);

        arr[i]= arr[i]-2;      // backtracting   ->this step is executed after the functon return


    }

    public static void print(int arr[]){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] =new int[5];
        changeArr(arr,0,1);
        print(arr);

    }
}
