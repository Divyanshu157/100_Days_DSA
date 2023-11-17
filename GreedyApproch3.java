import java.util.*;

public class GreedyApproch3 {

//    problem 1
    public static int   countCoin(Integer coins[],int amount){

        Arrays.sort(coins, Comparator.reverseOrder());
        int countCois =0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<coins.length;i++){
            if(coins[i]<amount){
                while (coins[i]<=amount){
                    countCois++;
                    ans.add(coins[i]);
                    amount -=coins[i];


                }
            }
        }
        System.out.println(ans);

        return countCois;

    }

//    problem 2
    static class Job{
        int deadline;
        int profit;
        int id;

        public Job(int id, int deadline,int profit){
            this.id=id;
            this.deadline=deadline;
            this.profit=profit;
        }
    }

    public static void jobs(int jobsInfo[][])
    {
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new Job(i,jobsInfo[i][0] , jobsInfo[i][1]));
        }
        Collections.sort(jobs , (obj1,obj2) -> obj2.profit-obj1.profit);
//        descending order profit

        ArrayList<Integer> seq=  new ArrayList<>();
        int time =0;
        for (int i=0;i<jobs.size();i++){
            Job curr = jobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;

            }
        }

        System.out.println("max jobs = " +seq.size());
        for (int i =0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");

        }
    }

//    problem 3 ->  chocola problem   (Hard level)

    public static int chocoloProblem(Integer costVer[] , Integer costHor[] , int rows,int cols){
        int n= rows;
        int m = cols;

        Arrays.sort(costHor ,Collections.reverseOrder());
        Arrays.sort(costVer,Collections.reverseOrder());
        int h=0, v=0;
        int hp= 1,vp=1;
        int cost =0;
        while (h<costHor.length && v<costVer.length){
            if(costVer[v] <=costHor[h]){ //horizontal Cut
                cost += ( vp *costHor[h]);
                hp++;
                h++;
            }else {  //vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }
        while (v<costVer.length){
            cost += (costVer[v]*hp);
            vp++;
            v++;
        }
        while (h<costHor.length){
            cost += (costHor[h] *vp);
            hp++;
            h++;
        }
        return cost;
    }

    public static void main(String[] args) {
//        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
//        System.out.println(countCoin(coins,5590));

//        int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,30}};
//        jobs(jobsInfo);

        Integer costVer[] ={2,1,3,1,4};
        Integer costHor[] ={4,1,2};
        System.out.println(chocoloProblem(costVer,costHor ,4,6));
    }
}
