

class MazSubArraySum {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        printSubArrayOfRequiredSum(a, 6);

    }

    static int maxSubArraySum(int a[]) {
        int size = a.length;
        int currentindex = 0, end = 0, begin = 0;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {

            max_ending_here = max_ending_here + a[i];

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                begin = currentindex;
                end = i;

            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
                currentindex++;

            }
        }

        System.out.println("begin and end: " + begin + "&" + end);
        return max_so_far;
    }

    private static void printSubArrayOfRequiredSum(int[] array, int requiredSum) {
        for (int i = 0; i < array.length; i++) {
            String str = "[ ";
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum = sum + array[j];
                str = str + array[j] + ", ";
                if (sum == requiredSum) {
                    System.out.println(" sum : " + sum + " array : " + str
                            + "]");
                    str = "[ ";
                    sum = 0;
                }
            }
        }
    }
}