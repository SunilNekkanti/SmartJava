import java.util.Arrays;

public class DutchFlag {




    public static void main(String[] args) {

        int[] a = {3,5,2,6,8,4,4,6,4,4, 3};
        int[] b = dutchSort(a, 1);
        System.out.println(Arrays.toString(b));

    }

    private static int[] dutchSort(int[] a, int i) {


        int low = -1, mid = -1, high = a.length, pivot = a[i];
        while(mid+1 <= high-1){
            if(a[mid+1] > pivot ){
                //high logic
                swap(a, mid+1, high-1);
                high--;
            }
            else if(a[mid+1] == pivot){
                //equals logic
                mid++;
            }

            else if(a[mid+1] < pivot){
                // less than logic
                swap(a, mid+1, low+1);
                mid++;
                low++;

            }


        }

        return a;
    }

    private static int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}
