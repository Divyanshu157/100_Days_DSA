public class Nqueen {

    public static void nqueen(char chessBoard[][] ,int row){

        //base case

        if (row== chessBoard.length){
            print(chessBoard);
            return;
        }


        //recursion

        for (int j =0;j< chessBoard.length;j++){

            if(isSafe(chessBoard,row,j)) {
                chessBoard[row][j] = 'Q';
                nqueen(chessBoard, row + 1);
                chessBoard[row][j] = '.';
            }
        }
    }


    public static boolean isSafe(char board[][]  ,int row ,int col){
        //up
        for (int i=row-1;i>=0;i--){
            if (board[i][col]=='Q')
            {
                return false;
            }
        }


        //diagonal left

        for (int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if (board[i][j]=='Q'){
                return false;
            }
        }

        //diagona right

        for (int i=row-1,j=col+1;i>=0 && j<board.length ;i--,j++){
            if (board[i][j]=='Q'){
                return false;
            }
        }

        return true;


    }

    public static void print(char board[][]){
        for (int i=0;i<board.length;i++){
            for (int j=0;j< board.length;j++){
                System.out.print(board[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {

        int n =5;
        char chessBoard[][] = new char[n][n];

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                chessBoard[i][j] = '.';

            }
        }
        nqueen(chessBoard,0);

    }
}
