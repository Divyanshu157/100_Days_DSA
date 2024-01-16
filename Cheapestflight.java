
/*
There are n cities connected by some number of flights.
 You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from
  city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k,
return the cheapest price from src to dst with at most k stops.
If there is no such route, return -1.

 */

/*
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 */
import java.util.*;

class Data {
    int node, dist, cost;

    Data(int a, int b, int c) {
        node = a;
        dist = b;
        cost = c;
    }
}

class Cheapestflight1 {
    int[][] cost;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        cost = new int[n + 1][K + 10];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            graph[u].add(new int[]{v, w});
        }

        PriorityQueue<Data> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        q.add(new Data(src, 0, 0));
        cost[src][0] = 0;

        while (!q.isEmpty()) {
            Data temp = q.poll();
            int curr = temp.node;
            int dist = temp.dist;

            if (curr == dst)
                return temp.cost;

            dist++;
            if (dist > K + 1)
                continue;

            for (int[] neighbor : graph[curr]) {
                int nextNode = neighbor[0];
                int newCost = cost[curr][dist - 1] + neighbor[1];

                if (newCost < cost[nextNode][dist]) {
                    cost[nextNode][dist] = newCost;
                    q.add(new Data(nextNode, dist, newCost));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Cheapestflight1 ob = new Cheapestflight1();
        int[][] v = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(ob.findCheapestPrice(3, v, 0, 2, 1));
    }
}







