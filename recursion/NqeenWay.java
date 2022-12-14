package recursion;

public class NqeenWay {
    static boolean isSafe(int row , int col, boolean [] [] board){
        // check vertically
        for (int i =0; i<row;i++){
            if (board[i][col]){
                return  false;
            }
        }

        // check left Diagonally

        int maxLeft = Math.min(row,col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row-i][col-i]){
                return  false;
            }
        }

        int maxRight = Math.min(row,board.length-col-1);
        for (int i = 1; i <=maxRight; i++) {
                if (board[row-i][col+i]){
                    return  false;
                }
        }
        return true;
    }

   static int contWay(int row ,boolean [][] board){
        if (row ==board.length){
            return 1;
        }
        int count =0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(row,col,board)){
                board[row][col] = true;
              count+= contWay(row+1,board);
               board[row][col] =false;
            }
        }
        return  count;


    }

    public static void main(String[] args) {
        int n = 4;
        boolean [][]board =new boolean[n][n];
        System.out.println(contWay(0,board));

    }
}
