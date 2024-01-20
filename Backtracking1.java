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



    //Day87
    public static void findPermutation(String str , String ans){
        //base case
        if (str.length()==0){
            System.out.println(ans);
            return;
        }

        //recursion
        for (int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            String newStr =  str.substring(0,i)+str.substring(i+1,str.length());
            findPermutation(newStr,ans+curr);
        }
    }



//    day88

    public static int gridWays(int i,int j ,int n ,int m){

        //base case
        if (i==n-1  && j==m-1){
            return 1;
        }else if(i==n  || j==m){
            return 0;


        }
        int w1 = gridWays(i+1,j,n,m);
        int w2 = gridWays(i,j+1,n,m);
        return w2+w1;

    }
    public static void main(String[] args) {
//        int arr[] =new int[5];
//        changeArr(arr,0,1);
//        print(arr);

        
//        findsubString("abc" , "",0);



//        findPermutation("abc","");


        int n =3 , m=3;
        System.out.println(gridWays(0,0,n,m));
    }
}
