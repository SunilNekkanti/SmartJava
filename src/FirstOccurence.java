import java.util.Arrays;

public class FirstOccurence {


    public static void main(String[] args) {

        int[] a = {1, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 7,9 , 9};
        int target = 9;
        findFirstOccurence(a, target);

    }

    private static int findFirstOccurence(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int foundValue = a[mid];

            if (foundValue < target) {
                //search towards right
                low = mid + 1;
            } else if (foundValue > target) {
                //search towards left
                high = mid - 1;
            } else {
                if(a[mid-1] == target ){
                    high = mid-1;
                }
                else {
                    System.out.println(foundValue+" Found at position " + mid);

                    return foundValue;
                }
            }


        }
        return -1;

    }

}






