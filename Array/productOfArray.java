package Array;

import java.util.Arrays;

public class productOfArray {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int[] result = new int[nums.length];
        int rp = 1;
        if(nums == null || nums.length == 0) {
//            return new int[0];
            System.out.println(Arrays.toString(result));
        }


        //left pass
        for(int i = 0; i < nums.length; i++) {
            result[i] = rp;
            rp = rp * nums[i];
        }

        // right pass
        rp = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * rp;
            rp = rp * nums[i];
        }

//        return result;
        System.out.println(Arrays.toString(result));

    }
}
