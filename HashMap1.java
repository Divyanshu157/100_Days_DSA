
import java.util.*;

public class HashMap1 {


    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();
/*

        //O(1)
        hm.put("India",100);
        hm.put("US",25);
        hm.put("China",150);
        System.out.println(hm);

//        O(1)
        hm.remove("China");
        System.out.println(hm);

//        O(1)
        System.out.println(hm.get("India"));

//        O(1)
        System.out.println(hm.containsKey("INdai"));
        //O(1)
        hm.clear();
        System.out.println(hm.isEmpty());



 */
        hm.put("India",100);
        hm.put("Chine",150);
        hm.put("US",25);
        hm.put("NewYork",20);
        hm.put("Indonesia",30);
//        System.out.println(hm);

        //Itrator
       Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String k: keys) {
            System.out.println("key = " + k + ", value = "+hm.get(k));
        }

        //Itrator  approch 2
        Set<Map.Entry<String,Integer>> pair = hm.entrySet();
        for (Map.Entry<String,Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() +" ," +entry.getValue());


        }




    }


}
