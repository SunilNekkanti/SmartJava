import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dhammu {

    public static void main(String[] s){
       String phrase = "Jack and jill went up the hill and Jack came rolling down";
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        Stream<String> stream = Stream.of(phrase.toLowerCase().split("\\W+"));

//        Map<String, Long> wordFreq = stream
//                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        //System.out.println(wordFreq);


        String[] mystr = phrase.split(" ");
//        List<Integer> li = Stream.of(mystr).map(i -> Collections.frequency(Arrays.asList(mystr), i)).collect(Collectors.toList());
////        System.out.println(li);
//        OptionalInt g = Stream.of(mystr).mapToInt(i -> Collections.frequency(Arrays.asList(mystr), i)).max();
//        System.out.println(g.getAsInt());
        for(String as: mystr)
        {
           hm.put(as, Collections.frequency(Arrays.asList(mystr), as));


        }


        Integer max = hm.entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getValue();
        System.out.println(max);
        List listOfMax = hm.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == Collections.max(hm.values()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(listOfMax);


        //Extracting Max Values

        //Sorting Map based on keys and values





    }

}
