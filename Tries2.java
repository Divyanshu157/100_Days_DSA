public class Tries2 {

    static class Node{
        Node children[] = new Node[26];
        int freq;
        boolean eow;

        public Node(){

            for (int i=0;i<children.length;i++) {
                children[i] = null;

            }
            freq=1;
            eow=false;
        }
    }

    public static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for (int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if (curr.children[idx]==null){
                curr.children[idx] = new Node();
            }else {
                curr.freq++;
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public static String findShortestUniquePrefix(String word) {
        Node curr = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            curr = curr.children[idx];
            prefix.append(word.charAt(i));
            if (curr.freq == 1) {
                break;
            }
        }
        return prefix.toString();
    }


    public static void main(String[] args) {

        String arr[]= {"zebra","dog","duck","dove"};

        for (String words:arr){
            insert(words);
        }
        for (String word:arr){
            System.out.println(findShortestUniquePrefix(word));
        }

    }
}
