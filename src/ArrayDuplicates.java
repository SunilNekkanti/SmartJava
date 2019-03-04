import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDuplicates {

    public static boolean between(int i, int minValueInclusive, int maxValueInclusive) {
        return (i >= minValueInclusive && i <= maxValueInclusive);
    }


     public static void main(String[] args) {
         int[] sorted1 = {1, 2, 3, 5, 7, 9, 13, 19, 25, 35, 42};
         int[] sorted2 = {0, 3, 4, 5, 6, 11, 16, 23, 32};
         ArrayList<Integer> result = new ArrayList<Integer>();
         int index1 = 0;
         int index2 = 0;

         while (index2 < sorted2.length) {

             if (sorted1[index1] != sorted2[index2]) {
                 index1 = Arrays.binarySearch(sorted1, sorted2[index2]);
                 if (index1 < 0) {
                     index1 = -(index1 + 1);
                     if (between(index1, 0, sorted1.length-2)) {
                         index1++;
                     }
                 }
                 else {
                     result.add(sorted1[index1]);
                     if (between(index1, 0, sorted1.length-2) && between(index2, 0, sorted2.length-2)) {
                         index1++;
                         index2++;
                     }
                 }
             }
             else{
                 result.add(sorted1[index1]);
                 if (between(index1, 0, sorted1.length-2) && between(index2, 0, sorted2.length-2)) {
                     index1++;
                     index2++;
                 }
             }

         }
         System.out.println(result.toString());
     }






}


