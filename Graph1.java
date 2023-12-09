import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph1 {
    static class Edge{
        int scr;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.scr=s;
            this.dest=d;
            this.wt=w;

        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();

        }

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        //1=vertex
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));
//        graph[1].add(new Edge(1,3,3));

        //2 vetex
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));
//        graph[2].add(new Edge(2,4,4));

//        3 vertex
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));


        //4 veertex
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        //5 vertex
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        //6 vetex
        graph[6].add(new Edge(6,5,1));


    }

    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty()){
            int curr= q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;
                for (int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }


    public static void main(String[] args) {

//        int V =5;
//        ArrayList<Edge>[] graph = new ArrayList[V];
//        for (int i=0;i<V;i++){
//            graph[i] = new ArrayList<>();
//        }

        //0 vertex
//        graph[0].add(new Edge(0,1,5));
//
//        //1=vertex
//        graph[1].add(new Edge(1,0,5));
//        graph[1].add(new Edge(1,2,1));
//        graph[1].add(new Edge(1,3,3));
//
//        //2 vetex
//        graph[2].add(new Edge(2,1,1));
//        graph[2].add(new Edge(2,3,1));
//        graph[2].add(new Edge(2,4,4));
//
////        3 vertex
//        graph[3].add(new Edge(3,1,3));
//        graph[3].add(new Edge(3,2,1));
//
//        //4 veertex
//        graph[4].add(new Edge(4,2,2));

        //2's neighbours
//        for (int i=0;i<graph[2].size();i++){
//            Edge d =graph[2].get(i);
//            System.out.println(d.dest);
//
//        }

        int V =7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph);
    }

}
