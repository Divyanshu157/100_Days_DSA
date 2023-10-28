import java.util.ArrayList;

public class Day4 {

//    pair sum of sorted and rotated list or Array

    public static boolean pairSum(ArrayList<Integer> list,int target)
    {
        int lp=0,rp=0;
        int n = list.size();
        int bp =-1;



        for(int i=0;i<list.size();i++)
        {
            if(list.get(i)>list.get(i+1))
            {
              bp = i;

               break;
            }
        }
        lp=bp+1;
        rp=bp;

        while(lp!=rp)
        {
//            case1
            if(list.get(lp)+list.get(rp)==target)
            {
//                System.out.println(list.get(lp)+" + "+list.get(rp)+" + "+ "=="+ target);
                return true;
            }
//            case2
            if (list.get(lp)+list.get(rp)<target)
            {
                lp=(n+1)%n;
            }else {
                rp=(n+rp-1)%n;
            }

        }
        return false;

    }

    public static void  main(String [] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(pairSum(list,16));



    }
}
