import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Pair{
    String first;
    int second;
    Pair(String _first ,int _second){
        this.first=_first;
        this.second=_second;

    }
}
public class WordLadder1 {
    public int wordLadderLenght(String startWord ,String targetWord , String wordList[]){
      Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(startWord ,1));
      Set<String> st = new HashSet<String>();
      int len = wordList.length;
      for (int i=0;i<len;i++){
          st.add(wordList[i]);
      }
      st.remove(startWord);
      while (!q.isEmpty()){
          String word = q.peek().first;
          int steps= q.peek().second;
          q.remove();
          if (word.equals(targetWord)==true) return steps;
          //word=hat

          for (int i=0;i<word.length();i++){
              for (char ch ='a';ch <='z';ch++){
                  char replacedCharArray[]= word.toCharArray();
                  replacedCharArray[i] = ch;
                  String replacedWord =  new String(replacedCharArray);


                  if (st.contains(replacedWord) == true){
                      st.remove(replacedWord);
                      q.add(new Pair(replacedWord,steps+1));
                  }
              }
          }
      }
      return 0;



    }

    public static void main(String[] args) {

        String[] wordList = {"des","der","dfr","dgt","dfs"};
        String startWord ="der";
        String targetWord ="dfs";

        WordLadder1 w = new WordLadder1();
        System.out.println(w.wordLadderLenght(startWord,targetWord,wordList));


    }



}
