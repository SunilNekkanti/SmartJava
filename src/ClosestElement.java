public class ClosestElement {

    public static void main(String[] args) {

        int[] a = {1, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 10, 14, 15, 18};
        int target = 8;
        findClosestElement(a, target);


    }

    private static int findClosestElement(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        int previous_mid = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int foundValue = a[mid];
            previous_mid = record(a, mid, previous_mid, target);
            if (foundValue < target) {
                //search towards right
                low = mid + 1;
            } else if (foundValue > target) {
                //search towards left
                high = mid - 1;
            } else {
                    System.out.println(foundValue + " Found at position " + mid);
                    return foundValue;

            }


        }

        System.out.println(a[previous_mid]);
        return previous_mid;
    }

    private static int record(int[] a, int mid, int previous_mid, int target) {
        if(previous_mid == -1 || Math.abs(a[mid]-target) < Math.abs(a[previous_mid]-target)){
            return mid;
        }


        return previous_mid;
    }

}
