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

//    day86



    public static void findsubString(String str ,String ans, int i ){

        //base case
        if (i==str.length()){
            if (ans.length()==0){
                System.out.println("null");
            }else {
                System.out.println(ans);
            }
            return;
        }


        //recursion
        findsubString(str,ans+str.charAt(i),i+1);
        findsubString(str,ans,i+1);
    }

    public static void print(int arr[]){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int arr[] =new int[5];
//        changeArr(arr,0,1);
//        print(arr);

        
        findsubString("abc" , "",0);

    }
}
