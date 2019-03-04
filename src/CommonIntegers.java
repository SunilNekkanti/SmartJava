import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommonIntegers {


    public static void main(String[] args) {

        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {4, 5, 6, 7};

        int[] a3 = IntStream.concat(Arrays.stream(a1), Arrays.stream(a2)).toArray();

        Map<Integer, Long> mp = Arrays.stream(a3).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        IntStream.Builder a4 = IntStream.builder();

//        HashMap<Integer, Integer> hm = new HashMap<>();
//        for(int v : a3){
//            hm.merge(v, 1, Integer::sum);
//
//
//        }
//        System.out.println(hm);
//
        for (Map.Entry<Integer, Long> entry : mp.entrySet()) {
            if (entry.getValue() > 1) {
                a4.add(entry.getKey());
            }
        }
        System.out.println(Arrays.toString(a4.build().toArray()));


    }
}
