import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMap3 {

//    public static int count(String str){
//        return str.length();
//    }
//    public static boolean areTreeMapsEqual(TreeMap<Character, Integer> map1, TreeMap<Character, Integer> map2) {
//        // Check if the sizes are equal
//        if (map1.size() != map2.size()) {
//            return false;
//        }
//
//        // Check if all keys are present and values are equal
//        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
//            Character key = entry.getKey();
//            Integer value = entry.getValue();
//
//            if (!map2.containsKey(key) || !map2.get(key).equals(value)) {
//                return false;
//            }
//        }
//
//        return true;
//    }


    public static boolean isAanagram(String s,String t){
        if (s.length() !=t.length()){
            return false;
        }
        HashMap<Character , Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i=0;i<t.length();i++){
            char ch= t.charAt(i);
            if(map.get(ch)!=null){
                if (map.get(ch)==1){
                    map.remove(ch);
                }else {
                    map.put(ch,map.get(ch)-1);
                }
            }else {
                return false;
            }
        }
        return map.isEmpty();
    }





    public static void main(String[] args) {
        String str1 = "lipid";
        String str2 = "dipli";
//        int c1 = count(str1);
//        int c2=count(str2);
//        TreeMap<Character,Integer> tm1 = new TreeMap<>();
//        TreeMap<Character ,Integer> tm2 = new TreeMap<>();
//        if (c1==c2){
//            for (int i=0;i<str1.length();i++){
//                tm1.put(str1.charAt(i) , tm1.getOrDefault(str1.charAt(i),0)+1);
//                tm2.put(str2.charAt(i),tm2.getOrDefault(str2.charAt(i),0)+1);
//            }
//        }
//        System.out.println(areTreeMapsEqual(tm1,tm2));

        System.out.println(isAanagram(str1,str2));






    }
}
