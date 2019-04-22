public class UnknownArraySizeSearch {

    private static <A extends Comparable<A>> int binarySearchForLastIndex(A[] a,
                                                                          int low, int high) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            try {
                A temp = a[mid];
            } catch (ArrayIndexOutOfBoundsException e) { // mid is out of bounds,                go to lower half
                high = mid - 1;
                continue;
            }
            try {
                A temp = a[mid+1];
            } catch (ArrayIndexOutOfBoundsException e) { // mid + 1 is out of                bounds, mid is last index
                return mid;
            }
            low = mid + 1; // both mid and mid + 1 are inside array, mid is not            last index.
        }
        return -1; // this subarray does not have end of the array
    }
    public static <A extends Comparable<A>> int binarySearchOverRange(A[] a, A
            target, int low, int high) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid].compareTo(target) == 0) {
                return mid;
            } else if (a[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static <A extends Comparable<A>> int findWithUnknownLength(A[] a, A
            target) {
        if (a == null || a.length == 0 || target == null) {
            return -1;
        }
        int high = 1; // 1,2,4,8,16,32..
        int lastIndex = -1;
        while (true) { // consider putting a limit here, for e.g, dont go more      than index 1 million. Discuss with interviewer.
            try {
                A temp = a[high];
            } catch (ArrayIndexOutOfBoundsException e) {
                lastIndex = binarySearchForLastIndex(a, high/2, high);
                break;
            }
            high *= 2;
        }
        return binarySearchOverRange(a, target, 0, lastIndex);
    }

    public static void main(String[] args) {

        Integer[] g = {1,2,3,4,21,34,56,78,90,99};
        System.out.println(findWithUnknownLength(g, 78));


    }

}
