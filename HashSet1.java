import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSet1 {

    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        /*
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(1);
        System.out.println(hs);
        hs.clear();
        System.out.println(hs);
        System.out.println(hs.isEmpty());
        System.out.println(hs.size());

         */

       hs.add("India");
       hs.add("Lucknow");
       hs.add("U.A");
       hs.add("Xhine");
        System.out.println(hs);
        /*

        //itrator
        Iterator itr=  hs.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        // itrate using enhanced for loop
        for (String cites: hs){
            System.out.println(cites);
        }

         */

        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("India");
        lhs.add("Lucknow");
        lhs.add("U.A");
        lhs.add("Xhine");
        System.out.println(lhs);

        TreeSet<String > ts = new TreeSet<>();
        ts.add("India");
        ts.add("Lucknow");
        ts.add("A.U");
        ts.add("Xhine");
        System.out.println(ts);


    }
}
