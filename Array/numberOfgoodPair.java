package Array;

public class numberOfgoodPair {


    public static void main(String[] args) {
        int [] arr = new int[100];
        int count =0;
        int []nums ={1,2,3,1,1,3};
        for (int i = 0; i < nums.length; i++) {
            count= count+arr[nums[i]];
            arr[nums[i]]++;
        }

        System.out.println(count);
    }
}
