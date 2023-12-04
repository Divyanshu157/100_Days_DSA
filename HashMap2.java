import java.util.*;
import java.util.LinkedList;



public class HashMap2 {
    public class HashMapCode{
        static class HashMap<K,V> {
            private class Node{
                K key;
                V value;

                public Node(K key, V value) {
                    this.key = key;
                    this.value = value;
                }
            }
                private int n;
                private int N;

                private LinkedList<Node> buckets[];
                public HashMap() {
                    this.N=4;
                    this.buckets = new LinkedList[4];
                    for (int i = 0; i < 4; i++) {
                        this.buckets[i] = new LinkedList<>();
                    }
                }

                private  int hashFunction(K key){
                    int hc = key.hashCode();
                    return Math.abs(hc) % N ;
                }

                private int SearchLL(K key , int bi){
                    LinkedList<Node> ll =buckets[bi];
                    int di =0;
                    for (int i=0;i<ll.size();i++){
                        Node node =ll.get(i);
                        if(node.key==key){
                            return di;
                        }
                        di++;
                    }
                    return -1;
                }
                private void rehash(){
                    LinkedList<Node> oldBuck[] =buckets;
                    buckets=new  LinkedList[N*2];
                    N=2*N;
                    for (int i=0;i< buckets.length;i++){
                        buckets[i]=new LinkedList<>();

                    }

                    for (int i=0;i<oldBuck.length;i++){
                        LinkedList<Node> ll =oldBuck[i];
                        for (int j=0;j<ll.size();j++){
                            Node node = ll.remove();
                            put(node.key,node.value);
                        }
                    }
                }

                public void put(K key , V value){
                    int bi =hashFunction(key);
                    int di = SearchLL(key,bi);
                    if (di !=-1){
                        Node node = buckets[bi].get(di);
                        node.value=value;

                    }else {
                        buckets[bi].add(new Node(key,value));
                        n++;
                    }
                    double lambda = (double) n/N;
                    if (lambda>2.0){
                        rehash();
                    }


                }

                public boolean containsKey( K key){

                    int bi =hashFunction(key);
                    int di = SearchLL(key,bi);
                    if (di !=-1){
                       return true;
                    }else {
                       return false;
                    }

                }

                public V get(K key){
                    int bi =hashFunction(key);
                    int di = SearchLL(key,bi);
                    if (di !=-1){
                        Node node = buckets[bi].get(di);
                        return node.value;

                    }else {
                       return null;
                    }

                }

                public V remove(K key){
                    int bi =hashFunction(key);
                    int di = SearchLL(key,bi);
                    if (di !=-1){
                        Node node = buckets[bi].remove(di);
                        return node.value;

                    }else {
                        return null;
                    }
                }




        }
    }


    public static void main(String[] args) {

        HashMap<String ,Integer>  hm = new HashMap<>();
        hm.put("India",100);
        hm.put("China" , 150);
        hm.put("US" , 50);
        hm.put("Nepal",5);
        hm.put("Canada",200);



    }
}
