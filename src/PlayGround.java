import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PlayGround {

    static int minSum(int[] arr) {
        int minSum = 1;

        for (int i = 0 ; i < arr.length ; i++) {
            if( minSum < arr[i]) {
                return minSum;
            } else {
                minSum += arr[i];
            }
        }
        return minSum;
    }

    public static Integer[] duplicates(int[] sorted1, int[] sorted2) {
        List<Integer> duplicates = new ArrayList<Integer>();
        for (int count = 0; count < sorted1.length; count++) {
            for (int counter = 0; counter < sorted2.length; counter++) {
                if (sorted1[count] == sorted2[counter]) {
                    duplicates.add(sorted1[count]);
                } else if (sorted1[count] < sorted2[counter]) {
                    break;
                }
            }
        }
        return duplicates.toArray(new Integer[duplicates.size()]);

    }

    // pick indices of  which sum upto the limit
    static int[] getIndicesOfItemWeights(int[] arr, int limit) {
        // your code goes here
        IntStream.Builder result = IntStream.builder();
        Map<Integer, List<Integer>> complementMap = new HashMap<Integer, List<Integer>>();
        int complementValue ;
        int weight ;
        for(int i=0; i<arr.length; i++) {
            weight = arr[i];
            complementValue = limit - weight;

            if (complementMap.containsKey(complementValue)) {
                complementMap.get(complementValue).add(i);
            }
            else {
               ArrayList<Integer> al = new ArrayList<Integer>();
               al.add(i);
                complementMap.put(complementValue, al );
            }

            if(complementMap.containsKey(weight)) {
                List<Integer> awl = complementMap.get(weight);
                Collections.reverse(awl);
                for(int index: awl){
                    if (i != index){
                        result.add(i);
                        result.add(index);
                        return result.build().toArray();
                    }
                }
            }

        }

        return result.build().toArray();
    }


    public static void main(String[] p){


//        int[] sorted1 = {1, 2, 3, 5, 7};
//        int[] sorted2 = {2, 4, 5, 6};
//
//        int[] f = getIndicesOfItemWeights(new int[]{3,2,5,4,5,6}, 8);
//
//        System.out.println(Arrays.toString(f));
ArrayList<Integer> li = new ArrayList<Integer>();
li.add(1);
li.add(2);
li.add(4);
        li.removeIf(i->i%2==0);
        System.out.println(li);
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(2,1);
        hm.put(2,2);
        hm.put(2,3);
        System.out.println(hm);
//
//        String str1 = "hello   'how,! are 465''you ..ra";
//
//        System.out.println(str1.replaceAll("[^a-zA-Z0-9\\s]",""));
//
////        String s2 = "how";
//
//        ArrayList<String> li = new ArrayList<>();
//
//        li.add("zabra");
//        li.add("sbion");
//        li.add("gcrse");
//        li.add("mdoku");
//
//        Comparator<String> mycmp = Comparator.comparing( s -> new Character(s.charAt(1)), Comparator.reverseOrder());
//        List<String> fg = li.stream().sorted(mycmp).collect(Collectors.toList());
//
//       // li.sort(secsort);
//        System.out.println(li);



    }
}
