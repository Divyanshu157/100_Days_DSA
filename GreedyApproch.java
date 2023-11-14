import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyApproch {

//    problem 1 Activity selection :---
//            you are given n activities with their start and end times .
//            select the maximun number of activitws that can be perforrned by single person ,
//            assume person can o one activity at a  time .Activites are Sorted according to end time.

    public static void activitySelection(int start[] , int end[]) {

//        Sorting
        int activites[][] = new int[start.length][3];
        for (int i=0;i<start.length;i++){
            activites[i][0]=i;
            activites[i][1]=start[i];
            activites[i][2]=end[i];
        }
//        lambda function -> Shortform
        Arrays.sort(activites, Comparator.comparingDouble(o->o[2]));

//        end tie basis sort
        int maxAct = 0;
        ArrayList<Integer> list = new ArrayList<>();


//        1ast activity
        maxAct=1;
        list.add(activites[0][0]);
        int lastEnd =  activites[0][2];
        for (int i=1;i<end.length;i++){
            if(activites[i][1]>=lastEnd){
//              activity select
                maxAct++;
                lastEnd=activites[i][2];
                list.add(activites[i][0]);
            }
        }
        System.out.println(maxAct);
        for (int i=0;i<list.size();i++){
            System.out.print( "A"+list.get(i)+"  ");
        }
    }


//    problem 2 - Fractional knapsnack
    public static void fractionKnapscak(int weight[] , int val[],int W){

        double ratio[][] =  new  double[val.length][2];
//        0th col =>index
//        1st col => ratio

        for (int i=0;i<val.length;i++){
            ratio[i][0] = i;
            ratio[i][1]= val[i]/(double)weight[i];

        }

//        ascending order
        Arrays.sort(ratio , Comparator.comparingDouble(o->o[1]));
        int capacity  = W;
        int finalVal=0;
        for (int i= ratio.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            if (capacity>=weight[idx]){
                finalVal  += val[idx];
                capacity -=weight[idx];
            }else {
                finalVal +=(ratio[i][1] *capacity);
                capacity =0;
                break;
            }
        }
        System.out.println(finalVal);
    }








    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2,4, 6, 7, 9, 9};

//        activitySelection(start,end);
        int val[]= {60,100,120};
        int weight[] = {10,20,30};
        int W =50;
        fractionKnapscak(weight,val,W);


    }
}
