//https://leetcode.com/problems/n-queens/submissions/

package recursion;
import java.util.ArrayList;

import java.util.List;

public class Nqeen {
   static boolean isSafe(int row , int col , char [][] board){
        // check vertically
        for (int i = 0; i <row ; i++) {
            if (board[i][col]=='Q'){
                return  false;
            }
        }

       // check diagonally left
        int leftMax = Math.min(row,col);
        for (int i = 1; i <= leftMax; i++) {
            if (board[row-i][col-i]=='Q'){
                return  false;
            }
        }
        // check diagonally right

        int rightMax = Math.min(row,board.length-col-1);
        for (int i = 1; i <=rightMax; i++) {
            if (board[row-i][col+i]=='Q'){
                return  false;
            }
        }
        return true;
    }
//
//   static void display(char [][]board){
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j <board[i].length; j++) {
//                System.out.println(board[i][j]);
//            }
//            System.out.println();
//        }
//    }


    static void nQeens(int row, char [][] board,List<List<String>> finalList){
        if (row ==board.length){
            List<String> curr = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    sb.append(board[i][j]);
                }
                curr.add(sb.toString());
            }
            finalList.add(curr);
//            display(board);
            return ;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(row,col,board)){
                board[row][col] = 'Q';
                nQeens(row+1,board,finalList);
                board[row][col] ='.';
            }
        }

    }

    public static void main(String[] args) {
       List<List<String>> FinalList = new ArrayList<>();
        int n =4;
        char [][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                    board[i][j] ='.';
            }
        }
      nQeens(0,board,FinalList);
        for (int i = 0; i < FinalList.size(); i++) {
            System.out.println(FinalList.get(i));
        }
    }



}
