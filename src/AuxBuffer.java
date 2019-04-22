import java.util.Arrays;

public class AuxBuffer {

    public static void printCombos(int[] a, int x) {
        if (a == null || a.length == 0 || x > a.length) return;
        int[] buffer = new int[x];
        printCombosHelper(a, buffer, 0, 0);
    }

    public static void printCombosHelper(int[] a, int[] buffer, int startIndex, int bufferIndex) {
        // termination cases - buffer full
        if (bufferIndex == buffer.length) {
            System.out.println(Arrays.toString(buffer));
            return;
        }
        if (startIndex == a.length) {
            return;
        }    // find candidates that go into current buffer index
           for (int i = startIndex; i < a.length; i++) {
               // place item into buffer
               buffer[bufferIndex] = a[i];        // recurse to next buffer index
               printCombosHelper(a, buffer, i + 1, bufferIndex + 1);
           }
    }


        public static void main (String[]args){

        int[] a = {1,2,3,4,5,6,7};
        int x = 3;
        printCombos(a, x);



        }
    }
