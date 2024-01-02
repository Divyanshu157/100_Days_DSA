public class MinimumDeletion {

    public static int utility(String str1, int i ,int j){

        if (i>=j) {
            return 0;
        }
        if (str1.charAt(i)==str1.charAt(j)){
                return utility(str1,i+1,j-1);
        }
        return 1+Math.min(utility(str1,i+1,j),utility(str1,i,j-1));
    }

    public static int min_del(String str1){
        return utility(str1,0,str1.length()-1);

    }

    public static void main(String[] args) {

        String str1 = "aebcbda";
        System.out.println(min_del(str1));

    }
}
