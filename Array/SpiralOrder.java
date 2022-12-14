
//https://leetcode.com/problems/spiral-matrix/
package Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {

        int arr[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        List<Integer> ans= Spiral(arr);
        System.out.println(ans);
    }


   static public List<Integer> Spiral(int[][] matrix) {
            int rowBegin = 0;
            int rowEnd = matrix.length-1;
            int colBegin =0;
            int colEnd = matrix[0].length-1;
            List<Integer> ans = new ArrayList<>();
            while (rowBegin<=rowEnd && colBegin<=colEnd){
                // travers right
                for (int i = colBegin; i <=colEnd ; i++) {
                    ans.add(matrix[rowBegin][i]);
                }
                rowBegin++;
                // travers down
                for (int i = rowBegin; i <= rowEnd; i++) {
                    ans.add(matrix[i][colEnd]);
                }
                colEnd--;

                if (rowBegin<=rowEnd){
                    // travers left
                    for (int i = colEnd; i >= colBegin; i--) {
                        ans.add(matrix[rowEnd][i]);
                    }
                }
                rowEnd--;
                // travers up
                if (colBegin<=colEnd){
                    for (int i = rowEnd; i >=rowBegin ; i--) {
                        ans.add(matrix[i][colBegin]);
                    }
                }
                colBegin++;
            }
        return  ans;
    }
}
