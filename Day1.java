
import java.util.ArrayList;
import  java.math.*;
import  java.util.Collections;
public class Day1 {
//  Swaping element of ArrayList
    public static ArrayList<Integer> swap(ArrayList<Integer> list ,int id1,int id2)
    {
        int temp = list.get(id1);
        list.set(id1,list.get(id2));
        list.set(id2,temp);

        return list;
    }

//    Sorting using Collections.sort(list)  it will return

    public static ArrayList<String> sort(ArrayList<String> list)
    {
         Collections.sort(list ,Collections.reverseOrder());
         return list;


    }

    public static void main(String[] args) {
//      Creating ArrayList of Integer Type
        ArrayList<Integer> list = new ArrayList<>();

//        Operation of ArrayList
//        1.list.add(element);
//        2.list.remove(index);
//        3.list.set(index,element);
//        4.list.get();
//        5. list.contains(element);

//      Adding elements

        list.add(5);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);


//      Find Maximum without using Math.max function

        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++)
        {
            int temp = list.get(i);
            if(max<temp)
            {
                max=temp;

            }
//            max = Math.max(max,list.get(i));
        }
        System.out.println(max);
        System.out.println(list);


//        System.out.println(swap(list ,0,4));

        ArrayList<String> list2 =  new ArrayList<>();
        list2.add("ABCD");
        list2.add("abcd");

//      Sorting elements using Collections.sort() or Colllection Framework
        Collections.sort(list2,Collections.reverseOrder());
        System.out.println(list2);
     }
}
