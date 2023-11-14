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


    





    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2,4, 6, 7, 9, 9};

        activitySelection(start,end);

    }
}
