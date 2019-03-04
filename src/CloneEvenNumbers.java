import java.util.Arrays;
import java.util.stream.IntStream;

public class CloneEvenNumbers {


    public static void cloneEvenNumbers(int[] a){

       int emptyIndex = -1;

        for(int i=0; i<a.length;i++){

            if(a[i]%2==0){
               emptyIndex = findEmptySlot(a);
               if (emptyIndex!=-1) {
                   a[emptyIndex] = a[i];
               }
            }


        }
        System.out.println(Arrays.toString(a));


    }

    public static int findEmptySlot(int[] arr){

        for(int i= arr.length-1; i>0;i--){
            if(arr[i]==-1){
                return i;
            }

        }

    return -1;
    }
    public static void main(String[] args) {
        int[] intarr = {1,3,4,8,-1,9,-1};
        cloneEvenNumbers(intarr);

    }
}
