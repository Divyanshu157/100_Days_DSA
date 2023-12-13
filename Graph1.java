import java.awt.*;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.LinkedList;

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

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        //1=vertex
        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));
//        graph[1].add(new Edge(1,3,3));

        //2 vetex
        graph[2].add(new Edge(2,4,3));
//        graph[2].add(new Edge(2,4,1));
//        graph[2].add(new Edge(2,4,4));

//        3 vertex
        graph[3].add(new Edge(3,5,1));
//        graph[3].add(new Edge(3,4,1));
//        graph[3].add(new Edge(3,5,1));


        //4 veertex
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
//        graph[4].add(new Edge(4,5,1));

//        //5 vertex
//        graph[5].add(new Edge(5,3,1));
//        graph[5].add(new Edge(5,4,1));
//        graph[5].add(new Edge(5,6,1));
//
//        //6 vetex
//        graph[6].add(new Edge(6,5,1));
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

    public static void dfs(ArrayList<Edge> graph[] ,int curr , boolean vis[]){
        System.out.print(curr+" ");
        vis[curr] = true;

        for (int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                dfs(graph,e.dest,vis);

            }
        }
    }


    public static boolean hasPath(ArrayList<Edge> graph[] ,int src,int dest,boolean vis[]){
        if (src==dest){
            return true;
        }
        vis[src]=true;
        for (int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && hasPath(graph,e.dest,dest,vis)){
                return true;
            }

        }
        return false;
    }

    public static void calcIndeg(ArrayList<Edge> graph[] ,int indeg[]){
        for (int i=0;i<graph.length;i++){
            int v=i;
            for (int j=0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;

            }
        }
    }
    public static void topSort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        calcIndeg(graph,indeg);
        Queue<Integer> q = new LinkedList<>();


        for (int i=0;i<indeg.length;i++){
            System.out.println(" in for loop");
            if (indeg[i]==0){
                System.out.println("added");
                q.add(i);
            }
        }

        //bfs
        System.out.println(q);
        while (!q.isEmpty()){

            int curr=q.remove();
            System.out.println(curr+" ");

            for (int i=0;i<graph[curr].size();i++){
                Edge e =graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void printAllPath(ArrayList<Edge> graph[],int src,int dest,String path){
        if (src==dest){
            System.out.println(path+dest);
            return;
        }
        for (int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            printAllPath(graph,e.dest,dest,path+src);
        }
    }


    static class Pair implements Comparable<Pair> {
        int n ;
        int path;

        public Pair(int n ,int path){
            this.n=n;
            this.path=path;

        }
        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;

        }


    }

    public static void dijkstra(ArrayList<Edge> graph[] ,int src){
        int dist[] = new int[graph.length];
        for (int i=0;i<graph.length;i++){
            if (i!=src){
                dist[i] = Integer.MAX_VALUE;

            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        //loop
        while (!pq.isEmpty()){
            Pair curr =pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n]=true;
                //neighbours
                for (int i=0;i<graph[curr.n].size();i++){
                    Edge e = graph[curr.n].get(i);
                    int u=e.scr;
                    int v=e.dest;
                    int wt=e.wt;

                    if (dist[u]+wt < dist[v]){
                        dist[v] = dist[u]+wt;
                        pq.add(new Pair(v,dist[v]));


                    }

                }
            }

        }

        //print all source to vertices
        for (int i=0;i<dist.length;i++){
            System.out.println(dist[i]+" ");

        }
        System.out.println();
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

        int V =6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph);
//        System.out.println();
//        boolean vis[] = new boolean[V];

//        dfs(graph,0,vis);
//        System.out.println();
//        System.out.println(hasPath(graph,0,5,new boolean[V]));

        System.out.println("after topsort");
//        topSort(graph);
//        printAllPath(graph,5,1,"");
        int src =0;
        dijkstra(graph,src);




    }

}
