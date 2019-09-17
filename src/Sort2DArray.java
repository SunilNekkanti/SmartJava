import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

//https://leetcode.com/discuss/interview-question/381172/google-phone-screen-sort-a-2d-array
public class Sort2DArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
            {5, 12, 17, 21, 23},
            { 1,  2,  4,  6,  8},
            {12, 14, 18, 19, 27},
            {3,  7,  9, 15, 25}
        };
        qSort(arr);
        print(arr);
    }
    static void qSort(int[][]arr){
        int R = arr.length, C = R > 0 ? arr[0].length : 0;
        BiFunction<Integer,Integer,Integer>
            cmpFn = (i,j)->Integer.compare(arr[i/C][i%C],arr[j/C][j%C]);
        BiConsumer<Integer,Integer>
            swapFn = (i,j) -> {
                int tmp = arr[i/C][i%C];
                arr[i/C][i%C] = arr[j/C][j%C];
                arr[j/C][j%C] = tmp;            
            };
        class QSort{
            void sort(int lo, int hi){
                if (lo >= hi){ return; }
                swapFn.accept(lo, lo+(hi-lo)/2);
                int i = lo,//1. i: points to leftMostIdxOfPivot
                    j = lo+1,//2. j: points right to rightMostIdxOfPivot
                    k = hi;//3. k: points left to leftMostIdxOfOverPivot
                while(j <= k){
                    if (cmpFn.apply(j,i) <= 0){//invariant 1. and 2.
                        swapFn.accept(i++,j++);
                        continue;
                    }
                    if(cmpFn.apply(k,i) <= 0){//invariant 2. and 3.
                        swapFn.accept(k--,j);
                        continue;
                    }
                    --k;//invariant 3.
                }
                sort(lo,i-1);
                sort(j,hi);
            }
        }
        new QSort().sort(0,R*C-1);
    }
    static void print(int[][]arr){
        for(int[] row : arr){
            System.out.println(Arrays.toString(row));
        }        
    }    
}