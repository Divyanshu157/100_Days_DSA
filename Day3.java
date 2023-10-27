
import java.util.*;
import java.util.ArrayList;



public class Day3 {

    public static boolean isMonotonic(ArrayList<Integer> list)
    {
        boolean increasing =true;
        boolean decreasing =true;

        for(int i=1;i<list.size();i++)
        {
            if(list.get(i)<list.get(i-1))
            {
                increasing=false;

            }
            if(list.get(i)>list.get(i-1))
            {
                decreasing=false;

            }

        }
        return increasing || decreasing;

    }

//    Container with most water    1 ->Approch
    public static int  storeWater(ArrayList<Integer> height)
    {
        int max = 0;
        for(int i=0;i<height.size();i++)
        {
            for(int j=i+1;j<height.size();j++)
            {
                int ht = Math.min(height.get(i),height.get(j));
                int width = j-i;
                max = Math.max (max, ht*width);

            }
        }
        return max;

    }

    public static int storeWater2(ArrayList<Integer> height)
    {
        int leftPT = 0;
        int rightPT = height.size()-1;
        int max = 0;
        while(leftPT<rightPT)
        {
            int ht = Math.min(height.get(leftPT),height.get(rightPT));
            int width = rightPT-leftPT;
            int currwater= ht*width;
            max=Math.max(max,currwater);

//            update height

            if(height.get(leftPT) < height.get(rightPT))
            {
                leftPT++;

            }
            else
            {
                rightPT--;
            }
        }

        return max;

    }

//     traping rain water
    public static int  trapRainWater(ArrayList<Integer> height)
    {
        int waterSum=0;

        for(int i=0;i<height.size()-1;i++)
        {
                int ht = Math.min(height.get(i),height.get(i+1));
                int width = 1 ;
                waterSum=waterSum + (ht*width);
        }
        return waterSum;
    }


    public static int maxWater(int[] arr, int n)
    {

        // To store the maximum water
        // that can be stored
        int res = 0;

        // For every element of the array
        // except first and last element
        for (int i = 1; i < n - 1; i++) {

            // Find maximum element on its left
            int left = arr[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            // Find maximum element on its right
            int right = arr[i];
            for (int j = i + 1; j < n; j++) {
                right = Math.max(right, arr[j]);
            }

            // Update maximum water value
            res += Math.min(left, right) - arr[i];
        }
        return res;
    }
    




    public static void main(String[] args) {
//        System.out.println("hii");

//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        ArrayList<Integer> list =  new ArrayList<>();


//        list.add(1);
//        list.add(6);
//        list.add(3);
//        list.add(4);
//
//        System.out.println(isMonotonic(list));

        ArrayList<Integer>  heigth = new ArrayList<>();
        heigth.add(1);
        heigth.add(8);
        heigth.add(6);
        heigth.add(2);
        heigth.add(5);
        heigth.add(4);
        heigth.add(8);
        heigth.add(3);
        heigth.add(7);

//        System.out.println(storeWater2(heigth));
//        System.out.println(trapRainWater(heigth));
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int n = arr.length;

        System.out.print(maxWater(arr, n));

    }
}


