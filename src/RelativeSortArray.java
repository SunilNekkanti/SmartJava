import java.util.*;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RelativeSortArray {



    public static Integer[] relativeSortArray(int[] arr1, int[] arr2) {

        Integer[] result = Arrays.stream(arr1).boxed().toArray(Integer[]::new);

        Map<Integer, Integer> array2Map = IntStream.range(0,arr2.length).boxed()
                                          .collect(Collectors.toMap(index-> arr2[index], index->index));

        Comparator<Integer> relativeSortComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer firstValue, Integer secondValue) {
                if(!array2Map.containsKey(firstValue) && !array2Map.containsKey(secondValue)){
                    return firstValue-secondValue;
                }
                 else{
                    return array2Map.getOrDefault(firstValue, arr2.length)-array2Map.getOrDefault(secondValue, arr2.length);
                }
            }
        };
        Arrays.sort(result,relativeSortComparator);
        return result;
    }




    public static void main(String[] args) {


        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19}, arr2 = {2,1,4,3,9,6};

        System.out.println(Arrays.toString(relativeSortArray(arr1,arr2)));


    }
}
