import java.util.Arrays;
import java.util.Scanner;



public class multidementionArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] [] arr = new int [3][3];
        System.out.println("enter values of array");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
