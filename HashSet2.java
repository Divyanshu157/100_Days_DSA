
import java.util.HashMap;
import java.util.HashSet;

public class HashSet2 {

    public static String getStart(HashMap<String,String> tickets){

        HashMap<String,String> revMap= new HashMap<>();
        for(String key : tickets.keySet()){
            revMap.put(tickets.get(key),key);
        }

        for (String key:tickets.keySet()){
            if (!revMap.containsKey(key)){
                return key;
            }
        }

        return null;
    }

    public static void main(String[] args) {

//        int arr[] =  new int[10];

        /*
        int arr[] = {1,2,3,4,2,1,3,4,2,1};


        HashSet<Integer> hs = new HashSet<>();
        for (int i=0;i<arr.length;i++){
            hs.add(arr[i]);

        }
        System.out.println(hs.size());

         */





      //  int arr1[] ={1,2,3,4,1,2};
        //int arr2[]={1,2,7,8};
         /*
         //Union of Array
        HashSet<Integer> hs= new HashSet<>();
        for (int i=0;i<arr1.length;i++){
            hs.add(arr1[i]);
        }
        for (int i=0;i<arr2.length;i++){
            hs.add(arr2[i]);
        }
        System.out.println(hs);

        /

         */

        /*

        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> hs1 = new HashSet<>();
        int count =0;
        for (int i=0;i<arr1.length;i++){
            hs.add(arr1[i]);
        }
        for (int i=0;i<arr2.length;i++){
            if (hs.contains(arr2[i])) {
                count++;
                hs1.add(arr2[i]);
            }
        }
        System.out.println(hs1);



         */

        HashMap<String,String>  tickets = new HashMap<>();
        tickets.put("Chennai" , "Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()){
            System.out.print(" -> "+tickets.get(start));
            start=tickets.get(start);
        }
    }
}
