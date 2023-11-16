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




    public static void main(String[] args) {
//        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
//        System.out.println(countCoin(coins,5590));

        int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,30}};
        jobs(jobsInfo);

    }
}
