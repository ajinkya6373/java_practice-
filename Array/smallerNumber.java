//Input: nums = [8,1,2,2,3]
//        Output: [4,0,1,1,3]
//        Explanation:
//        For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
//        For nums[1]=1 does not exist any smaller number than it.
//        For nums[2]=2 there exist one smaller number than it (1).
//        For nums[3]=2 there exist one smaller number than it (1).
//        For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class smallerNumber {
    public static void main(String[] args) {
        int [] arr = {8,1,2,2,3};
        int [] temp = new int[101];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            temp[i] +=temp[i-1];
        }

        for (int i = 0; i < arr.length; i++) {
          int pos =arr[i];

            arr[i] = pos==0 ? 0 : temp[pos-1];
        }
        System.out.println(Arrays.toString(arr));
    }

}
