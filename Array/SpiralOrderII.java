package Array;
//https://leetcode.com/problems/spiral-matrix-ii/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrderII {
    public static void main(String[] args) {
        int n =3;
       int [][] ans= generateMatrix(n);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }

   static public int[][] generateMatrix(int n) {
       int rowBegin = 0;
       int rowEnd = n-1;
       int colBegin =0;
       int colEnd = n-1;
       int [][]ans = new int[n][n];
       int element =1;
       while (rowBegin<=rowEnd && colBegin<=colEnd){
           // travers right
           for (int i = colBegin; i <=colEnd ; i++) {
//               ans.add(matrix[rowBegin][i]);
               ans[rowBegin][i] = element++;
           }
           rowBegin++;
           // travers down
           for (int i = rowBegin; i <= rowEnd; i++) {
//               ans.add(matrix[i][colEnd]);
               ans[i][colEnd] = element++;
           }
           colEnd--;

           if (rowBegin<=rowEnd){
               // travers left
               for (int i = colEnd; i >= colBegin; i--) {
//                   ans.add(matrix[rowEnd][i]);
                   ans[rowEnd][i] = element++;
               }
           }
           rowEnd--;
           // travers up
           if (colBegin<=colEnd){
               for (int i = rowEnd; i >=rowBegin ; i--) {
//                   ans.add(matrix[i][colBegin]);
                   ans[i][colBegin] = element++;
               }
           }
           colBegin++;
       }
       return  ans;
    }
}
