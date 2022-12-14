package recursion;
import java.util.ArrayList;
import java.util.List;
public class Subset {
    public static void Calculator(int ind, int[] arr, ArrayList<Integer> temp, List<List<Integer>> ans) {
        if (ind == arr.length) {
            ans.add(temp);
            return;

        }
        temp.add(arr[ind]);
        Calculator(ind + 1, arr, new ArrayList<Integer>(temp), ans);
        temp.remove(temp.size() - 1);
        Calculator(ind + 1, arr, new ArrayList<Integer>(temp), ans);

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Calculator(0, nums, temp, ans);
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = subsetsWithDup(nums);
        System.out.println(ans);

    }

}