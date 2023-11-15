import java.util.Arrays;
import java.util.Comparator;

public class GreedyApproch2 {

//    problem 1 -> Minimum absolute difference

    public static int minAbsolute(int A[],int B[])
    {            //O(nlogn)
        Arrays.sort(A);
        Arrays.sort(B);
        int MinDiff =  0;
        for(int i=0;i<A.length;i++)
        {
            MinDiff += Math.abs(A[i]-B[i]);

        }
        return MinDiff;


    }

//    problem 2 -> Max chain length
    public static int maxLenghtOfChain(int pairs[][])  // O(nlogn)
    {
        Arrays.sort(pairs , Comparator.comparing(o->o[1]));

//        select 2 pairs
        int chainLen =1;
        int chainend= pairs[0][1];

        for (int i=1;i<pairs.length;i++)
        {
            if(pairs[i][0] > chainend)
            {
                chainLen++;
                chainend = pairs[i][1];

            }

        }
        return chainLen;
    }
public static void main(String[] args) {

//        int A[] = { 4,1,8,7};
//        int B[] = { 2,3,6,5};
//    System.out.print(minAbsolute(A,B));

    int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
    System.out.println(maxLenghtOfChain(pairs));


}
}
