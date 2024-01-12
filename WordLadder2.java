import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {

    public static ArrayList<ArrayList<String>> findSequences(String startword , String targetword , String wordList[]){
        Set<String> st = new HashSet<String>();
        int len = wordList.length;
        for (int i=0;i<len;i++){
            st.add(wordList[i]);
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String>  ls = new ArrayList<>();
        ls.add(startword);
        q.add(ls);
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startword);
        int level=0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        while (!q.isEmpty()){
            ArrayList<String > vec =  q.peek();
            q.remove();

            if (vec.size()>level){
                level++;
                for (String it : usedOnLevel){
                    st.remove(it);
                }
            }
            String word  =  vec.get(vec.size()-1);
            if (word.equals(targetword)){
                if (ans.size()==0)  ans.add(vec);
                else if (ans.get(0).size()==vec.size()) ans.add(vec);

            }

            for (int i=0;i<word.length();i++){

                for (char c = 'a';c<='z';c++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = c;
                    String repalcedword  = new String(replacedCharArray);
                    if (st.contains(repalcedword)==true){
                        vec.add(repalcedword);

                        ArrayList<String > temp  =  new ArrayList<>(vec);
                        q.add(temp);
                        usedOnLevel.add(repalcedword);
                        vec.remove(vec.size()-1);

                    }

                }
            }
        }
        return ans;


    }

    public static void main(String[] args) {

        String[] wordList = {"des","der","dfr","dgt","dfs"};
        String startWord ="der";
        String targetWord ="dfs";


        System.out.println(findSequences(startWord,targetWord,wordList));


    }
}
