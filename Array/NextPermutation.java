package Array;

public class NextPermutation {
    public static int [] nextpermutation(int[] nums) {
        if(nums.length<=1 || nums==null) return nums;
        int i = nums.length -2;
        while(i>=0 && nums[i] >= nums[i+1]) i--;
        if(i>=0){
                int j =nums.length-1;
            while(nums[j]<=nums[i]) j--;
            swap(nums,i,j);
            
        }
        reverse(nums, i+1,nums.length-1);
    return nums;
}
    
   public static void swap(int arr [],int i, int j){
        int temp = arr[j];
        arr[j] =arr[i];
        arr[i] = temp;
    }
    
   public static void reverse(int arr[] , int i ,int j){
        while(i<j) {
            swap(arr, i++,j--);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{ 1,2,3 }; 
        int[] ans = new int[20];
       ans = nextpermutation(arr);
       System.out.println(ans.toString());
    }
}
