public class CyclicallySorted {

    public static int cyclicallySortedMin(int[] a) {
        if (a == null) {
            return -1;
        }
        int low = 0, high = a.length - 1, right = a[a.length - 1];
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= right && (mid == 0 || a[mid - 1] > a[mid])) {
                return mid;
            } else if (a[mid] > right) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] g = {4,5,6,1,2,3};
        System.out.println(cyclicallySortedMin(g));

    }

}
