import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class DuplicatesinSorted {

    public static boolean between(int i, int minValueInclusive, int maxValueInclusive) {
        return (i >= minValueInclusive && i <= maxValueInclusive-1);
    }

  static int[] findDuplicates(int[] arr1, int[] arr2) {

      IntStream.Builder res = IntStream.builder();
    int index2 = 0;

    for (int i=0; i< arr1.length;i++){

        index2 = Arrays.binarySearch(arr2, arr1[i]);
        if(between(index2,0, arr2.length) && arr1[i] == arr2[index2]) {
            res.add(arr1[i]);
        }
    }

    return res.build().toArray();

  }

  public static void main(String[] args) {
      int[] arr1 = {1, 2, 3, 5, 6, 7};
      int[] arr2 = {3, 6, 7, 8, 20};

      int[] result = findDuplicates(arr1, arr2);

      Arrays.stream(result).forEach(System.out::println);
  }

}