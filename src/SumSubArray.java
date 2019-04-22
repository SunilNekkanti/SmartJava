import java.util.Arrays;

public class SumSubArray {


    public static void main(String[] args) {
        //max sum
        int[] a = {-1, -2, -3, -4, -5, 15, -7, -9, -2};
        maxSumSubArray(a);


    }

    private static void maxSumSubArray(int[] a) {

        int maxSum = 0;
        int maxEndingHere = 0;
        for(int i = 0; i< a.length; i++){
            maxEndingHere = Math.max(0, maxEndingHere + a[i]);
            maxSum = Math.max(maxEndingHere, maxSum);
        }
        System.out.println(maxSum);

    }
}
