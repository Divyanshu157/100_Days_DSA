
import java.util.*;


// Q1-> Given an integer array of sz n , find  all element thet appear more then n/3 times

public class LinkedHashMap1 {

    public static void main(String[] args) {


//      In linkedHashMap order of Insertion is same as of remove like Queue , doublyLinkedLIst data Structure is used in array in Linkedlisthashmap

        /*
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("Chine",150);
        lhm.put("India",100);
        lhm.put("US",25);

        HashMap<String ,Integer> hm = new HashMap<>();
        hm.put("Chine",150);
        hm.put("India",100);
        hm.put("US",25);

         */

//        System.out.println(lhm);
//        System.out.println(hm);

        // In tree hashMap keys are sorted

        /*
        TreeMap<String,Integer>  thm = new TreeMap<>();
        thm.put("Chine",150);
        thm.put("India",100);
        thm.put("US",25);
        thm.put("America", 50);

        HashMap<String ,Integer> hm = new HashMap<>();
        hm.put("Chine",150);
        hm.put("India",100);
        hm.put("US",25);


        System.out.println(thm);
        System.out.println(hm);


         */

//        Solution 1

        int arr[] ={ 1,2,3,1,2,3,1,4,1,4,4,5,1,1,1,4,4,4,4};

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<arr.length;i++){
            if (map.containsKey(arr[i]))
            {
                map.put(arr[i], map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);

            }

//      map.put(arr[i] ,map.getOrDefault(arr[i],0)+1);
        }
//        System.out.println(map);
//        System.out.println(map.get(1));



        for (Integer key: map.keySet()) {
            if (map.get(key)>arr.length/3){
                System.out.println(key);
            }
        }

     }
}
