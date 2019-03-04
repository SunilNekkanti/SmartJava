import java.util.Arrays;

public class DutchFlag {


    public static int[] dutchSort(int[] a, int x){


    if(a==null || x<0 || x> a.length)
        System.out.println("Invalid");

    int pivot = a[x];
    int low = -1, mid = -1, high = a.length;
    while (mid+1 < high){
        if(a[mid+1] > pivot){
            swap(a, high-1, mid+1);
            high--;
        }
        else if (a[mid+1] == pivot){
            mid++;
        }
        else{
            swap(a, mid+1, low+1);
            mid++;
            low++;
        }
    }
        return a;

    }

    public static void swap(int[] a, int idx1, int idx2){
        int temp;
        temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;


    }

    public static void main(String[] args) {

        int[] a = {3,5,2,6,8,4,4,6,4,4, 3};
        int[] b = dutchSort(a, 1);
        System.out.println(Arrays.toString(b));

    }
}
